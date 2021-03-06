package de.berndclaasen.datenmonster.frontend.generic;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;
import de.berndclaasen.datenmonster.backend.service.RepositoryFactory;

public abstract class AbstractDetailPresenter<V extends IDetailView, T extends PersistObject> extends AbstractPresenter<IView,PersistObject> implements IDetailPresenter {

	private Class<V> clazzV;
	private Class<T> clazzT;
	private T persistObject;
	FieldGroup fieldGroup;
	IOverviewPresenter overviewPresenter;
	RepositoryFactory<T> factory;
	
	public AbstractDetailPresenter(Class<V> clazzV, Class<T> clazzT, T persistObject, IOverviewPresenter overviewPresenter) {
		this.clazzV=clazzV;
		this.clazzT=clazzT;
		this.persistObject=persistObject;
		this.overviewPresenter=overviewPresenter;
		this.factory=new RepositoryFactory<T>(clazzT);
		initView();
		initComponents();
	}
	
	private void initComponents() {
		fieldGroup = new BeanFieldGroup<T>(clazzT);
		fieldGroup.setItemDataSource(new BeanItem<T>(persistObject));
        // Loop through the properties, build fields for them and add the fields
        // to this UI
        for (Object propertyId : fieldGroup.getUnboundPropertyIds()) {
            getView().getMainLayout().addComponent(fieldGroup.buildAndBind(propertyId));
        }
		
	}

	private void initView() {
		createView();	
	}
	
	private void createView() {
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
	
	public void show() {
		VerticalLayout popupContent=(VerticalLayout) getView().getMainLayout();
		popupContent.setMargin(true);

		Window subwindow=new Window(clazzT.getSimpleName());
		subwindow.setModal(true);
        subwindow.setContent(popupContent);
        subwindow.center();
        subwindow.addCloseListener(new Window.CloseListener() {		
			@Override
            public void windowClose(CloseEvent e) {
               try {
				fieldGroup.commit();
				save(persistObject);
				overviewPresenter.refreshTable();
			} catch (CommitException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
        });
        UI.getCurrent().addWindow(subwindow);
	}

	protected void save(T persistObject2) {
		factory.getRepository().save(persistObject2);
	}
}
