package de.berndclaasen.datenmonster.frontend.generic;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vaadin.data.util.BeanItemContainer;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;


public abstract class AbstractOverviewPresenter<T extends PersistObject, V extends IOverView> {

	public V view;
	private Class<V> clazz;
	private Class<T> clazz2;
	
	public AbstractOverviewPresenter(Class<V> clazz, Class<T> clazz2) {
		this.clazz=clazz;
		this.clazz2=clazz2;
		initView();
		initComponents();
	}

	private void initView() {
		createView();	
	}
	
	protected void initComponents() {
		final BeanItemContainer<T> dataSource = new BeanItemContainer<T>(clazz2);
		dataSource.addAll(getEntitylist());
		view.getTable().setContainerDataSource(dataSource);	
	}
	
	protected Collection<? extends T> getEntitylist() {
		return (Collection<? extends T>) getRepository().findAll();
	}
	
	protected abstract MongoRepository<T, String> getRepository();
	
	protected void createView() {
		try {
			view=clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	};	

	public V getView() {
		return view;
	}
}
