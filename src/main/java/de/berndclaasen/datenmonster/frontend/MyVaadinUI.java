package de.berndclaasen.datenmonster.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.model.Good;
import de.berndclaasen.datenmonster.backend.service.CustomerRepository;
import de.berndclaasen.datenmonster.backend.service.GenericMongoRepository;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverview;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

@SpringUI
public class MyVaadinUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5029682016008212717L;
	
	/*
	@Autowired
	private ApplicationContext appContext;
	*/
	
	@Autowired 
	CustomerRepository customerRepository;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	initSpringBeans();
    	/*
    	String[] defs=appContext.getBeanDefinitionNames();
    	//Object o=appContext.getBean("AbstractOverviewPresenter");
    	AbstractOverviewPresenter<AbstractOverview, Customer> overviewPresenter=(AbstractOverviewPresenter<AbstractOverview, Customer>) appContext.getBean("abstractOverviewPresenter");
    	abstractOverviewPresenter.setClazzV(AbstractOverview.class);
    	abstractOverviewPresenter.setClazzT(Customer.class);
    	abstractOverviewPresenter.initView();
    	abstractOverviewPresenter.initComponents();
    	*/
    	
    	AbstractOverviewPresenter<AbstractOverview, Customer> overviewPresenter=new AbstractOverviewPresenter<AbstractOverview, Customer>(AbstractOverview.class,Customer.class);
    	setContent(overviewPresenter.getView());    	
    }

	private void initSpringBeans() {
		SpringResolver.INSTANCE.setCustomerRepository(customerRepository);
	}
}