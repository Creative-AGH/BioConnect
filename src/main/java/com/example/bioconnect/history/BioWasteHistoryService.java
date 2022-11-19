package com.example.bioconnect.history;

import com.example.bioconnect.entities.BioWaste;
import com.example.bioconnect.entities.BioWasteHistory;
import com.example.bioconnect.repositories.BioWasteHistoryRepository;
import com.example.bioconnect.repositories.BioWasteRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class BioWasteHistoryService {

    private final BioWasteRepository bioWasteRepository;
    private final BioWasteHistoryRepository bioWasteHistoryRepository;
    private final BioWasteHistoryMapper bioWasteHistoryMapper;

    @Transactional
    public void addBioWasteHistory(String accountId, BioWaste bioWaste, String typeOfEvent, String commentToEvent) {
        log.info("Adding bioWaste history");
        Long bioWasteId = bioWaste.getId();

        BioWasteHistory bioWasteHistory = new BioWasteHistory();
        bioWasteHistory.setBioWasteId(bioWasteId);
        bioWasteHistory.setTimeOfEvent(LocalDateTime.now());
        bioWasteHistory.setTypeOfEvent(typeOfEvent);
        bioWasteHistory.setAccountId(accountId);
        bioWasteHistory.setHowMuchBioWaste(bioWaste.getHowMuchBioWaste());
        if (commentToEvent != null)
            bioWasteHistory.setCommentToEvent(commentToEvent);
        bioWasteHistoryRepository.save(bioWasteHistory);
        log.info("Successfully added item history");
    }

    public double getSumOfBioWasteInSpecifiedTime(String fromDate, String toDate) {
        return bioWasteHistoryRepository.getSumOfBioWasteInSpecifiedTime(fromDate, toDate);
    }

    public List<GetBioWasteHistoryDto> getHistoryOfBioWasteForAccountId(String accountId) {
        List<BioWasteHistory> allBioWasteHistoryByAccountId = bioWasteHistoryRepository.findAllBioWasteHistoryByAccountId(accountId);
        ArrayList<GetBioWasteHistoryDto> getBioWasteHistoryDtoArrayList = new ArrayList<>();
        for (BioWasteHistory bioWasteHistory : allBioWasteHistoryByAccountId) {
            getBioWasteHistoryDtoArrayList.add(bioWasteHistoryMapper.mapBioWasteHistoryToGetBioWasteHistoryDto(bioWasteHistory));
        }
        return getBioWasteHistoryDtoArrayList;
    }
}
