package de.berndclaasen.datenmonster.backend.service;

public enum SpringResolver {

	INSTANCE;
	private CustomerRepository customerRepository;
	private GoodRepository goodRepository;

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public GoodRepository getGoodRepository() {
		return goodRepository;
	}

	public void setGoodRepository(GoodRepository goodRepository) {
		this.goodRepository = goodRepository;
	}
	
	
}
