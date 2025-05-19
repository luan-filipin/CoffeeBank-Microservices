package br.com.coffebank.customer_service.service;

import br.com.coffebank.customer_service.dto.CustomerDto;
import br.com.coffebank.customer_service.model.Customer;

public interface CustomerService {
	
	Customer saveCustomer(CustomerDto customerDto); //Método para salvar o cliente.

}
