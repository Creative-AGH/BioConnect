package com.example.bioconnect;

import com.example.bioconnect.entities.Account;
import com.example.bioconnect.entities.BioWaste;
import com.example.bioconnect.entities.Composter;
import com.example.bioconnect.entities.Role;
import com.example.bioconnect.repositories.BioWasteRepository;
import com.example.bioconnect.repositories.ComposterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class StartAndTestThingsSeed {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final BioWasteRepository bioWasteRepository;
    private final ComposterRepository composterRepository;


    public void fillData() {
        createTestAccount();
        createTestComposter();
        createTestBioWaste();
    }

    private void createTestBioWaste() {
        if (bioWasteRepository.count() == 0) {
            //BioWaste(Long id, String name, String description, Double howMuchBioWaste, LocalDateTime dateOfCreation) {
            bioWasteRepository.save(new BioWaste(1L, "bioWaste1", "desc1", 5.0, LocalDateTime.now()));
            bioWasteRepository.save(new BioWaste(2L, "bioWaste2", "desc2", 7.0, LocalDateTime.now()));
            bioWasteRepository.save(new BioWaste(3L, "bioWaste3", "desc3", 3.0, LocalDateTime.now()));
        }
    }

    private void createTestComposter() {
        if (composterRepository.count() == 0) {
            composterRepository.save(new Composter(1L, "bioComposter1", "description1", 1.23, 1.23, 100.0, 10.0));
            composterRepository.save(new Composter(2L, "bioComposter2", "description2", 1.23, 1.23, 200.0, 20.0));
            composterRepository.save(new Composter(3L, "bioComposter3", "description3", 1.23, 1.23, 300.0, 30.0));
        }
    }


    private void createTestAccount() {
        if (accountRepository.count() == 0) {
            Account adam = new Account("adam", passwordEncoder.encode("123"), true, 8000);
            adam.setRole(Role.ADMIN);
            accountRepository.save(adam);
            Account admin = new Account("admin@gmail.com", passwordEncoder.encode("admin"), true, 200);
            admin.setRole(Role.ADMIN);
            accountRepository.save(admin);
            Account moderator = new Account("moderator@gmial.com", passwordEncoder.encode("mod"), true, 50);
            moderator.setRole(Role.MODERATOR);
            accountRepository.save(moderator);
            Account user = new Account("user@gmial.com", passwordEncoder.encode("user"), true, 3000);
            user.setRole(Role.USER);
            accountRepository.save(user);
        }
    }
}
