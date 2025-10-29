package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                // 모든 경로
                .allowedOriginPatterns("*")      // 모든 origin 허용
                .allowedMethods("*")             // 모든 HTTP 메서드 허용
                .allowedHeaders("*")             // 모든 헤더 허용
                .allowCredentials(true);         // 쿠키/인증 정보 허용
    }


    /* 
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로
                .allowedOrigins("*") // 허용할 출처  http://localhost:3000","http://127.0.0.1:5500/
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowedHeaders("*") // 모든 헤더 허용
                .allowCredentials(true); // 인증정보(쿠키 등) 허용 시 true
    }*/
}