package com.example.bioconnect.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "composter")
@AllArgsConstructor
public class Composter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    private String description;

    @OneToMany(mappedBy = "composter")
    private List<BioWaste> bioWastes = new ArrayList<>();

    private Double x;
    private Double y;
    @Min(0)
    private Double maximumCapacity;
    @Min(0)
    private Double actualCapacity;

    public Composter(Long id, String name, String description, Double x, Double y, Double maximumCapacity, Double actualCapacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;
        this.maximumCapacity = maximumCapacity;
        this.actualCapacity = actualCapacity;
    }
}
