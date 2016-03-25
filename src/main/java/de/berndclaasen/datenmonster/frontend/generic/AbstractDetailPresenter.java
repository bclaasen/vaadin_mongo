package de.berndclaasen.datenmonster.frontend.generic;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.berndclaasen.datenmonster.backend.model.generic.PersistObject;

public abstract class AbstractDetailPresenter<T extends PersistObject, V extends IDetailView> extends AbstractPresenter<PersistObject, IView> {

	private Class<V> clazzV;
	private Class<T> clazzT;
	private T persistObject;
	
	public AbstractDetailPresenter(Class<V> clazzV, Class<T> clazzT, T persistObject) {
		this.clazzV=clazzV;
		this.clazzT=clazzT;
		this.persistObject=persistObject;
		initView();
		initComponents();
	}
	
	private void initComponents() {
		FieldGroup fieldGroup = new BeanFieldGroup<T>(clazzT);
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

		Window subwindow=new Window(clazzT.getName());
		subwindow.setModal(true);
        subwindow.setContent(popupContent);
        subwindow.center();
        UI.getCurrent().addWindow(subwindow);
	}
}
