package com.seb41_pre_014.auth.fileter;

import com.seb41_pre_014.auth.JwtTokenizer;
import com.seb41_pre_014.util.CustomAuthorityUtils;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SignatureException;
import java.util.List;
import java.util.Map;

// OncePerRequestFilter: request 당 한 번만 수행되는 Filter. JWT 전용으로 사용하기 적절하다.
@RequiredArgsConstructor
public class JwtVerificationFilter extends OncePerRequestFilter {

    private final JwtTokenizer jwtTokenizer;    // Claims(토큰에 포함된 정보)를 얻기위해 사용
    private final CustomAuthorityUtils authorityUtils;  // 객체에 채울 사용자의 권한을 생성하는데 사용

    // shouldNotFilter: 특정 조건에 부합하면(true이면) 해당 Filter의 동작을 수행하지 않고 다음 Filter로 건너뛴다.
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String authorization = request.getHeader("Authorization");

        return authorization == null || !authorization.startsWith("Bearer");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            Map<String, Object> claims = verfyJws(request);
            setAuthenticationToContext(claims);
        } catch (ExpiredJwtException ee) {
            request.setAttribute("exception", ee);
        } catch (Exception e) {
            request.setAttribute("exception", e);
        }

        filterChain.doFilter(request, response);
    }

    private Map<String, Object> verfyJws(HttpServletRequest request) {
        // request의 header에서 JWT를 얻는다.
        String jws = request.getHeader("Authoriztion").replace("Bearer", "");
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());
        Map<String, Object> claims = jwtTokenizer.getClaims(jws, base64EncodedSecretKey).getBody();

        return claims;
    }

    private void setAuthenticationToContext(Map<String, Object> claims) {
        String username = (String) claims.get("username");
        List<GrantedAuthority> authorities = authorityUtils.createAuthorities((List) claims.get("roles"));
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
