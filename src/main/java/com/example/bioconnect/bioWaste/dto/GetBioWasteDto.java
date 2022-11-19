package com.example.bioconnect.bioWaste.dto;

import com.example.bioconnect.account.dto.GetAccountDto;
import com.example.bioconnect.coposter.dto.GetComposterDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetBioWasteDto {
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateOfCreation;
    private GetComposterDto composterDto;
    private GetAccountDto borrowedBy;
    private Double howMuchBioWaste;
}
