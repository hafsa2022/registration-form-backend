package com.hafsaelakhdar.springbootproject.dto;

import com.hafsaelakhdar.springbootproject.customvalidations.PasswordMatches;
import com.hafsaelakhdar.springbootproject.customvalidations.ValidEmail;
import com.hafsaelakhdar.springbootproject.customvalidations.ValidPasswordCharacters;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@PasswordMatches
public class UserDto {
    @NotNull
    @NotBlank(message = "fullname shouldn't be empty")
    private String fullname;

    @ValidPasswordCharacters
    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotBlank(message = "email shouldn't be empty")
    private String email;


    public UserDto(String fullname, String password, String matchingPassword, String email) {
        this.fullname = fullname;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public UserDto() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
