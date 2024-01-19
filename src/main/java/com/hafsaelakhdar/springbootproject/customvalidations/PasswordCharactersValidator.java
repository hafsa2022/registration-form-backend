package com.hafsaelakhdar.springbootproject.customvalidations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCharactersValidator implements ConstraintValidator<ValidPasswordCharacters, String> {

    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;
    //private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?!.*(.)\\1{1,}).{" + MIN_LENGTH + "," + MAX_LENGTH + "}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{" + MIN_LENGTH + "," + MAX_LENGTH + "}$";

    @Override
    public void initialize(ValidPasswordCharacters constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password != null && isPasswordValid(password);
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH && matchesPattern(password);
    }

    private boolean matchesPattern(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
