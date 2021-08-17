package com.example.ogun.Vaadin.component.header;

import com.example.ogun.Vaadin.MyUI;
import com.example.ogun.Vaadin.component.ButtonPageNext;
import com.example.ogun.Vaadin.page.PageHome;
import com.example.ogun.Vaadin.page.PageLogin;
import com.example.ogun.Vaadin.utils.PageNames;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;

public class NotLoginComponent extends ComponentHeader {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public NotLoginComponent() {
	}

	public NotLoginComponent(String pageName) {
		super(pageName);
	}

	@Override
	protected void buildRightComponent() {
		ButtonPageNext button = new ButtonPageNext("Login Page", FontAwesome.SIGN_IN);
		addComponent(button);
		setComponentAlignment(button, Alignment.TOP_RIGHT);
		button.addClickListener(e -> {
			PageLogin pageLogin = new PageLogin();
			MyUI.nextPage(pageLogin, PageNames.LOGIN_PAGE);
		});
	}

	@Override
	protected ClickListener imageOnclickCustom() {
		@SuppressWarnings("serial")
		ClickListener clickListener = new ClickListener() {

			@Override
			public void click(ClickEvent event) {
				PageHome c = new PageHome();
				MyUI.nextPage(c, PageNames.HOME_PAGE);

			}
		};

		return clickListener;

	}

}
