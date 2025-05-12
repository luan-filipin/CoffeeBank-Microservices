package br.com.coffebank.customer_service.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
	
	//Atributos.
    private String name;
    private String email;
    private String document;
    private LocalDate birthDate;  
    private LocalDate creationDate;

}
