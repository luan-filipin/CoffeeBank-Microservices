package br.com.coffebank.customer_service.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.coffebank.customer_service.dto.CustomerDto;
import br.com.coffebank.customer_service.dto.CustomerId;
import br.com.coffebank.customer_service.mapper.CustomerMapper;
import br.com.coffebank.customer_service.model.Customer;
import br.com.coffebank.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Validated
public class CustomerController {
	
	private final CustomerService customerService;
	private final RestTemplate restTemplate;
	private final CustomerMapper customerMapper;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
	    // Salva o cliente e obtém a entidade com o ID gerado
	    Customer savedCustomerEntity = customerService.saveCustomer(customerDto);

	    // Obtém o ID gerado automaticamente
	    String customerId = savedCustomerEntity.getId();
	    
	    // Cria o DTO com o ID do cliente
	    CustomerId customerIdDto = new CustomerId();
	    customerIdDto.setCustomerId(customerId);
	    
	    // Cria os headers da requisição
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	    
	    // Cria o corpo da requisição
	    HttpEntity<CustomerId> request = new HttpEntity<>(customerIdDto, headers);

	    // Faz a requisição para o serviço externo
	    String accountServiceUrl = "http://localhost:8082/api/account/create";
	    restTemplate.postForEntity(accountServiceUrl, request, Void.class);

	    // Converte a entidade salva para o DTO diretamente com o mapper
	    CustomerDto responseDto = customerMapper.toDto(savedCustomerEntity);
	    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
	}
}
