package de.berndclaasen.datenmonster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.CustomerRepository;

@SpringBootApplication
public class DatenmonsterApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	
    public static void main(String[] args) {
        SpringApplication.run(DatenmonsterApplication.class, args);
    }
    
    @Override
	public void run(String... args) throws Exception {

    	//Bernd
		//repository.deleteAll(); 

		// save a couple of customers
		//repository.save(new Customer("Alice", "Smith"));
		//repository.save(new Customer("Bob", "Smith"));
	}

}
