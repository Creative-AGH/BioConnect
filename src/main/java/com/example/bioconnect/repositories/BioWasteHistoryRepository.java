package com.example.bioconnect.repositories;

import com.example.bioconnect.entities.BioWasteHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BioWasteHistoryRepository extends CrudRepository<BioWasteHistory, Long> {
}
