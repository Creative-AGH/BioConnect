package com.example.bioconnect.bioWaste.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class FillBioWasteDto {
    @NotNull(message = "Name can not be null")
    @NotEmpty(message = "Name can not be empty")
    @NotBlank(message = "Name can not be null or empty")
    @Size(max = 255, message = "Name of the item must be shorter than {max} signs")
    private String name;
    @Size(max = 255, message = "Description of the item must be shorter than {max} signs")
    private String description;
    //@Enumerated(EnumType.STRING) //it is not necessary because we do that in other way (class StatusOfItemConverter)
    private String composterId;
    private Double howMuchBioWaste;
}
