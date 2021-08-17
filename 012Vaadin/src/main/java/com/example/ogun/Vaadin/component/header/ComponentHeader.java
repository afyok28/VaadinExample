package com.example.ogun.Vaadin.component.header;

import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public abstract class ComponentHeader extends HorizontalLayout {

	private Label label;

	public void setPageName(String pageName) {
		label.setCaption("<h1 style=\"font-weight: 750 \">" + pageName + "</h1>");
	}

	public ComponentHeader() {
		build("");
	}

	public ComponentHeader(String pageName) {
		build(pageName);
	}

	private void build(String pageName) {
		setWidth("100%");
		
		setSpacing(false);
		addStyleName(ValoTheme.PANEL_BORDERLESS);

		buildImage();
		buildPageName(pageName);
		buildRightComponent();
	}

	protected abstract void buildRightComponent();

	private void buildPageName(String pageName) {
		label = new Label();
		label.setSizeUndefined();
		label.setCaptionAsHtml(true);
		setPageName(pageName);
		addComponent(label);
		setComponentAlignment(label, Alignment.TOP_CENTER);

	}

	private void buildImage() {
		ThemeResource themeResource = new ThemeResource("a.jpg");
		Image image;
		image = new Image("", themeResource);
		addComponent(image);
		setComponentAlignment(image, Alignment.TOP_LEFT);
		image.addClickListener(imageOnclickCustom());
	}

	protected abstract ClickListener imageOnclickCustom();
}