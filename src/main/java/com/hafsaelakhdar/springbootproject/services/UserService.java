package com.hafsaelakhdar.springbootproject.services;

import com.hafsaelakhdar.springbootproject.dto.UserDto;
import com.hafsaelakhdar.springbootproject.entities.User;
import com.hafsaelakhdar.springbootproject.exceptions.UserAlreadyExistException;
import com.hafsaelakhdar.springbootproject.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User addUser(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + userDto.getEmail());
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFullname(userDto.getFullname());
        user.setPassword(userDto.getPassword());
        return this.userRepository.save(user);

    }
    private boolean emailExists(String email) {
        return userRepository.findByEmail(email)!=null;
    }
}
