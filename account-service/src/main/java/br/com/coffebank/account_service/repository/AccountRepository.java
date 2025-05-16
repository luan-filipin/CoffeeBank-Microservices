package br.com.coffebank.account_service.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.coffebank.account_service.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
	
	//Método para buscar uma conta pelo Id do cliente.
	Account findByCustomerId(String customerId);
	
	//Método para buscar uma conta pelo número da conta.
	Account findByAccountNumber(String accountNumber);


}
