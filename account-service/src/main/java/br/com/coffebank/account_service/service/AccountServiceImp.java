package br.com.coffebank.account_service.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.coffebank.account_service.dto.AccountDto;
import br.com.coffebank.account_service.mapper.AccountMapper;
import br.com.coffebank.account_service.model.Account;
import br.com.coffebank.account_service.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {
	
	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;
	
	public AccountServiceImp(AccountRepository accountRepository, AccountMapper accountMapper) {
		this.accountRepository = accountRepository;
		this.accountMapper = accountMapper;
	}

	
	@Override
	public AccountDto createAccount(String customerId) {
		//Criando uma nova conta.
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(UUID.randomUUID().toString().replace("-", "").substring(0, 10));
		accountDto.setAccountType("CC");
		accountDto.setStatus("Ativa");
		accountDto.setBalance(0.0);
		accountDto.setCustomerId(customerId);
		accountDto.setCreationDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	
		//Convertendo AccountDto para Account.
		Account account = accountMapper.toEntity(accountDto);
		
		//Salvando a conta no banco de dados.
		Account savedAccount = accountRepository.save(account);
		
		return accountMapper.toDto(savedAccount);
	}


}
