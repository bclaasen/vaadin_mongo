package de.berndclaasen.datenmonster.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.GenericMongoRepository;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverview;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

@SpringUI
public class MyVaadinUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5029682016008212717L;
	@Autowired GenericMongoRepository<Customer> customerRepository;
	
	@Autowired
	GenericMongoRepository<Customer> genericMongoRepository;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	initSpringBeans();
    	 	
    	AbstractOverviewPresenter<AbstractOverview, Customer> overviewPresenter=new AbstractOverviewPresenter<AbstractOverview, Customer>(AbstractOverview.class,Customer.class);
    	setContent(overviewPresenter.getView());    	
    	
    }

	private void initSpringBeans() {
		SpringResolver.INSTANCE.setCustomerRepository(customerRepository);
	}
}