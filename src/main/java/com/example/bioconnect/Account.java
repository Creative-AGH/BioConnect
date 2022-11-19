package com.example.bioconnect;

import com.example.bioconnect.entities.BioWasteHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    public Account(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @OneToMany//(mappedBy = "item") //one item can have many of histories
    @JoinColumn(name="itemId") //it indicates a mapped column from Many side //foreign key in history table
    List<BioWasteHistory> history = new ArrayList<>(); //FIXME we dont know if we do that with aspect concept of programming

    public List<BioWasteHistory> getHistory() {
        return history;
    }
}
