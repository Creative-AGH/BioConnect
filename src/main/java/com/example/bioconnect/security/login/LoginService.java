package com.example.bioconnect.security.login;

import com.example.bioconnect.entities.Account;
import com.example.bioconnect.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AccountRepository accountRepository;

    public Optional<Account> findByEmailTeam(String username) {
        Optional<Account> optionalRegisterTeam = Optional.ofNullable(accountRepository.findByEmail(username));
        return optionalRegisterTeam;

    }


}
