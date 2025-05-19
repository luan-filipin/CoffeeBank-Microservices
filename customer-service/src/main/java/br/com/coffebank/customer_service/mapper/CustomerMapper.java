package br.com.coffebank.customer_service.mapper;

import org.mapstruct.Mapper;

import br.com.coffebank.customer_service.dto.CustomerDto;
import br.com.coffebank.customer_service.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	//Mapeamento de Customer para CustomerDto.
	CustomerDto toDto(Customer savedCustomer);
	
	//Mapeamento de CustomerDto para Customer.
	Customer toEntity(CustomerDto customerDto);
}
