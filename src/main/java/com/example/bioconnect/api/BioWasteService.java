package com.example.bioconnect.api;

import com.example.bioconnect.RandomIdHandler;
import com.example.bioconnect.bioWaste.BioWasteMapper;
import com.example.bioconnect.bioWaste.FillBioWasteDto;
import com.example.bioconnect.bioWaste.GetBioWasteDto;
import com.example.bioconnect.entities.BioWaste;
import com.example.bioconnect.repositories.BioWasteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BioWasteService {
    private final BioWasteMapper bioWasteMapper;
    private final RandomIdHandler randomIdHandler;
    private final BioWasteRepository bioWasteRepository;

    @Transactional
    public GetBioWasteDto addBioWaste(FillBioWasteDto fillBioWasteDto) {
        BioWaste bioWasteToSave = bioWasteMapper.mapFillBioWasteDtoToBioWaste(fillBioWasteDto);
        String uuid = randomIdHandler.generateUniqueIdFromTable(bioWasteRepository);
        bioWasteToSave.setId(uuid);
        bioWasteToSave.setDateOfCreation(LocalDateTime.now());
        BioWaste savedBioWaste = bioWasteRepository.save(bioWasteToSave);
//        itemHistoryService.addItemHistory(savedItem.getId(), "Item created", "Creating an item (with detailsOfItemBeforeEvent data!)");
        log.info("Successfully created and saved bioWaste");
        return bioWasteMapper.mapBioWasteToGetBioWasteDto(savedBioWaste);
    }
}
