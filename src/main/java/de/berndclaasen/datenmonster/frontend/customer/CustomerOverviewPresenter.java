package de.berndclaasen.datenmonster.frontend.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

public class CustomerOverviewPresenter<V extends CustomerOverView, T extends Customer> extends AbstractOverviewPresenter<T,V> {

	public CustomerOverviewPresenter(Class<V> clazz, Class<T> clazz2) {
		super(clazz,clazz2);
		
	}
	
	@SuppressWarnings("unchecked")
	protected MongoRepository<T, String> getRepository() {
		return (MongoRepository<T, String>) SpringResolver.INSTANCE.getCustomerRepository();
	}

	@Override
	protected void openDetailview(T persistObject) {
		//Notification.show("Opening customer: "+persistObject.getLastName());
		CustomerDetailPresenter<CustomerDetailview, Customer> customerDetailPresenter=new CustomerDetailPresenter<CustomerDetailview, Customer>(CustomerDetailview.class,Customer.class,persistObject,this);
		customerDetailPresenter.show();
	}

}
