//package com.appconsecurity.esbao.config;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//public class CustomCorsFilter extends OncePerRequestFilter {
//
//    private final List<String> allowedOrigins;
//
//    public CustomCorsFilter(String[] allowedOrigins) {
//        this.allowedOrigins = Arrays.asList(allowedOrigins);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String origin = request.getHeader("Origin");
//
//        if (allowedOrigins.contains(origin)) {
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
//            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
//            response.setHeader("Access-Control-Expose-Headers", "xsrf-token");
//            response.setHeader("Access-Control-Allow-Credentials", "true");
//            response.setHeader("Access-Control-Max-Age", "3600");
//        }
//
//        if ("OPTIONS".equals(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            filterChain.doFilter(request, response);
//        }
//    }
//
//}
