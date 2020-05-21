package com.laibold.web.tools.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class AddressValidator implements ConstraintValidator<Address, String> {

    String pattern;

    @Override
    public void initialize(Address constraintAnnotation) {
        pattern = "(((\\p{L})|-)+( )*)* [0-9]+(\\w)*, [0-9]{5} (((\\p{L})|-)+( )*)*";
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches(pattern, value);
    }

}
