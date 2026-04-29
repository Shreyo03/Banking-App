package com.banking.Banking_System.Controller;

import com.banking.Banking_System.DTO.RequestDTO.CreateUserRequest;
import com.banking.Banking_System.DTO.ResponseDTO.UserResponse;
import com.banking.Banking_System.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;git
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    /*
    🧩 Requirements
        Your controller should:
        Accept request: CreateUserRequest
        Use: @Valid (VERY IMPORTANT)
        Call: UserService.createUser(...)
        Return: UserResponse
     */
    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest requestDto){
        UserResponse response = userService.createUser(requestDto);
        return ResponseEntity.ok(response);
    }

}
