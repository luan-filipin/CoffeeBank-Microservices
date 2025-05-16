package br.com.coffebank.account_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "account")
public class Account {

	//Atributos.
	@Id
	private String id;
	private String accountNumber;
	private String accountType; //CC" Conta corrente" ou CP" Conta Poupança".
	private String status; //Ativa ou Encerrada.
	private Double balance; //Saldo.
	private String customerId; //TitularId.
	private String creationDate; //DataCriacao.
}
