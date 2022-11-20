package com.example.bioconnect;

import com.example.bioconnect.account.dto.AccountMapper;
import com.example.bioconnect.account.dto.GetAccountDto;
import com.example.bioconnect.entities.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    public GetAccountDto getAccountDto(String email)
    {
        Account account = accountRepository.findByEmail(email);
        return accountMapper.mapAccountToGetAccountDto(account);
    }
}
