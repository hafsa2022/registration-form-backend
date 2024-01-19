package com.hafsaelakhdar.springbootproject.exceptions;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
