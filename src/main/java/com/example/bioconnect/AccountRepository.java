package com.example.bioconnect;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,String> {
    Account findByEmail(String email);
}