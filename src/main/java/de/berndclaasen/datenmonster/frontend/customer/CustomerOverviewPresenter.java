package de.berndclaasen.datenmonster.frontend.customer;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

public class CustomerOverviewPresenter<V extends CustomerOverView, T extends Customer> extends AbstractOverviewPresenter<T,V> {

	public CustomerOverviewPresenter(Class<V> clazzV, Class<T> clazzT) {
		super(clazzV,clazzT);		
	}

	@Override
	protected void openDetailview(T persistObject) {
		CustomerDetailPresenter<CustomerDetailview, Customer> customerDetailPresenter=new CustomerDetailPresenter<CustomerDetailview, Customer>(CustomerDetailview.class,Customer.class,persistObject,this);
		customerDetailPresenter.show();
	}

}
