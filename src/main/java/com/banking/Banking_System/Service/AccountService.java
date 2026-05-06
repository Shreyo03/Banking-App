package com.banking.Banking_System.Service;

import com.banking.Banking_System.DTO.RequestDTO.CreateAccountRequest;
import com.banking.Banking_System.DTO.ResponseDTO.AccountResponse;
import com.banking.Banking_System.Entity.Account;
import com.banking.Banking_System.Entity.User;
import com.banking.Banking_System.Repository.AccountRepository;
import com.banking.Banking_System.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public AccountService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }
    
    //For POST Mapping
    public AccountResponse createAccount(CreateAccountRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow( () -> new RuntimeException("User does not exist for ID:"+request.getUserId()));

        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setBalance(request.getBalance());

        //Linking Account to User
        account.setUsers(user);

        Account savedAccount = accountRepository.save(account);

        AccountResponse response = new AccountResponse();
        response.setAccountNumber(savedAccount.getAccountNumber());
        response.setBalance(savedAccount.getBalance());
        response.setUserId(savedAccount.getUsers().getId());
        response.setId(savedAccount.getId());

        return response;
    }

    //For Get Mapping
    public List<AccountResponse> getAccountByUser(Long userId){
        List<Account> account = accountRepository.findByUserId(userId);

        List<AccountResponse> accountDetail = new ArrayList<>();
        for(Account account1: account){
            AccountResponse response = new AccountResponse();
            response.setId(account1.getId());
            response.setAccountNumber(account1.getAccountNumber());
            response.setBalance(account1.getBalance());
            response.setUserId(account1.getUsers().getId());

            accountDetail.add(response);
        }
        return accountDetail;
    }
}