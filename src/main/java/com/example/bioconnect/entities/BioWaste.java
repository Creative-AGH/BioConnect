package com.example.bioconnect.entities;

import com.example.bioconnect.Account;
import com.sun.istack.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "item")
@NoArgsConstructor
public class BioWaste {
    @Id
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String id;
    @NotNull
    @NotEmpty
    private String name;
    private String description;

    @ManyToOne
    @Nullable
    Account borrowedBy;

    @PastOrPresent
    private LocalDateTime dateOfCreation;

    @ManyToOne
    @JoinColumn(name = "place_id")
    Composter composter;

}
