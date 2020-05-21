package com.laibold.web.tools.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddressValidator.class)
@Documented
public @interface Address {
    String message() default "Keine gueltige Addresse";
    // optionale Zusatzinfos
    Class<? extends Payload>[] payload() default { };
    // Zuordnung zu Validierungsgruppen?
    Class<?>[] groups() default { };
}
