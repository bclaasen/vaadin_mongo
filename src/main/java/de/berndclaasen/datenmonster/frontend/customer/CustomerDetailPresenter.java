package de.berndclaasen.datenmonster.frontend.customer;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.frontend.generic.AbstractDetailPresenter;

public class CustomerDetailPresenter<V extends CustomerDetailview, T extends Customer> extends AbstractDetailPresenter<T,V>{

	public CustomerDetailPresenter(Class<V> clazzV, Class<T> clazzT, T persistObject) {
		super(clazzV,clazzT,persistObject);
		
	}

}
