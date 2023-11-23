package com.hotelmanagementwizard.hotelmanager.config;

import com.hotelmanagementwizard.hotelmanager.exception.AppException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final UserAuthProvider userAuthProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(header != null) {
            String[] headers = header.split(" ");
            if(headers.length == 2 && headers[0].equals("Bearer")) {
                try {
                    SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateToken(headers[1]));
                } catch (Exception e) {
                    SecurityContextHolder.clearContext();
                    throw new AppException("Authentication failed !", HttpStatus.UNAUTHORIZED);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
