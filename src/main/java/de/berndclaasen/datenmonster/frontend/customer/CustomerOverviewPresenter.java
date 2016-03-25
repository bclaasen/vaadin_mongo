package de.berndclaasen.datenmonster.frontend.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

public class CustomerOverviewPresenter<V extends CustomerOverView, T extends Customer> extends AbstractOverviewPresenter<T,V> {

	public CustomerOverviewPresenter(Class<V> clazzV, Class<T> clazzT) {
		super(clazzV,clazzT);		
	}
	
	@SuppressWarnings("unchecked")
	protected MongoRepository<T, String> getRepository() {
		return (MongoRepository<T, String>) SpringResolver.INSTANCE.getCustomerRepository();
	}

	@Override
	protected void openDetailview(T persistObject) {
		CustomerDetailPresenter<CustomerDetailview, Customer> customerDetailPresenter=new CustomerDetailPresenter<CustomerDetailview, Customer>(CustomerDetailview.class,Customer.class,persistObject,this);
		customerDetailPresenter.show();
	}

}
