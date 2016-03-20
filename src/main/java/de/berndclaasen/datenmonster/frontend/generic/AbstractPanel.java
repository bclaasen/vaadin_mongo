package de.berndclaasen.datenmonster.frontend.generic;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

import de.berndclaasen.datenmonster.backend.model.Customer;

public abstract class AbstractPanel<T> extends HorizontalLayout{

	T bean;
	Button okButton=new Button("ok");
	
	protected BeanFieldGroup<T> binder;
	       
	


	public AbstractPanel(T bean) {
		this.bean=bean;
		initBinder();
		binder.setItemDataSource(bean);
		initGui();
	}

	private void initGui() {
		bindelements();
		binder.setBuffered(true);
		addComponent(okButton);
	}

	protected abstract void bindelements();
	protected abstract void initBinder();

	public T getBean() {
		return bean;
	}

	public void setBean(T bean) {
		this.bean = bean;
	}

	public Button getOkButton() {
		return okButton;
	}

	public BeanFieldGroup<T> getBinder() {
		return binder;
	}
}
