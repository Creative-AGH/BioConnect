package com.example.bioconnect.repositories;

import com.example.bioconnect.entities.Marker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkerRepository extends CrudRepository<Marker, Long> {
}
