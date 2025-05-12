package br.com.coffebank.customer_service.service;

import br.com.coffebank.customer_service.dto.CustomerDto;
import br.com.coffebank.customer_service.mapper.CustomerMapper;
import br.com.coffebank.customer_service.model.Customer;
import br.com.coffebank.customer_service.repository.CustomerRepository;

public class CustomerServiceImp implements CustomerService {
	
	//Declaração de dependências.
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    
    //Injeção de dependências via construtor.
    public CustomerServiceImp(CustomerRepository customerRepository, CustomerMapper customerMapper) {
    	this.customerMapper = customerMapper;
    	this.customerRepository = customerRepository;
    }
    
    public CustomerDto saveCustomer(CustomerDto customerDto) {
		//Converte o CustomerDto para Customer.
		Customer customer = customerMapper.toEntity(customerDto);
		//Salva o Customer no banco de dados.
		Customer savedCustomer = customerRepository.save(customer);
		//Retorna os dados do CustomerDto salvo.
		return customerMapper.toDto(savedCustomer);
	}
    
    
    
    

}
