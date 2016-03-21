package de.berndclaasen.datenmonster.frontend.generic;

import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractOverView extends VerticalLayout implements IOverView{
	Table table = new Table();
	
	public AbstractOverView() {
		super();
		initGui();
	}

	private void initGui() {
		addComponent(table);
		
	}

	public Table getTable() {
		return table;
	}
}
