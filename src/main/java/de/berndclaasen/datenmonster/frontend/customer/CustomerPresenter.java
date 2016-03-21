package de.berndclaasen.datenmonster.frontend.customer;

import com.vaadin.data.util.BeanItemContainer;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractPresenter;

public class CustomerPresenter<V extends CustomerView> extends AbstractPresenter<Customer,V> {

	V customerView;
	
	public CustomerPresenter() {
		super();
		initComponents();
	}
	
	protected void createView() {
    	customerView=(V) new CustomerView();
	}
	

	private void initComponents() {
		final BeanItemContainer<Customer> dataSource = new BeanItemContainer<Customer>(Customer.class);
		dataSource.addAll(SpringResolver.INSTANCE.getCustomerRepository().findAll());
		customerView.getTable().setContainerDataSource(dataSource);
		
	}

	@Override
	public V getView() {
		return customerView;
	}
}
