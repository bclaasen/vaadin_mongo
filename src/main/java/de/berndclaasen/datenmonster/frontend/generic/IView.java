package de.berndclaasen.datenmonster.frontend.generic;

import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

import de.berndclaasen.datenmonster.frontend.customer.CustomerPanel;

public interface IView {

	public Table getTable();
	
	public CustomerPanel getCustomerPanel();
	
	public Component getView();
}
