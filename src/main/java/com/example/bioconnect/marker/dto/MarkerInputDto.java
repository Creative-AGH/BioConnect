package com.example.bioconnect.marker.dto;

import com.example.bioconnect.entities.CategoryOfWaste;
import lombok.Data;

@Data
public class MarkerInputDto {
    private String description;

    private CategoryOfWaste categoryOfWaste;
    private Double howMuchBioWaste;


    private String accountId;

    private Double x;
    private Double y;
}
