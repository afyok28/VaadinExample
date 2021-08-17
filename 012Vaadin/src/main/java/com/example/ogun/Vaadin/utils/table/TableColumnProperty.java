package com.example.ogun.Vaadin.utils.table;

public class TableColumnProperty {

	private String id;
	private Class<?> type;
	private Object defaultValue;
	private String header;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	public TableColumnProperty(String id, Class<?> type ) {
		super();
		this.id = id;
		this.type = type;
		this.defaultValue = null;
		this.header = null;
	}
	public TableColumnProperty(String id, Class<?> type , String header) {
		super();
		this.id = id;
		this.type = type;
		this.defaultValue = null;
		this.header = header;
	}
	public TableColumnProperty(String id, Class<?> type, Object defaultValue, String header) {
		super();
		this.id = id;
		this.type = type;
		this.defaultValue = defaultValue;
		this.header = header;
	}

	@Override
	public String toString() {
		return "TableColumnProperty [id=" + id + ", type=" + type + ", defaultValue=" + defaultValue + ", header="
				+ header + "]";
	}

	

}
