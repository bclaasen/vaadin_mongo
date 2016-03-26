package de.berndclaasen.datenmonster.frontend.generic;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;
import de.berndclaasen.datenmonster.backend.service.RepositoryFactory;


public class AbstractOverviewPresenter<V extends IOverView,T extends PersistObject> extends AbstractPresenter<IView,PersistObject> implements IOverviewPresenter{

	private Class<V> clazzV;
	private Class<T> clazzT;
	RepositoryFactory<T> factory;
	
	public AbstractOverviewPresenter(Class<V> clazzV, Class<T> clazzT) {
		this.clazzV=clazzV;
		this.clazzT=clazzT;
		this.factory=new RepositoryFactory<T>(clazzT);
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
				//openDetailview(persistObject);
				
			}
		};
		getView().getTable().addItemClickListener(listener);
	}
	
	/*
	protected void openDetailview(T persistObject) {
		IDetailPresenter detailPresenter=getDetailPresenter(persistObject);
		detailPresenter.show();
	}
	*/
	
	//protected abstract IDetailPresenter getDetailPresenter(T persistObject);

	protected Collection<? extends T> getEntitylist() {
		return (Collection<? extends T>) getRepository().findAll();
	}
	
	private MongoRepository<T, String> getRepository() {
		return factory.getRepository();
	}
	
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
	
	public void refreshTable(){
		final BeanItemContainer<T> dataSource = new BeanItemContainer<T>(clazzT);
		dataSource.addAll(getEntitylist());
		getView().getTable().setContainerDataSource(dataSource);
	}
	

}
