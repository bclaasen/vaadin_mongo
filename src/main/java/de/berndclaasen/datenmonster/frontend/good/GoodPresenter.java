package de.berndclaasen.datenmonster.frontend.good;

import com.vaadin.data.util.BeanItemContainer;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.model.Good;
import de.berndclaasen.datenmonster.backend.service.SpringResolver;
import de.berndclaasen.datenmonster.frontend.generic.AbstractOverviewPresenter;

public class GoodPresenter<V extends GoodView> extends AbstractOverviewPresenter<Good,V> {

	public GoodPresenter(Class<V> clazz) {
		super(clazz);
		
	}
	
	protected void initComponents() {
		final BeanItemContainer<Good> dataSource = new BeanItemContainer<Good>(Good.class);
		dataSource.addAll(SpringResolver.INSTANCE.getGoodRepository().findAll());
		view.getTable().setContainerDataSource(dataSource);	
	}
}
