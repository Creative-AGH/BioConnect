package com.example.bioconnect.account.dto;

import lombok.Data;

@Data
public class GetAccountDto {
    private String email;
    private String name;
    private String surname;
    private Double availableCash;
}
