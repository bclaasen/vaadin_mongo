package de.berndclaasen.datenmonster.backend.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;


public class RepositoryFactory<T extends PersistObject> {

	Class<T> clazzT;
	
	public RepositoryFactory(Class<T> clazzT) {
		this.clazzT=clazzT;
	}
	
	public MongoRepository<T, String> getRepository() {
		if (Customer.class.getSimpleName().equals(clazzT.getSimpleName())) {
			return (MongoRepository<T, String>) SpringResolver.INSTANCE.getCustomerRepository();
		}
		//TODO: Hier gehört das Mapping für andere Entities auch hin
		else {
			return null;
		}
	}
}
