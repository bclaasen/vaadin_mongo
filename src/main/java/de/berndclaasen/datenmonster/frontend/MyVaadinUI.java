package de.berndclaasen.datenmonster.frontend;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.CustomerRepository;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.customer.CustomerPresenter;

@SpringUI
public class MyVaadinUI extends UI {
	@Autowired CustomerRepository customerRepository;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	initSpringBeans();
    	
    	CustomerPresenter customerPresenter=new CustomerPresenter();
    	setContent(customerPresenter.getCustomerView().getView());
    }

	private void initSpringBeans() {
		SpringResolver.INSTANCE.setCustomerRepository(customerRepository);	
	}
}