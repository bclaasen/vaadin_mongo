package de.berndclaasen.datenmonster.frontend.generic;

import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

public class AbstractDetailView extends VerticalLayout implements IDetailView{

	VerticalLayout mainLayout = new VerticalLayout();
	
	public AbstractDetailView() {
		super();
		initGui();
	}

	private void initGui() {
		addComponent(mainLayout);
		
	}

	public Layout getMainLayout() {
		return mainLayout;
	}

}
