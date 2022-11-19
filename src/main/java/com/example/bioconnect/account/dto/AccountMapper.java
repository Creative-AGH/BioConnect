package com.example.bioconnect.account.dto;

import com.example.bioconnect.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AccountMapper.class)
public interface AccountMapper {
    GetAccountDto mapAccountToGetAccountDto(Account account);
}
