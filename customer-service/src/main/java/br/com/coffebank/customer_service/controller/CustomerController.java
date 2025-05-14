package br.com.coffebank.customer_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coffebank.customer_service.dto.CustomerDto;
import br.com.coffebank.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor	
public class CustomerController {
	
	private final CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> CreateCustomer(@RequestBody CustomerDto customerDto){
		// Chama o método saveCustomer do serviço para salvar o cliente.
		CustomerDto savedCustomer = customerService.saveCustomer(customerDto);
		// Retorna a resposta com o cliente salvo.
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
	}

}
