package com.ding.diary.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: RegisterInterceptor
 * @author: ding
 * @date: 2019/10/16 18:05
 * @version: 1.0
 */

@Configuration
public class RegisterInterceptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("js/**","css/**","images/**"
                        ,"/swagger-resources/**"
                        , "/webjars/**"
                        , "/v2/**"
                        , "/swagger-ui.html/**"
                        , "/error"
                );
    }
}
