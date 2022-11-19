package com.example.bioconnect.entities;

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
public class Composter {
    @Id
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String id;
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

    public Composter(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public List<BioWaste> getBioWastes() {
        return bioWastes;
    }
}
