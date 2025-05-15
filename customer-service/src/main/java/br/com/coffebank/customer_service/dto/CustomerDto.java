package br.com.coffebank.customer_service.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //Gerado automaticamente pelo Lombok para criar um construtor com todos os parâmetros.
@NoArgsConstructor //Gerado automaticamente pelo Lombok para criar um construtor sem parâmetros.
public class CustomerDto {
	
	//Atributos.
	@NotBlank(message = "Name is required") //Validação para verificar se o nome não está vazio.
    private String name;
	
	@NotBlank(message = "Email is required") //Validação para verificar se o email não está vazio.
	@Email(message = "Invalid email format.") //Validação para verificar se o email está no formato correto.
    private String email;
	
	@NotBlank(message = "Document is required") //Validação para verificar se o documento não está vazio.
	@Pattern(regexp = "\\d{11}", message = "Document must contain exactly 11 digits.") //Validação para verificar se o documento contém exatamente 11 dígitos.
    private String document;
	
	@NotNull(message = "Birth Date is required") //Validação para verificar se o telefone não está vazio.
	@Past(message = "Birth date must be in the past.") //Validação para verificar se a data de nascimento é no passado.
    private LocalDate birthDate;  

}
