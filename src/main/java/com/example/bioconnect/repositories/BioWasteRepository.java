package com.example.bioconnect.repositories;

import com.example.bioconnect.entities.BioWaste;
import com.example.bioconnect.entities.BioWasteHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BioWasteRepository extends CrudRepository<BioWaste, Long> {
}
