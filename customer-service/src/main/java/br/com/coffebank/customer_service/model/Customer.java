package br.com.coffebank.customer_service.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "customer") //Acessa a tabela customer.
public class Customer {
	
	//Atributos.
	@Id
    private String id;
    private String name;
    private String email;
    private String document;
    private LocalDate birthDate;  
    private LocalDate creationDate;
}
