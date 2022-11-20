package com.example.bioconnect.bioWaste;

import com.example.bioconnect.bioWaste.dto.BioWasteMapper;
import com.example.bioconnect.bioWaste.dto.FillBioWasteDto;
import com.example.bioconnect.bioWaste.dto.GetBioWasteDto;
import com.example.bioconnect.coposter.ComposterService;
import com.example.bioconnect.entities.BioWaste;
import com.example.bioconnect.history.BioWasteHistoryService;
import com.example.bioconnect.repositories.BioWasteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BioWasteService {
    private final BioWasteMapper bioWasteMapper;
    private final BioWasteRepository bioWasteRepository;
    private final BioWasteHistoryService bioWasteHistoryService;
    private final ComposterService composterService;

    @Transactional
    public GetBioWasteDto addBioWaste(FillBioWasteDto fillBioWasteDto) {
        BioWaste bioWasteToSave = bioWasteMapper.mapFillBioWasteDtoToBioWaste(fillBioWasteDto);
        bioWasteToSave.setDateOfCreation(LocalDateTime.now());
        BioWaste savedBioWaste = bioWasteRepository.save(bioWasteToSave);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        System.out.println(principal);
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = (String) principal;
        }
        composterService.addBioWasteToComposter(fillBioWasteDto.getComposterId(), fillBioWasteDto.getHowMuchBioWaste());
        bioWasteHistoryService.addBioWasteHistory(username, savedBioWaste, "Adding bioWaste", "Adding bioWaste");
//        itemHistoryService.addItemHistory(savedItem.getId(), "Item created", "Creating an item (with detailsOfItemBeforeEvent data!)");
        log.info("Successfully created and saved bioWaste");
        return bioWasteMapper.mapBioWasteToGetBioWasteDto(savedBioWaste);
    }
}
