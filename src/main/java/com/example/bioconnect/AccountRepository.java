package com.example.bioconnect;

import com.example.bioconnect.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,String> {
    Account findByEmail(String email);
    boolean existsAccountByEmail(String email);
}
