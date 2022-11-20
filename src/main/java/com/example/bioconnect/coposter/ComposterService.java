package com.example.bioconnect.coposter;

import com.example.bioconnect.coposter.dto.ComposterMapper;
import com.example.bioconnect.coposter.dto.FillComposterDto;
import com.example.bioconnect.coposter.dto.GetComposterDto;
import com.example.bioconnect.entities.Composter;
import com.example.bioconnect.repositories.ComposterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComposterService {

    private final ComposterMapper composterMapper;
    private final ComposterRepository composterRepository;

    @Transactional
    public GetComposterDto addComposter(FillComposterDto fillComposterDto) {
        Composter composterToSave = composterMapper.mapFillComposterDtoToComposter(fillComposterDto);
        Composter savedComposter = composterRepository.save(composterToSave);
//        itemHistoryService.addItemHistory(savedItem.getId(), "Item created", "Creating an item (with detailsOfItemBeforeEvent data!)");
        log.info("Successfully created and saved composter");
        return composterMapper.mapComposterToGetComposterDto(savedComposter);
    }

    public GetComposterDto getComposterByComposterId(Long composterId) {
        log.info("Getting an composter by id");
        Optional<Composter> optionalComposter = composterRepository.findById(composterId);
        if (optionalComposter.isEmpty()) {
            log.error("Item with the id {} does not exists", composterId);
            throw new RuntimeException(String.format("Item with that id %s does not exist", composterId));
        }
        return composterMapper.mapComposterToGetComposterDto(optionalComposter.get());
    }

    public List<GetComposterDto> getAllComposters() {
        log.info("Getting all composters");
        List<GetComposterDto> listGetComposterDto = new ArrayList<>();
        Iterable<Composter> listGetComposterDtoFromDatabase = composterRepository.findAll();
        for (Composter composter : listGetComposterDtoFromDatabase) {
            listGetComposterDto.add(composterMapper.mapComposterToGetComposterDto(composter));
        }
        return listGetComposterDto;
    }

    @Transactional
    public void addBioWasteToComposter(Long composterId, double howMuchBioWasteToAdd) {
        Optional<Composter> optionalComposter = composterRepository.findById(composterId);
        if (optionalComposter.isPresent()) {
            Composter composter = optionalComposter.get();
            if (composter.getActualCapacity() + howMuchBioWasteToAdd > composter.getMaximumCapacity()) {
                throw new RuntimeException("The maximum capacity of this composter is: " + composter.getMaximumCapacity());
            }
            composter.setActualCapacity(composter.getActualCapacity() + howMuchBioWasteToAdd);
            composterRepository.save(composter);
        } else {
            throw new RuntimeException("There is no such composter with id: " + composterId);
        }
    }
}
