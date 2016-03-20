package de.berndclaasen.datenmonster.frontend.customer;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.frontend.generic.AbstractPanel;

public class CustomerPanel extends AbstractPanel<Customer> {

	/*
	public CustomerPanel() {	 
		super();
	}
	*/
	
	public CustomerPanel(Customer bean) {	 
		super(bean);
	}
	
	@Override
	protected void initBinder() {
		binder=new BeanFieldGroup<Customer>(Customer.class);
	}
	
	protected void bindelements() {
		addComponent(binder.buildAndBind("Vorname", "firstName"));
		addComponent(binder.buildAndBind("Name", "lastName"));
	}


	
	
}
