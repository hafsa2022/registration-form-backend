package com.hafsaelakhdar.springbootproject.customvalidations;

import com.hafsaelakhdar.springbootproject.dto.UserDto;
import com.hafsaelakhdar.springbootproject.exceptions.PasswordMismatchException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserDto user = (UserDto) obj;

        if (!user.getPassword().equals(user.getMatchingPassword())) {
            throw new PasswordMismatchException("Passwords do not match");
        }

        return true;
    }
}