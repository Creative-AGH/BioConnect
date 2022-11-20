package com.example.bioconnect.marker.dto;

import com.example.bioconnect.entities.Marker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MarkerMapper.class)
public interface MarkerMapper {
    @Mapping(source = "account.email", target = "accountId")
    MarkerOutputDto mapMarkerToMarkerOutputDto(Marker marker);

}
