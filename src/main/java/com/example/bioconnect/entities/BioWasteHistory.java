package com.example.bioconnect.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class BioWasteHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeOfEvent;
    @Nullable
    private String commentToEvent;

    private LocalDateTime timeOfEvent;

    private Long bioWasteId;
    private Double howMuchBioWaste;
    private String accountId;

    public BioWasteHistory(Long id, String typeOfEvent, String detailsOfItem) {
        this.id = id;
        this.typeOfEvent = typeOfEvent;
    }
}
