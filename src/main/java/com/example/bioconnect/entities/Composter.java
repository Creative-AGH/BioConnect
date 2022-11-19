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


    public List<BioWaste> getBioWastes() {
        return bioWastes;
    }
}
