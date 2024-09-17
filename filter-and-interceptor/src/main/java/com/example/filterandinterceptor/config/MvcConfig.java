package com.example.filterandinterceptor.config;

import com.example.filterandinterceptor.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// @RequiredArgsConstructor 로 autowired 생성자 자동 생성 가능
public class MvcConfig implements WebMvcConfigurer {

    private static final String[] DEFAULT_EXCLUDE_PATH = {
            "/api/ping",
    };

    private final AuthInterceptor authInterceptor;


    public MvcConfig(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
