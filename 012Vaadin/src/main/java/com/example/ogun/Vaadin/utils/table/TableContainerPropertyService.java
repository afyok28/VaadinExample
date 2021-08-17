package com.example.ogun.Vaadin.utils.table;

import java.util.ArrayList;
import java.util.List;

public class TableContainerPropertyService {

	private final List<TableColumnProperty> tableColumnProperties;
	
	public List<TableColumnProperty> getTableColumnProperties() {
		return tableColumnProperties;
	}

	public TableContainerPropertyService() {
		tableColumnProperties=new ArrayList<TableColumnProperty>();
	}
	
	public void addColumnProperty(TableColumnProperty tableColumnProperty) {
		tableColumnProperties.add(tableColumnProperty);
	}
}
