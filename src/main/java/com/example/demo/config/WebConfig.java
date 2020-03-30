package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration //配置类 一定是和拦截器配合使用
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor; //拦截器实例化

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(
                "/page/*.html","/css/**","/js/**","/images/**",
                "/swagger-resources/**","/login","/swagger-ui.html",
                "/webjars/springfox-swagger-ui/**","/error/**","/register","/testTimerTask");
    }

}
