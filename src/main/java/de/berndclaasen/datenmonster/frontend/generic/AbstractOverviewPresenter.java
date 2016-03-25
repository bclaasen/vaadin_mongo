package de.berndclaasen.datenmonster.frontend.generic;

import java.awt.event.ItemListener;
import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;

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
		ItemClickListener listener=new ItemClickListener() {
			
			@Override
			public void itemClick(ItemClickEvent event) {
				T persistObject=(T) event.getItemId();
				//System.out.println(persistObject.toString());
				openDetailview(persistObject);
			}
		};
		view.getTable().addItemClickListener(listener);
	}
	
	protected abstract void openDetailview(T persistObject);

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
