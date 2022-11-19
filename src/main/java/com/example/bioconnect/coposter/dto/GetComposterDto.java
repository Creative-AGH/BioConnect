package com.example.bioconnect.coposter.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetComposterDto {
    private final String id;
    private final String name;
    private final String description;
    private final List<PointDto> composterCoordinatesDto;
}
