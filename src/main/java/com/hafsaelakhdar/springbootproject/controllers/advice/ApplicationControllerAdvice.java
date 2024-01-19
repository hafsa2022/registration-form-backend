package com.hafsaelakhdar.springbootproject.controllers.advice;

import com.hafsaelakhdar.springbootproject.exceptions.PasswordMismatchException;
import com.hafsaelakhdar.springbootproject.exceptions.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String,String> handelException(MethodArgumentNotValidException exception){
        Map<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({UserAlreadyExistException.class})
    public Map<String,String> handelEmailException(UserAlreadyExistException exception){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("email",exception.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordMismatchException.class)
    public Map<String,String> handlePasswordMismatchException(PasswordMismatchException ex) {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("matchingPassword",ex.getMessage());
        return errorMap;
    }

}