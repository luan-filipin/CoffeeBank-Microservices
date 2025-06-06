package br.com.coffebank.customer_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.coffebank.customer_service.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	boolean existsByDocument(String document); //Método para verificar se existe o documento no banco de dados.
}
