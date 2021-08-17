package com.example.ogun.Vaadin.component;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class LabelBaslik extends Label{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LabelBaslik(String name) {
		init(25, name);
	}
	public LabelBaslik(int weight,String name) {
	
        init(weight,name);
	}
	private void init(int weight,String name) {
		setContentMode(ContentMode.HTML);
		setValue("<h1 style=\"font-size: "+weight+"px; font-weight: bold; \">"+name+"</h1>");
	}
	
}
