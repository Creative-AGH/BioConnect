package com.example.bioconnect.farmer.dto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = FarmerFertilizerMapper.class)
public interface FarmerFertilizerMapper {
//    @Mapping(source = "password", target = "password", ignore = true)
//    Account mapRegisterNewAccountDtoToAccount(RegisterNewAccountDto registerNewAccountDto);
}



