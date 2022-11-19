package com.example.bioconnect.register.dto;

import com.example.bioconnect.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RegisterMapper.class)
public interface RegisterMapper {
    @Mapping(source = "password", target = "password", ignore = true)
    Account mapRegisterNewAccountDtoToAccount(RegisterNewAccountDto registerNewAccountDto);
}
