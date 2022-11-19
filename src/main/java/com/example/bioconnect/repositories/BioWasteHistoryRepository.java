package com.example.bioconnect.repositories;

import com.example.bioconnect.entities.BioWasteHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BioWasteHistoryRepository extends CrudRepository<BioWasteHistory, Long> {

    //SELECT SUM(HOW_MUCH_BIO_WASTE) FROM BIO_WASTE_HISTORY WHERE TIME_OF_EVENT > '2022-11-19 20:03:08.884607'
    //SELECT SUM(HOW_MUCH_BIO_WASTE) FROM BIO_WASTE_HISTORY WHERE TIME_OF_EVENT > '2022-11-19 20:03:08.884607'
    // AND TIME_OF_EVENT < '2022-11-19 20:04:09.65782'
    @Query(value = """
            SELECT SUM(HOW_MUCH_BIO_WASTE) FROM BIO_WASTE_HISTORY WHERE (TIME_OF_EVENT > ?1 AND TIME_OF_EVENT < ?2)
            """,
            nativeQuery = true)
    double getSumOfBioWasteInSpecifiedTime(String fromDate, String toDate);

    @Query(value = "SELECT bioWasteHistory " +
            "FROM BioWasteHistory bioWasteHistory " +
            "WHERE bioWasteHistory.accountId = :accountId")
    List<BioWasteHistory> findAllBioWasteHistoryByAccountId(String accountId);

}
