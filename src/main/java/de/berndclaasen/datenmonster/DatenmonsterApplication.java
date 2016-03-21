package de.berndclaasen.datenmonster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.model.Good;
import de.berndclaasen.datenmonster.backend.service.CustomerRepository;
import de.berndclaasen.datenmonster.backend.service.GoodRepository;

@SpringBootApplication
public class DatenmonsterApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private GoodRepository goodRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(DatenmonsterApplication.class, args);
    }
    
    @Override
	public void run(String... args) throws Exception {
		//repository.deleteAll(); 

		// save a couple of customers
    	//customerRepository.save(new Customer("Alice", "Smith"));
    	//customerRepository.save(new Customer("Bob", "Smith"));
    	//goodRepository.save(new Good("Fussball", "Fussy"));
	}

}
