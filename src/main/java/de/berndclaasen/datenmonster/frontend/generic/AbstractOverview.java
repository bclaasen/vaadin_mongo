package de.berndclaasen.datenmonster.frontend.generic;

import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class AbstractOverview extends VerticalLayout implements IOverView{
	Table table = new Table();
	
	public AbstractOverview() {
		super();
		initGui();
	}

	private void initGui() {
		setSizeFull();
		table.setSizeFull();
		addComponent(table);
		
	}

	public Table getTable() {
		return table;
	}
}
