package com.flab.kream.enumeration;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = EnumPatternValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumPattern {
    String regexp();

    String message() default "유효하지 않는 값입니다.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
