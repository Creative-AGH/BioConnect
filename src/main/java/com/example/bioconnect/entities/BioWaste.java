package com.example.bioconnect.entities;

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
@Table(name = "bio_waste")
@NoArgsConstructor
public class BioWaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    private String description;

    private Double howMuchBioWaste;

    @ManyToOne
    @Nullable
    Account account;

    @PastOrPresent
    private LocalDateTime dateOfCreation;

    @ManyToOne
    @JoinColumn(name = "composter_id")
    Composter composter;

}
