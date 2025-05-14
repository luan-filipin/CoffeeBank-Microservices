package br.com.coffebank.customer_service.exception;


public class DocumentAlreadyExistsException extends RuntimeException{
	
	public DocumentAlreadyExistsException(String document) {
		super("There is already a customer with this document: " + document);
	}

}
