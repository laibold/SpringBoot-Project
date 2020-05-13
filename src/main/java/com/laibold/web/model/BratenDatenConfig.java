package com.laibold.web.model;

import com.laibold.web.tools.converter.LocalDateConverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BratenDatenConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry reg) {
        reg.addConverter(new LocalDateConverter());
    }
}