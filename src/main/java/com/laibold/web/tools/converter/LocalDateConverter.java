package com.laibold.web.tools.converter;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;

public class LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String dateString) {
        return LocalDate.parse(dateString);
    }
    
}