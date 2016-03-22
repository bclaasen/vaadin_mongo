package de.berndclaasen.datenmonster.frontend.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

public class CustomerOverviewPresenter<V extends CustomerOverView, T extends Customer> extends AbstractOverviewPresenter<T,V> {

	public CustomerOverviewPresenter(Class<V> clazz, Class<T> clazz2) {
		super(clazz,clazz2);
		
	}
	
	protected MongoRepository<T, String> getRepository() {
		return (MongoRepository<T, String>) SpringResolver.INSTANCE.getCustomerRepository();
	}
}
