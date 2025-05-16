package br.com.coffebank.account_service.service;

import br.com.coffebank.account_service.dto.AccountDto;

public interface AccountService {
	
	//Método para criar uma nova conta.
	AccountDto createAccount(String customerId);
	
}
