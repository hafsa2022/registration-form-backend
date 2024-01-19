package com.hafsaelakhdar.springbootproject.customvalidations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordCharactersValidator.class)
public @interface ValidPasswordCharacters {
    String message() default "Password must be at least 8 characters,\n" +
            " less than 20 characters,\n" +
            " mix of uppercase and lowercase letters,\n" +
            " at least one number (0-9)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}