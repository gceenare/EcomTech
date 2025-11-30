package com.curiousity.tech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // serve uploaded images from file-system folder 'uploads' under project root
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}
