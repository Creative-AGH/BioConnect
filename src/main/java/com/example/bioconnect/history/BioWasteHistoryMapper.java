package com.example.bioconnect.history;


import com.example.bioconnect.entities.BioWasteHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BioWasteHistory.class)
public interface BioWasteHistoryMapper {

    GetBioWasteHistoryDto mapItemHistoryToGetItemHistoryDto(BioWasteHistory bioWasteHistory);
}
