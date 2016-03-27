package de.berndclaasen.datenmonster.frontend.generic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.spring.annotation.UIScope;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;
import de.berndclaasen.datenmonster.backend.service.GenericMongoRepository;

@Service
@UIScope
public class AbstractOverviewPresenter<V extends IOverView,T extends PersistObject> extends AbstractPresenter<IView,PersistObject> implements IOverviewPresenter{

	@Autowired
	GenericMongoRepository<T> genericMongoRepository;
	
	private Class<V> clazzV;
	private Class<T> clazzT;
	
	public AbstractOverviewPresenter() {
		// TODO Auto-generated constructor stub
	}
	
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
				
				openDetailview(persistObject);
				
			}
		};
		getView().getTable().addItemClickListener(listener);
	}
	
	
	protected void openDetailview(T persistObject) {
		IDetailPresenter detailPresenter=getDetailPresenter(persistObject);
		detailPresenter.show();
	}
	
	protected IDetailPresenter getDetailPresenter(T persistObject){
		return new AbstractDetailPresenter<AbstractDetailView, T>(AbstractDetailView.class,clazzT,persistObject,this);
	}

	protected Collection<? extends T> getEntitylist() {
		return (Collection<? extends T>) genericMongoRepository.findAll();
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
