package com.example.bioconnect.history;

import com.example.bioconnect.account.dto.GetAccountDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetBioWasteHistoryDto {
    private Long id;
    private String typeOfEvent;
    private String commentToEvent;
    private LocalDateTime timeOfEvent;
    private String itemId;
    private GetAccountDto account;
    private String detailsOfItemBeforeEvent;
}
