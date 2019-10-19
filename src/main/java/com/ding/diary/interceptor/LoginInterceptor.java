package com.ding.diary.interceptor;

import com.ding.diary.anno.Anonymous;
import com.ding.diary.entity.LoginUser;
import com.ding.diary.exception.CustomException;
import com.ding.diary.exception.UnLoginException;
import com.ding.diary.util.JwtTokenUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: LoginInterceptor
 * @author: ding
 * @date: 2019/10/16 8:58
 * @version: 1.0
 */

@Configuration
public class LoginInterceptor implements HandlerInterceptor {


    private final static ThreadLocal<LoginUser> THREAD_LOCAL = new ThreadLocal<LoginUser>();

    private Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        } else if (handler instanceof HandlerMethod) {

            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Anonymous annotation = handlerMethod.getBeanType().getAnnotation(Anonymous.class);
            if (annotation != null) return true;
            Anonymous methodAnnotation = handlerMethod.getMethodAnnotation(Anonymous.class);
            if (methodAnnotation != null) return true;

            String token = request.getHeader("token");
            if (token == null || token.equals("")) {
                log.error("您未登录");
                throw new UnLoginException();
            }
            Claims claims = JwtTokenUtils.phaseToken(token);
            String name = (String) claims.get("username");
            Number id = (Number) claims.get("id");
            if (name == null || name.equals("")) throw new CustomException("token有误");
            LoginUser user = new LoginUser(name, id.longValue());
            THREAD_LOCAL.set(user);
            return true;
        }
        return false;
    }


    public static LoginUser getUser() {
        return THREAD_LOCAL.get();
    }

}
