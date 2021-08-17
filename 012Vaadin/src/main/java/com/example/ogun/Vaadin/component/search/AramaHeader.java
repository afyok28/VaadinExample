package com.example.ogun.Vaadin.component.search;

import com.example.ogun.Vaadin.component.LabelBaslik;
import com.example.ogun.Vaadin.utils.Converter;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class AramaHeader extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AramaHeader(byte b[],String plName,int count) {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSpacing(true);
		horizontalLayout.setSizeUndefined();
		addComponent(horizontalLayout);
		setComponentAlignment(horizontalLayout, Alignment.TOP_CENTER);

		Image image = new Image("", Converter.byteToResource(b,(long) 1));
		horizontalLayout.addComponent(image);

		Label label = new LabelBaslik(30, plName+" ("+count+")");
		horizontalLayout.addComponent(label);
		horizontalLayout.setComponentAlignment(label, Alignment.BOTTOM_CENTER);
	}



}
