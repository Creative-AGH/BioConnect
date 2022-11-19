package com.example.bioconnect.repositories;

import com.example.bioconnect.entities.BioWaste;
import com.example.bioconnect.entities.Composter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposterRepository extends CrudRepository<Composter, String> {
}
