package com.example.bioconnect.repositories;

import com.example.bioconnect.entities.TokenToRegister;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TokenToRegisterRepository extends PagingAndSortingRepository<TokenToRegister, String> {
}
