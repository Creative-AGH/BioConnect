package com.example.bioconnect.farmer.dto;

import com.example.bioconnect.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FarmerFertilizerMapper.class)
public interface FarmerFertilizerMapper {
//    @Mapping(source = "password", target = "password", ignore = true)
//    Account mapRegisterNewAccountDtoToAccount(RegisterNewAccountDto registerNewAccountDto);
}



