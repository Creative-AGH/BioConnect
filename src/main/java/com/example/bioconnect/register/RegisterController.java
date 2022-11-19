package com.example.bioconnect.register;

import com.example.bioconnect.register.dto.RegisterNewAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/all/register")
    public ResponseEntity<?> register(RegisterNewAccountDto registerNewAccountDto) {
        registerService.registerNewAccount(registerNewAccountDto);
        return ResponseEntity.noContent().build(); //TODO change to ok status with a body
    }
    @GetMapping("/all/validate")
    public ResponseEntity<Boolean> verifyEmail(String token) {
        boolean response = registerService.verifyEmail(token);
        if (!response)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }
}