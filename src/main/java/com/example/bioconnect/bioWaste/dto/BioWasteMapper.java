package com.example.bioconnect.bioWaste.dto;

import com.example.bioconnect.entities.BioWaste;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BioWasteMapper.class)
public interface BioWasteMapper {

    BioWaste mapFillBioWasteDtoToBioWaste(FillBioWasteDto fillBioWasteDto);
    GetBioWasteDto mapBioWasteToGetBioWasteDto(BioWaste bioWaste);

}
