package com.example.bioconnect.register;

import com.example.bioconnect.entities.Account;
import com.example.bioconnect.AccountRepository;
import com.example.bioconnect.RandomIdHandler;
import com.example.bioconnect.entities.Role;
import com.example.bioconnect.entities.TokenToRegister;
import com.example.bioconnect.register.dto.RegisterMapper;
import com.example.bioconnect.register.dto.RegisterNewAccountDto;
import com.example.bioconnect.repositories.TokenToRegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterService {
    private final AccountRepository accountRepository;
    private final RegisterMapper registerMapper;
    private final TokenToRegisterRepository tokenToRegisterRepository;
    private final RandomIdHandler randomIdHandler;
    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    @Transactional
    public void registerNewAccount(RegisterNewAccountDto registerNewAccountDto) {
        String newAccountEmail = registerNewAccountDto.getEmail();
        boolean doesSuchAccountAlreadyExist = accountRepository.existsAccountByEmail(newAccountEmail);
        if (!doesSuchAccountAlreadyExist) {
            Account account = registerMapper.mapRegisterNewAccountDtoToAccount(registerNewAccountDto);
            account.setPassword(passwordEncoder.encode(registerNewAccountDto.getPassword()));
            account.setRole(Role.USER);
            String generatedToken = randomIdHandler.generateUniqueIdFromTable(tokenToRegisterRepository);
            TokenToRegister tokenToRegister = new TokenToRegister(generatedToken, account);

            try {
                emailService.sendMail(registerNewAccountDto, tokenToRegister.getToken());
                accountRepository.save(account);
                tokenToRegisterRepository.save(tokenToRegister);
            } catch (Exception e) {
                accountRepository.delete(account);

                log.error("Unable to create account due to reason {} ", e.getMessage());
            }

        } else {
            log.error("Account with such email {} already exist", newAccountEmail);
            throw new RuntimeException(String.format("Account with such email %s already exist", newAccountEmail));
        }
    }

    public boolean verifyEmail(String token) {
        Optional<TokenToRegister> optionalToken = tokenToRegisterRepository.findById(token);
        if (optionalToken.isEmpty())
            return false;
        else {
            TokenToRegister tokenToRegister = optionalToken.get();
            Account account = tokenToRegister.getAccount();
            account.setVerified(true);
            accountRepository.save(account);
            tokenToRegisterRepository.delete(tokenToRegister);
            log.info("Account {} now has verified email", account.getEmail());
            return true;
        }
    }
}
