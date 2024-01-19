package com.hafsaelakhdar.springbootproject.controllers;

import com.hafsaelakhdar.springbootproject.dto.UserDto;
import com.hafsaelakhdar.springbootproject.entities.User;
import com.hafsaelakhdar.springbootproject.exceptions.UserAlreadyExistException;
import com.hafsaelakhdar.springbootproject.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = "user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addUser(@Valid @RequestBody UserDto userDto) throws UserAlreadyExistException {
          userService.addUser(userDto);

    }

}
