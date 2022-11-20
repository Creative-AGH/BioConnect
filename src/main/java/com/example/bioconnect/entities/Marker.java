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


    private Double x;//POZYCJE
    private Double y;

}
