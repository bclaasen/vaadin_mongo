package de.berndclaasen.datenmonster.frontend.customer;

import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractPresenter;

public class CustomerPresenter extends AbstractPresenter<Customer,CustomerView> {

	CustomerView customerView;
	CustomerModel<Customer> customerModel;
	
	public CustomerPresenter() {
		super();
		initComponents();
	}
	
	protected void createView() {
		CustomerViewImpl customerView=new CustomerViewImpl();
    	this.customerView=customerView;
	}
	
	protected void createModel() {
		CustomerModel<Customer> customerModel=new CustomerModel<Customer>();
    	customerModel.setEntityList(SpringResolver.INSTANCE.getCustomerRepository().findAll());
    	customerModel.setEntity(new Customer());
    	this.customerModel=customerModel;
	}

	private void initComponents() {
		final BeanItemContainer<Customer> dataSource = new BeanItemContainer<Customer>(Customer.class);
		dataSource.addAll(customerModel.getEntityList());
		customerView.getTable().setContainerDataSource(dataSource);
		customerView.getCustomerPanel().getOkButton().addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					customerView.getCustomerPanel().getBinder().commit();
					SpringResolver.INSTANCE.getCustomerRepository().save(customerView.getCustomerPanel().getBean());
					dataSource.removeAllItems();
					customerModel.setEntityList(SpringResolver.INSTANCE.getCustomerRepository().findAll());
					dataSource.addAll(customerModel.getEntityList());
					customerView.getCustomerPanel().setBean(new Customer("",""));
					customerView.getCustomerPanel().getBinder().setItemDataSource(customerView.getCustomerPanel().getBean());
					
				} catch (CommitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	}

	public CustomerView getCustomerView() {
		return customerView;
	}
	
	

}
