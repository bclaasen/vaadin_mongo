package de.berndclaasen.datenmonster.backend.service;

import de.berndclaasen.datenmonster.backend.model.Customer;

public enum SpringResolver {

	INSTANCE;
	private GenericMongoRepository<Customer> customerRepository;

	public GenericMongoRepository<Customer> getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(
			GenericMongoRepository<Customer> customerRepository) {
		this.customerRepository = customerRepository;
	}
	
}
