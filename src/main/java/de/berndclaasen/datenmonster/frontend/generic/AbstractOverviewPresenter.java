package de.berndclaasen.datenmonster.frontend.generic;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.berndclaasen.datenmonster.backend.model.Customer;
import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;
import de.berndclaasen.datenmonster.frontend.customer.CustomerDetailPresenter;
import de.berndclaasen.datenmonster.frontend.customer.CustomerDetailview;


public abstract class AbstractOverviewPresenter<T extends PersistObject, V extends IOverView> extends AbstractPresenter<PersistObject, IView> {

	private Class<V> clazzV;
	private Class<T> clazzT;
	
	public AbstractOverviewPresenter(Class<V> clazzV, Class<T> clazzT) {
		this.clazzV=clazzV;
		this.clazzT=clazzT;
		initView();
		initComponents();
	}

	private void initView() {
		createView();	
	}
	
	protected void initComponents() {
		final BeanItemContainer<T> dataSource = new BeanItemContainer<T>(clazzT);
		dataSource.addAll(getEntitylist());
		getView().getTable().setContainerDataSource(dataSource);	
		ItemClickListener listener=new ItemClickListener() {
			
			@Override
			public void itemClick(ItemClickEvent event) {
				T persistObject=(T) event.getItemId();
				//System.out.println(persistObject.toString());
				openDetailview(persistObject);
			}
		};
		getView().getTable().addItemClickListener(listener);
	}
	
	protected abstract void openDetailview(T persistObject);

	protected Collection<? extends T> getEntitylist() {
		return (Collection<? extends T>) getRepository().findAll();
	}
	
	protected abstract MongoRepository<T, String> getRepository();
	
	protected void createView() {
		try {
			view=clazzV.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	};	
	
	public V getView() {
		return (V) view;
	}

}
