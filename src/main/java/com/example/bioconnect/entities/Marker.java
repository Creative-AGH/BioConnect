package com.example.bioconnect.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    //TYP
    CategoryOfWaste categoryOfWaste;
    Double howMuchBioWaste;

    @ManyToOne
    Account account;

    //ACCOUNT
    LocalDate dateOfCreate;
    // DATA
    // KATEGORIA


    public Marker(String description, CategoryOfWaste categoryOfWaste, Double howMuchBioWaste, Account account, LocalDate dateOfCreate, Double x, Double y) {
        this.description = description;
        this.categoryOfWaste = categoryOfWaste;
        this.howMuchBioWaste = howMuchBioWaste;
        this.account = account;
        this.dateOfCreate = dateOfCreate;
        this.x = x;
        this.y = y;
    }

    private Double x;//POZYCJE
    private Double y;

}
