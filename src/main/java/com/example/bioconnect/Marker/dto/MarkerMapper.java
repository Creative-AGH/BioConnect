package com.example.bioconnect.Marker.dto;

import com.example.bioconnect.entities.Marker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MarkerMapper.class)
public interface MarkerMapper {

    Marker mapMarkerInputDtoToMarker(MarkerInputDto markerInputDto);
    @Mapping(source = "Id" , target = "accountId")
    MarkerOutputDto mapMarkerToMarkerOutputDto(Marker marker);

}
