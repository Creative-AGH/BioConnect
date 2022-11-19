package com.example.bioconnect.security;


import com.example.bioconnect.entities.Account;
import com.example.bioconnect.Role;
import com.example.bioconnect.security.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> userOptional = loginService.findByEmailTeam(username);
        if (userOptional.isPresent()) {

            Account user = userOptional.get();
            String[] roles;
            roles = Optional.of(user.getRole()).stream().map(Role::toString).toArray(String[]::new);
            return User
                    .builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(roles)
                    .build();

        } else {
            return null;
        }


    }
}
