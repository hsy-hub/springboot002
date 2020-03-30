package com.example.demo.config;

import com.example.demo.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        String token = request.getHeader("Authorization");
        if (token != null){
            token = token.substring(7); //去掉Bearer加空格
            if (JwtUtil.verity(token)){
                return true;
            }else{
                response.sendError(401,"权限不足，请重新登录");
                return false;
            }
        }else{
            response.sendError(401,"权限不足，请重新登录");
            return false;
        }
    }
}

