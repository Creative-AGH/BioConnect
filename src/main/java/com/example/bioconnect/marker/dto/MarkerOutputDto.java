package com.example.bioconnect.marker.dto;

import com.example.bioconnect.entities.CategoryOfWaste;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MarkerOutputDto {
    Long id;
    String description;

    CategoryOfWaste categoryOfWaste;
    Double howMuchBioWaste;


    String accountId;
    LocalDate dateOfCreate;


    private Double x;
    private Double y;
}
