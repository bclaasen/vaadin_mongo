package de.berndclaasen.datenmonster.frontend.customer;

import com.vaadin.data.util.BeanItemContainer;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

public class CustomerPresenter<V extends CustomerView> extends AbstractOverviewPresenter<Customer,V> {

	public CustomerPresenter(Class<V> clazz) {
		super(clazz);
		
	}
	
	protected void initComponents() {
		final BeanItemContainer<Customer> dataSource = new BeanItemContainer<Customer>(Customer.class);
		dataSource.addAll(SpringResolver.INSTANCE.getCustomerRepository().findAll());
		view.getTable().setContainerDataSource(dataSource);	
	}
}
