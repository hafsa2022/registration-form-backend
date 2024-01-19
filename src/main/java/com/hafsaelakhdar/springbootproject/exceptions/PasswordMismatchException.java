package com.hafsaelakhdar.springbootproject.exceptions;

public class PasswordMismatchException extends RuntimeException{

    public PasswordMismatchException(String message) {
        super(message);
    }
}
