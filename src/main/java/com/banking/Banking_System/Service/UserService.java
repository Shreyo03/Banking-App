package com.banking.Banking_System.Service;

import com.banking.Banking_System.DTO.RequestDTO.CreateUserRequest;
import com.banking.Banking_System.DTO.ResponseDTO.UserResponse;
import com.banking.Banking_System.Entity.User;
import com.banking.Banking_System.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    /*
   1. Receive CreateUserRequest
2. Create new User entity
3. Set fields (name, email, password)
4. Save using UserRepository
5. Convert saved User → UserResponse
6. Return response
     */
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponse createUser(CreateUserRequest requestDto){

        //Checking for duplicate email in DB
        if(userRepository.existsByEmail(requestDto.getEmail())){
            throw new RuntimeException("Email already exists for:" + requestDto.getEmail());
        }

        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());

        //Saved data in DB
        User savedUser = userRepository.save(user);

        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());

        return response;
    }
}
