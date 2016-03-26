package de.berndclaasen.datenmonster.frontend.customer;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.frontend.generic.AbstractDetailPresenter;
import de.berndclaasen.datenmonster.frontend.generic.IOverviewPresenter;

public class CustomerDetailPresenter<V extends CustomerDetailview, T extends Customer> extends AbstractDetailPresenter<V,T>{

	public CustomerDetailPresenter(Class<V> clazzV, Class<T> clazzT, T persistObject, IOverviewPresenter overviewPresenter) {
		super(clazzV,clazzT,persistObject,overviewPresenter);
		
	}

}
