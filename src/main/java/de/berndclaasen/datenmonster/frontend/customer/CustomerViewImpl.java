package de.berndclaasen.datenmonster.frontend.customer;

import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import de.berndclaasen.datenmonster.backend.model.Customer;

public class CustomerViewImpl extends VerticalLayout implements CustomerView {

	Table table = new Table();
	CustomerPanel customerPanel=new CustomerPanel(new Customer("",""));

	public CustomerViewImpl() {
		super();
		initGui();
	}

	private void initGui() {
		addComponent(table);
		addComponent(customerPanel);
		
	}

	public Table getTable() {
		return table;
	}

	public CustomerPanel getCustomerPanel() {
		return customerPanel;
	}

	@Override
	public Component getView() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
}
