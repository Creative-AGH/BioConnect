package com.example.bioconnect.coposter.dto;

import lombok.Data;

@Data
public class GetComposterDto {
    private final String id;
    private final String name;
    private final String description;
    private final Double x;
    private final Double y;
    private Double maximumCapacity;
    private Double actualCapacity;
}
