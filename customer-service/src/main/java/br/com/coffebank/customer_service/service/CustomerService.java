package br.com.coffebank.customer_service.service;

import br.com.coffebank.customer_service.dto.CustomerDto;

public interface CustomerService {
	
	CustomerDto saveCustomer(CustomerDto customerDto); //Método para salvar o cliente.

}
