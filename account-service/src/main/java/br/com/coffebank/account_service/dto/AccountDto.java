package br.com.coffebank.account_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	
	//Atributos.
	private String accountNumber;
	private String accountType; //CC" Conta corrente" ou CP" Conta Poupança".
	private String status; //Ativa ou Encerrada.
	private Double balance; //Saldo.
	@NotBlank(message = "Customer ID is required") //Validação para verificar se o ID do cliente não está vazio.
	private String customerId; //TitularId.
	private String creationDate; //DataCriacao.

}
