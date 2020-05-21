package com.laibold.web.tools.converter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String dateString) {
        LocalDate date = null;
        try {
            date = LocalDate.parse(dateString);
        } catch (DateTimeParseException ex) {
            // Just to ensure date is null instead of throwing an exception
            // Validation is taking care of this
        }
        return date;
    }

}