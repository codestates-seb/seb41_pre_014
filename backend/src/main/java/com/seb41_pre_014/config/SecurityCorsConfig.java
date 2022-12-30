package com.seb41_pre_014.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityCorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("http://localhost:8081"); //특정패턴의 origin만 허용
        config.addAllowedOriginPattern("http://localhost:3000");
        config.addAllowedOriginPattern("http://localhost:8080");
        config.addAllowedHeader(""); //특정 header만 허용
        config.addAllowedMethod(""); //특정 메소드만 허용 //
        config.addExposedHeader("Authorization");
//        config.addExposedHeader("*"); //추가헤더,커스텀 헤더를 지정
        source.registerCorsConfiguration("/**", config); //corsConfiguration으로 등록

        return new CorsFilter(source);
    }
}