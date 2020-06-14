package com.laibold.web.model.exception;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.ResourceBundle;

public class BratenNichtVorhandenException extends RuntimeException {
    public BratenNichtVorhandenException() {
        super(ResourceBundle.getBundle("messages", LocaleContextHolder.getLocale()).getString("roast.notFound"));
    }
}
