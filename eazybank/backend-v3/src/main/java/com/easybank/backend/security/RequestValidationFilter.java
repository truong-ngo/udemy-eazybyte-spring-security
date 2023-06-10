package com.easybank.backend.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RequestValidationFilter implements Filter {

    private final String AUTHORIZATION = "Authorization";
    private final String BASIC = "Basic";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String header = req.getHeader(AUTHORIZATION);
        if (header != null) {
            header = header.trim();
            if (StringUtils.startsWithIgnoreCase(header, BASIC)) {
                byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
                byte[] decode;
                try {
                    decode = Base64.getDecoder().decode(base64Token);
                    String token = new String(decode, StandardCharsets.UTF_8);
                    int delim = token.indexOf(":");
                    if (delim == -1) {
                        throw new BadCredentialsException("Invalid authentication token");
                    }
                    String email = token.substring(0, delim);
                    if (email.toLowerCase().contains("test")) {
                        throw new BadCredentialsException("Invalid email");
                    }
                } catch (IllegalArgumentException e) {
                    throw new BadCredentialsException("Cannot decode token");
                }
            }
        }
        chain.doFilter(req, res);
    }
}
