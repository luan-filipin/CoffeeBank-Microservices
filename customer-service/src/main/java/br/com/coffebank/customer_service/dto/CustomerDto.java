package br.com.coffebank.customer_service.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //Gerado automaticamente pelo Lombok para criar um construtor com todos os parâmetros.
@NoArgsConstructor //Gerado automaticamente pelo Lombok para criar um construtor sem parâmetros.
public class CustomerDto {
	
	//Atributos.
    private String name;
    private String email;
    private String document;
    private LocalDate birthDate;  

}
