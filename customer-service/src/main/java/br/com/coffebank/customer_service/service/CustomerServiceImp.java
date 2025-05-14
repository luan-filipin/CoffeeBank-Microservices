package br.com.coffebank.customer_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.coffebank.customer_service.dto.CustomerDto;
import br.com.coffebank.customer_service.exception.DocumentAlreadyExistsException;
import br.com.coffebank.customer_service.mapper.CustomerMapper;
import br.com.coffebank.customer_service.model.Customer;
import br.com.coffebank.customer_service.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	// Declaração de dependências.
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	// Injeção de dependências via construtor.
	public CustomerServiceImp(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	public CustomerDto saveCustomer(CustomerDto customerDto) {
		// Verifica se o documento já existe no banco de dados.
		if (customerRepository.existsByDocument(customerDto.getDocument())) {
			throw new DocumentAlreadyExistsException(customerDto.getDocument());
		}
		// Converte o CustomerDto para Customer.
		Customer customer = customerMapper.toEntity(customerDto);
		// Cria a data de criação do cliente.
		customer.setCreationDate(LocalDateTime.now());
		// Salva o Customer no banco de dados.
		Customer savedCustomer = customerRepository.save(customer);
		// Retorna os dados do CustomerDto salvo.
		return customerMapper.toDto(savedCustomer);
	}

}
