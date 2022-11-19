package com.example.bioconnect.history;


import com.example.bioconnect.entities.BioWasteHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BioWasteHistory.class)
public interface BioWasteHistoryMapper {

    GetBioWasteHistoryDto mapBioWasteHistoryToGetBioWasteHistoryDto(BioWasteHistory bioWasteHistory);
}
