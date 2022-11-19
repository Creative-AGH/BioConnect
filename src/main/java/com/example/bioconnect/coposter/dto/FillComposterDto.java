package com.example.bioconnect.coposter.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class FillComposterDto {
    @NotNull(message = "Name can not be null")
    @NotEmpty(message = "Name can not be empty")
    @NotBlank(message = "Name can not be null or empty")
    @Size(max = 255, message = "Name of the place must be shorter than {max} signs")
    private final String name;
    @Size(max = 255, message = "Description of the place must be shorter than {max} signs")
    private final String description;

    private final Double x;
    private final Double y;
    @Min(0)
    private final Double maximumCapacity;
    @Min(0)
    private final Double actualCapacity;
}
