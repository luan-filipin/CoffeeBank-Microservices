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

	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
	    if (customerRepository.existsByDocument(customerDto.getDocument())) {
	        throw new DocumentAlreadyExistsException(customerDto.getDocument());
	    }

	    Customer customer = customerMapper.toEntity(customerDto);
	    customer.setCreationDate(LocalDateTime.now());
	    return customerRepository.save(customer); // Retorna a entidade salva
	}

}
