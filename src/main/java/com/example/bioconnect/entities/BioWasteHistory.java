package com.example.bioconnect.entities;

import com.example.bioconnect.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class BioWasteHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Nullable
    Account account;
    private String typeOfEvent;
    @Nullable
    private String commentToEvent;

    private LocalDateTime timeOfEvent;

    String itemId;

    public BioWasteHistory(Long id, String typeOfEvent, String detailsOfItem) {
        this.id = id;
        this.typeOfEvent = typeOfEvent;
    }
}
