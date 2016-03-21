package de.berndclaasen.datenmonster.frontend.customer;

import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.frontend.generic.IView;

public class CustomerView extends VerticalLayout implements IView{

	Table table = new Table();

	public CustomerView() {
		super();
		initGui();
	}

	private void initGui() {
		addComponent(table);
		
	}

	public Table getTable() {
		return table;
	}
	
}
