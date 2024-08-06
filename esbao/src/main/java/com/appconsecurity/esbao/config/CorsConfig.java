package com.appconsecurity.esbao.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
                .allowCredentials(false)
                .maxAge(3600);


        registry.addMapping("/auth/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
                .allowCredentials(false)
                .maxAge(3600);
    }

}
