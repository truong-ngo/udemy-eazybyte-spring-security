package com.easybank.backend.security;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class AuthenticationLoggingFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            log.info("User with email: {}, is successfully authenticate and have authorities: {}", authentication.getName(), authentication.getAuthorities().toString());
        }
        chain.doFilter(request, response);
    }
}
