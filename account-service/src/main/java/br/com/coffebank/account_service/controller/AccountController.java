package br.com.coffebank.account_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coffebank.account_service.dto.CustomerId;
import br.com.coffebank.account_service.service.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountService accountService;
	
	@PostMapping("/create")
	public void createAccount(@RequestBody CustomerId request) {
		// Chama o Dto para pegar o customerId.
		String customerId = request.getCustomerId();
		// Chama o serviço para criar a conta.
		accountService.createAccount(customerId);
	}
	

}
