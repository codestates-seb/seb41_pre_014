package com.seb41_pre_014.config;

import com.seb41_pre_014.auth.JwtTokenizer;
import com.seb41_pre_014.auth.fileter.JwtAuthenticationFilter;
import com.seb41_pre_014.auth.fileter.JwtVerificationFilter;
import com.seb41_pre_014.auth.handler.MemberAccessDeniedHandler;
import com.seb41_pre_014.auth.handler.MemberAuthenticationEntryPoint;
import com.seb41_pre_014.auth.handler.MemberAuthenticationFailureHandler;
import com.seb41_pre_014.auth.handler.MemberAuthenticationSuccessHandler;
import com.seb41_pre_014.util.CustomAuthorityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
//@EnableWebSecurity(debug = true)
public class SecurityConfiguration {

    private final CorsFilter corsFilter;
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers()
                .and()
                .csrf().disable()   // Cross-Site Request Forgery 공격에 대한 설정 비활성화
//                .cors(withDefaults())   // CORS 설정 추가
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 stateless하게 설정
                .and()
                .formLogin().disable()  // CSR 방식 로그인을 위해 폼 로그인 방식 비활성화
                .httpBasic().disable()  // Request를 전송할 때마다 Username/Password 정보를 HTTP Header에 실어서 인증하는 방식 비활성화
                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())
                .accessDeniedHandler(new MemberAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigurer())    // Custom한 Configurer 추가
                .and()
                .authorizeHttpRequests(authorize -> authorize
//                        .antMatchers(HttpMethod.GET, "/*/members").permitAll()
//                        .antMatchers(HttpMethod.PATCH, "/*/members/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.GET, "/*/members").hasRole("ADMIN")
//                        .antMatchers(HttpMethod.POST, "/*/votes").hasRole("ADMIN")
//                        .antMatchers(HttpMethod.POST, "/*/bookmarks").hasRole("ADMIN")
//                        .antMatchers(HttpMethod.GET, "/*/members/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.DELETE, "/*/members/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.POST, "/*/boards/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.PATCH, "/*/boards/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.DELETE, "/*/boards/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.DELETE, "/*/boards/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.POST, "/*/votes/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.GET, "/*/votes/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.POST, "/*/bookmarks/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.GET, "/*/bookmarks/**").hasAnyRole("USER", "ADMIN")
//                        .antMatchers(HttpMethod.POST, "/*/tags/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().permitAll());

        return http.build();
    }

    @Bean
    // PasswordEncoder Bean 객체 생성
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");    // 모든 출처에 대해 HTTP 통신을 허용
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE"));   // 파라미터로 지정한 HTTP Method에 대한 HTTP 통신 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    // JwtAuthenticatonFileter를 등록하는 역할을 하는 클래스
    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {
        // Configuration 커스터마이징
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            // AuthenticationManager 객체 획득
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtTokenizer);

            // 기본 request URL인 "/login"을 변경
            jwtAuthenticationFilter.setFilterProcessesUrl("/auth/login");
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer, authorityUtils);
            // JwtAuthenticationFilter를 Spring Security Filter Chain에 추가
            builder
                    .addFilter(corsFilter)
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);

        }
    }

}
