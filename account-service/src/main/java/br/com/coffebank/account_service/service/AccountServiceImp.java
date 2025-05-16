package br.com.coffebank.account_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.coffebank.account_service.dto.AccountDto;
import br.com.coffebank.account_service.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {
	
	private AccountRepository accountRepository;
	
	public AccountDto createAccount(String customerId) {
		//Criando uma nova conta.
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(UUID.randomUUID().toString().replace("-", "").substring(0, 10));
		accountDto.setAccountType("CC");
		acc
		
		
		
		return null;
	}


}
