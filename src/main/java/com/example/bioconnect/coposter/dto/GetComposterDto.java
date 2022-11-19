package com.example.bioconnect.coposter.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class GetComposterDto {
    private final String id;
    private final String name;
    private final String description;
    @NotNull
    @Size(min = 4, max = 4, message = "Place has to contain 4 coordinates with (x,y)")
    private final List<PointDto> placeCoordinatesDto;
}
