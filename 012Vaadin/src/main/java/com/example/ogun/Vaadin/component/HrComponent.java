package com.example.ogun.Vaadin.component;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class HrComponent extends Label{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HrComponent() {
		setContentMode(ContentMode.HTML);
		setValue("<hr style=\" border: 1px solid red;\">");
		 //label = new Label("<hr style=\" border: 1px solid red;\">", ContentMode.HTML);

	}

}
