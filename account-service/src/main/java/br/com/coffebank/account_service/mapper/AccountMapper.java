package br.com.coffebank.account_service.mapper;

import org.mapstruct.Mapper;

import br.com.coffebank.account_service.dto.AccountDto;
import br.com.coffebank.account_service.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	
	//Mapeamento de Account para AccountDto.
	AccountDto toDto(Account account);
	
	//Mapeamento de AccountDto para Account.
	Account toEntity(AccountDto accountDto);
}
