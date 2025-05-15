package br.com.coffebank.customer_service.respository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import br.com.coffebank.customer_service.model.Customer;
import br.com.coffebank.customer_service.repository.CustomerRepository;

@DataMongoTest
public class CustomerRepositoryTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	private Customer customer;
	
	@BeforeEach
	void setUp() {
		customer = new Customer();
		customer.setName("John Doe");
		customer.setEmail("teste@teste.com");		
		customer.setDocument("12345678952");
		customer.setBirthDate(java.time.LocalDate.of(1990, 1, 1));
		customer.setCreationDate(java.time.LocalDateTime.now());
	}
	
	@Test
	void testExistByDocument() {
		// Simula que o documento existe no banco.
		when(customerRepository.existsByDocument("12345678952")).thenReturn(true);
		
		// Verifica se o método retorna o valor esperado.
		boolean exists = customerRepository.existsByDocument("12345678952");
		
		// Verifica a asserção.
		assertTrue(exists);
	} 
}
