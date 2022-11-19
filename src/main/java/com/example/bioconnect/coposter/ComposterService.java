package com.example.bioconnect.coposter;

import com.example.bioconnect.RandomIdHandler;
import com.example.bioconnect.bioWaste.BioWasteMapper;
import com.example.bioconnect.coposter.dto.ComposterMapper;
import com.example.bioconnect.coposter.dto.FillComposterDto;
import com.example.bioconnect.coposter.dto.GetComposterDto;
import com.example.bioconnect.entities.BioWaste;
import com.example.bioconnect.entities.Composter;
import com.example.bioconnect.repositories.BioWasteRepository;
import com.example.bioconnect.repositories.ComposterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComposterService {

    private final ComposterMapper composterMapper;
    private final RandomIdHandler randomIdHandler;
    private final ComposterRepository composterRepository;
    public GetComposterDto addBioWaste(FillComposterDto fillComposterDto) {
//        Composter composterToSave = composterMapper.mapFillComposterDtoToComposter(fillComposterDto);
//        String uuid = randomIdHandler.generateUniqueIdFromTable(composterRepository);
//        composterToSave.setId(uuid);
//        Composter savedComposter = composterRepository.save(composterToSave);
//        itemHistoryService.addItemHistory(savedItem.getId(), "Item created", "Creating an item (with detailsOfItemBeforeEvent data!)");
//        log.info("Successfully created and saved composter");
//        return composterMapper.mapComposterToGetComposterDto(savedComposter);
        return null;
    }
}
