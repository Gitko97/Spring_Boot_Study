package com.example.filterandinterceptor.interceptor;

import com.example.filterandinterceptor.annotation.AuthUser;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean validAuthUser = checkValidAccessAnnotation(handler, AuthUser.class);    // annotation 검사
        System.out.println("annotation check : " + validAuthUser);

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build().toUri();

        if (validAuthUser) {  // 특정 쿼리 검사
            String queryString = uri.getQuery();
            if (queryString.equals("name=111")) {
                return true;
            }

            return false;
        }

        return true;
    }

    private boolean checkValidAccessAnnotation(Object handler, Class clazz) {

        if (handler instanceof ResourceHttpRequestHandler) {
            System.out.println("리소스 요청 class " + clazz.getName());
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            System.out.println("어노테이션 체크 class " + clazz.getName());
            return true;
        }

        return false;
    }
}
