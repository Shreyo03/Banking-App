package com.banking.Banking_System.DTO.RequestDTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    @Size(min = 4)
    private String password;
}
