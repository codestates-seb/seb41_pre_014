package com.seb41_pre_014.auth.fileter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seb41_pre_014.auth.JwtTokenizer;
import com.seb41_pre_014.auth.dto.LoginDto;
import com.seb41_pre_014.member.dto.MemberDto;
import com.seb41_pre_014.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 로그인 인증 요청을 처리하는 클래스
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenizer jwtTokenizer;

    // 인증을 시도하는 메서드. 인증을 시도하는 로직을 구현하면 된다.
    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // 클라이언트에서 전송한 Username과 Password를 DTO클래스로 역직렬화
        ObjectMapper objectMapper = new ObjectMapper();
        LoginDto loginDto = objectMapper.readValue(request.getInputStream(), LoginDto.class);

        // Username과 Password 정보를 포함한 Token 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        // AuthenticationManager에게 전달하면서 인증 처리
        return authenticationManager.authenticate(authenticationToken);
    }

    // 클라이언트의 인증 정보를 이용해 인증에 성공할 경우 호출하는 메서드
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        // getPrincipal() 메서드로 Member 엔티티를 얻는다.
        // AuthenticationManager 내부에서 인증에 성공하면 인증된 Authenticaton 객체가 생성되면서 principal 필드에 Member 객체가 할당되기 때문이다.
        Member member = (Member) authResult.getPrincipal();

        // Access Token과 Refresh Token 생성
        String accessToken = delegateAccessToken(member);
        String refreshToken = delegateRefreshToken(member);

        response.setHeader("Authorization", "Bearer" + accessToken);
        response.setHeader("Refresh", refreshToken);

//        // JWT 쿠키 저장
//        Cookie cookie =
//        response.addCookie();
        this.getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
    }

    private String delegateAccessToken(Member member) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", member.getEmail());
        claims.put("roles", member.getRoles());

        String subject = member.getEmail();
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getAccessTokenExpirationMinutes());

        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }

    private String delegateRefreshToken(Member member) {
        String subject = member.getEmail();
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getRefreshTokenExpirationMinutes());
        String base64EncdedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        String refreshToken = jwtTokenizer.generateRefreshToken(subject, expiration, base64EncdedSecretKey);

        return refreshToken;
    }
}
