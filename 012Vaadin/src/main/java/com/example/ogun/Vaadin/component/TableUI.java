package com.example.ogun.Vaadin.component;

import java.util.List;
import com.example.ogun.Vaadin.utils.table.TableColumnProperty;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Table.RowHeaderMode;
import com.vaadin.ui.themes.ValoTheme;

public abstract class TableUI extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Table table;
	private IndexedContainer indexedContainer;

	protected Table getTable() {
		return table;
	}

	protected void setTable(Table table) {
		this.table = table;
	}

	protected IndexedContainer getIndexedContainer() {
		return indexedContainer;
	}

	protected void setIndexedContainer(IndexedContainer indexedContainer) {
		this.indexedContainer = indexedContainer;
	}

	protected static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TableUI(String tableName, List<TableColumnProperty> tableColumnProperties) {
		this(tableColumnProperties);
		table.setCaption(tableName);
		System.out.println("TableUI2");
	}

	public TableUI(List<TableColumnProperty> tableColumnProperties) {
		System.out.println("TableUI1");

		buildTable(tableColumnProperties);
		addComponent(table);
		buildForm();

	}

	private void buildForm() {
		FormLayout formLayout = buildFormCustom();

		addComponent(formLayout);
		{
			VerticalLayout verticalLayout = new VerticalLayout();
			verticalLayout.setSizeUndefined();
			addComponent(verticalLayout);
			setComponentAlignment(verticalLayout, Alignment.MIDDLE_CENTER);
			{
				HorizontalLayout horizontalLayout = new HorizontalLayout();
				horizontalLayout.setSpacing(true);
				verticalLayout.addComponent(horizontalLayout);

				Button buttonSelect = new ButtonPageNext("Select", FontAwesome.SEARCH);
				horizontalLayout.addComponent(buttonSelect);
				Button buttonUpdate = new ButtonPageNext("Update", FontAwesome.UPLOAD);
				horizontalLayout.addComponent(buttonUpdate);
				Button buttonInsert = new ButtonPageNext("Insert", FontAwesome.HACKER_NEWS);
				horizontalLayout.addComponent(buttonInsert);
				Button buttonDelete = new ButtonPageNext("Delete", FontAwesome.DESKTOP);
				buttonDelete.addStyleName(ValoTheme.BUTTON_DANGER);
				horizontalLayout.addComponent(buttonDelete);

				buttonSelect.addClickListener(selectButton());
				buttonUpdate.addClickListener(updateButton());
				buttonInsert.addClickListener(insertButton());
				buttonDelete.addClickListener(deleteButton());
			}
		}
	}

	protected abstract FormLayout buildFormCustom();

	private void buildTable(List<TableColumnProperty> tableColumnProperties) {
		table = new Table();
		table.setSizeFull();
		table.setPageLength(10);
		table.setSelectable(true);
		table.setRowHeaderMode(RowHeaderMode.ICON_ONLY);
		tableAddItemClickListener();
		indexedContainer = new IndexedContainer();
		for (TableColumnProperty tableColumnProperty : tableColumnProperties) {
			indexedContainer.addContainerProperty(tableColumnProperty.getId(), tableColumnProperty.getType(),
					tableColumnProperty.getDefaultValue());
			if (tableColumnProperty.getHeader() != null && tableColumnProperty.getHeader().isEmpty() == false) {
				table.setColumnHeader(tableColumnProperty.getId(), tableColumnProperty.getHeader());
			}
			System.out.println(tableColumnProperty.toString());
		}
		table.setContainerDataSource(indexedContainer);
	}

	protected abstract void setFieldGroupItem(Object o);

	protected abstract void buildFieldGroupItem();

	protected abstract ClickListener updateButton();

	protected abstract ClickListener insertButton();

	protected abstract ClickListener selectButton();

	protected abstract ClickListener deleteButton();

	protected void refresh() {
		indexedContainer.removeAllItems();
		refreshCustom();
	}

	protected abstract void tableAddItemClickListener();

	protected abstract void refreshCustom();

}
