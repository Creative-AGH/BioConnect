package com.example.bioconnect.Marker.dto;

import com.example.bioconnect.entities.CategoryOfWaste;
import lombok.Data;

import java.time.LocalDate;
@Data
public class MarkerInputDto {
    private String description;
    //TYP
    CategoryOfWaste categoryOfWaste;
    Double howMuchBioWaste;


    Long accountId;

    //ACCOUNT
    LocalDate dateOfCreate;
    // DATA
    // KATEGORIA


    private Double x;//POZYCJE
    private Double y;
}
