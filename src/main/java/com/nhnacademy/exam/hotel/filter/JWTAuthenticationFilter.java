package com.nhnacademy.exam.hotel.filter;


import com.nhnacademy.exam.hotel.controller.UserAuthzValidator;
import com.nhnacademy.exam.hotel.exception.UserAccessDeniedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JWTAuthenticationFilter implements Filter {

    @Value("${jwt.secretKey}")
    private String secretKey;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("Authorization");

        if(Objects.isNull(authorization) || !authorization.startsWith("Bearer ")) {
            throw new UserAccessDeniedException();
        }

        String accessToken = authorization.substring(7);

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(accessToken)
                    .getBody();

            Long userId = claims.get("userId", Long.class);
            if(UserAuthzValidator.isValid(userId)){
                filterChain.doFilter(request, response);
            }else{
                throw new UserAccessDeniedException();
            }
        } catch (Throwable throwable) {
            throw new UserAccessDeniedException();
        }
    }
}
