package com.example.bioconnect;

import com.example.bioconnect.account.dto.GetAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/account/{email}")
    private GetAccountDto getAccountByEmail(@RequestParam String email)
    {
        return accountService.getAccountDto(email);
    }
}
