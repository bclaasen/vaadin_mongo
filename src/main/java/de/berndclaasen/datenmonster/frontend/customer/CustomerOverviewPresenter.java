package de.berndclaasen.datenmonster.frontend.customer;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;
import de.berndclaasen.datenmonster.frontend.generic.IDetailPresenter;

public class CustomerOverviewPresenter<V extends CustomerOverView, T extends Customer> extends AbstractOverviewPresenter<V,T> {

	public CustomerOverviewPresenter(Class<V> clazzV, Class<T> clazzT) {
		super(clazzV,clazzT);		
	}
	
	protected IDetailPresenter getDetailPresenter(T persistObject){
		return new CustomerDetailPresenter<CustomerDetailview, Customer>(CustomerDetailview.class,Customer.class,persistObject,this);
	}

}
