package br.com.coffebank.customer_service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import br.com.coffebank.customer_service.dto.CustomerDto;
import br.com.coffebank.customer_service.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	@Mock
	private CustomerService customerService;
	
	@InjectMocks
	private CustomerController customerController;
	
	@Test
	void testCreateCustomer() {
		// Cria um objeto CustomerDto com dados de teste.
		CustomerDto curstomerDto = new CustomerDto("John Doe", "john.doe@example.com", "12345678952", java.time.LocalDate.of(1990, 1, 1));
		
		//Cria um objeto simulando o retorno.
		CustomerDto savedCustomer = new CustomerDto("John Doe", "john.doe@example.com", "12345678952", java.time.LocalDate.of(1990, 1, 1));
		
		//Configura o comportamento do Mockito.
		//when(customerService.saveCustomer(curstomerDto)).thenReturn(savedCustomer);
		
		//Chama o método controller.
		ResponseEntity<CustomerDto> response = customerController.createCustomer(curstomerDto);
		
		//Verifica se o status HTTP e o corpo da resposta.
		assertEquals(201, response.getStatusCode().value());
		assertEquals(savedCustomer, response.getBody());
	}

}
