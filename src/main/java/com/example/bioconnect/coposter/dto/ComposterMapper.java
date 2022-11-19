package com.example.bioconnect.coposter.dto;

import com.example.bioconnect.entities.Composter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ComposterMapper.class)
public interface ComposterMapper {


    Composter mapFillComposterDtoToComposter(FillComposterDto fillComposterDto);


    GetComposterDto mapComposterToGetComposterDto(Composter savedComposter);

}
