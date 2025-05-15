package br.com.coffebank.customer_service.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.coffebank.customer_service.dto.CustomerDto;
import br.com.coffebank.customer_service.mapper.CustomerMapper;
import br.com.coffebank.customer_service.model.Customer;
import br.com.coffebank.customer_service.repository.CustomerRepository;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private CustomerMapper customerMapper;
	
	@InjectMocks
	private CustomerServiceImp customerService;
	
	@Captor
	ArgumentCaptor<Customer> customerCaptor;
	
    @Test
    void VerificarSeODocumentNaoExiste() {
        // Alimenta o Dto com dados de teste.
        CustomerDto customerDto = new CustomerDto("John Doe", "teste@teste.com", "12345678952", java.time.LocalDate.of(1990, 1, 1));
        Customer customer = new Customer(); // Cria um objeto Customer mockado
        customer.setDocument(customerDto.getDocument());

        // Simula que o documento não existe no banco.
        when(customerRepository.existsByDocument(customerDto.getDocument())).thenReturn(false);
        when(customerMapper.toEntity(customerDto)).thenReturn(customer); // Mock do comportamento do mapeamento

        // Chama o método a ser testado.
        customerService.saveCustomer(customerDto);

        // Verifica se o método save foi chamado com o objeto correto.
        org.mockito.Mockito.verify(customerRepository).save(customerCaptor.capture());
        Customer savedCustomer = customerCaptor.getValue();
        org.junit.jupiter.api.Assertions.assertEquals(customerDto.getDocument(), savedCustomer.getDocument());
    }

}
