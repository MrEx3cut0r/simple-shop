package com.mrex3cut0r.simple_shop.Interceptors;

import com.mrex3cut0r.simple_shop.tools.jwtToken;

import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object isAdmin = jwtToken.get_username(request);

        if (isAdmin == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized.");
            return false;
        }

        if (!isAdmin.equals("admin")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied.");
            return false;
        }
        return true;
    }
}
