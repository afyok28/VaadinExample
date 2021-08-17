package com.example.ogun.Vaadin.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public  class ButtonPageNext extends Button{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ButtonPageNext(String caption,FontAwesome fontAwesome ) {
		this();
		setCaption(caption);
		setIcon(fontAwesome);
	}
	public ButtonPageNext(String caption) {
		this();
		setCaption(caption);
	}
	public ButtonPageNext(FontAwesome fontAwesome ) {
		this();
		setIcon(fontAwesome);
	}
	public ButtonPageNext() {
		init();
	}
	private void init() {
		System.out.println("init methoddddddddddddd");
		setStyleName(ValoTheme.BUTTON_PRIMARY);
		addStyleName(ValoTheme.BUTTON_HUGE);
		
	}
	
}
