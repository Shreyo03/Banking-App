package com.banking.Banking_System.Controller;

import com.banking.Banking_System.DTO.RequestDTO.CreateAccountRequest;
import com.banking.Banking_System.DTO.ResponseDTO.AccountResponse;
import com.banking.Banking_System.Service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request){
        AccountResponse response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /*
    What controller should do
Accept:
@PathVariable Long userId
Call:
accountService.getAccountsByUser(userId)
Return:
List<AccountResponse>
     */
    @GetMapping("/users/{userId}/accounts")
    public List<AccountResponse> getUserAccounts(@PathVariable Long userId){
        List<AccountResponse> response = accountService.getAccountByUser(userId);
        return  response;
    }
}
