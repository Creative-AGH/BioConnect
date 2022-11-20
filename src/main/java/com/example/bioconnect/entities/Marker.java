package com.example.bioconnect.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;

public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    //TYP
    CategoryOfWaste categoryOfWaste;
    Double howMuchBioWaste;

    @OneToMany
    Account account;

    //ACCOUNT
    LocalDate dateOfCreate;
    // DATA
    // KATEGORIA


    private Double x;//POZYCJE
    private Double y;

}
