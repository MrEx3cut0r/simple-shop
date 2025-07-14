package com.mrex3cut0r.simple_shop.Interceptors;

import com.mrex3cut0r.simple_shop.tools.jwtToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Object user = jwtToken.get_username(request);
        if (user == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthorized");
            return false;
        }
        return true;
    }
}
