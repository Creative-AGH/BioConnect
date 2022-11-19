package com.example.bioconnect.farmer.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RegisterMapper.class)
public interface FarmerFertlizerMapper {
    @Mapping(source = "password", target = "password", ignore = true)
    Account mapRegisterNewAccountDtoToAccount(RegisterNewAccountDto registerNewAccountDto);
}



