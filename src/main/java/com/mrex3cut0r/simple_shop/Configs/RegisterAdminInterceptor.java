package com.mrex3cut0r.simple_shop.Configs;

import com.mrex3cut0r.simple_shop.Interceptors.AdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RegisterAdminInterceptor implements WebMvcConfigurer {
    @Autowired
    private AdminInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/admin/**");
    }
}
