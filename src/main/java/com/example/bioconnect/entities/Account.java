package com.example.bioconnect.entities;

import com.example.bioconnect.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String email;
    private String password;
    @Enumerated
    private Role role;

    private double availableCash;

    public Account(String email, String password, boolean isVerified, double availableCash) {
        this.email = email;
        this.password = password;
        this.isVerified = isVerified;
        this.availableCash = availableCash;
    }

    public Account(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    boolean isVerified;

    @OneToMany
    List<BioWasteHistory> history = new ArrayList<>(); //FIXME we dont know if we do that with aspect concept of programming
}
