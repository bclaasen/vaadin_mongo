package de.berndclaasen.datenmonster.frontend;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.CustomerRepository;
import de.berndclaasen.datenmonster.backend.service.GoodRepository;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverview;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

@SpringUI
public class MyVaadinUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5029682016008212717L;
	@Autowired CustomerRepository customerRepository;
	@Autowired GoodRepository goodRepository;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	initSpringBeans();
    	
    	
    	AbstractOverviewPresenter<AbstractOverview, Customer> overviewPresenter=new AbstractOverviewPresenter<AbstractOverview, Customer>(AbstractOverview.class,Customer.class);
    	setContent(overviewPresenter.getView());
    	
    	/*
    	GoodOverviewPresenter<GoodOverView> goodPresenter=new GoodOverviewPresenter<GoodOverView>(GoodOverView.class);
    	setContent(goodPresenter.getView());
    	*/
    }

	private void initSpringBeans() {
		SpringResolver.INSTANCE.setCustomerRepository(customerRepository);
		SpringResolver.INSTANCE.setGoodRepository(goodRepository);
	}
}