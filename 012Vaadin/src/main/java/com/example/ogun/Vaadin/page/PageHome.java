package com.example.ogun.Vaadin.page;


import com.example.ogun.Vaadin.component.search.AramaPage;
import com.example.ogun.Vaadin.utils.PageNames;
import com.vaadin.ui.VerticalLayout;

public class PageHome extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PageHome() {
		init();
	}

	private void init() {

		setSizeFull();
		
		AramaPage aramaPage=new AramaPage(PageHome.this,PageNames.HOME_PAGE);
		addComponent(aramaPage);

	}

}
