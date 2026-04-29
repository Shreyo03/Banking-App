package com.banking.Banking_System.Repository;

import com.banking.Banking_System.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
