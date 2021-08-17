package com.example.ogun.Vaadin.component.header;

import com.example.ogun.Vaadin.MyUI;
import com.example.ogun.Vaadin.component.ButtonPageNext;
import com.example.ogun.Vaadin.page.PageAdmin;
import com.example.ogun.Vaadin.page.PageLogin;
import com.example.ogun.Vaadin.repository.User;
import com.example.ogun.Vaadin.service.UserService;
import com.example.ogun.Vaadin.utils.PageNames;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class LoginComponentHeader extends ComponentHeader{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label label;
	private Label label2;
	public LoginComponentHeader(String nick) {
		
		System.out.println("LoginComponentHeader");
		UserService userService=new UserService();
		User user=userService.selectt(nick);
		System.out.println(user.toString());
		label.setValue(nick);
		label2.setValue(user.getName()+" "+user.getSurName());
		
	}
	@Override
	protected void buildRightComponent() {
		System.out.println("buildRightComponent");

		label=new Label();
		label2=new Label();
		HorizontalLayout horizontalLayout=new HorizontalLayout();
		horizontalLayout.setSizeUndefined();
		addComponent(horizontalLayout);
		setComponentAlignment(horizontalLayout, Alignment.BOTTOM_RIGHT);
		{
			VerticalLayout verticalLayout=new VerticalLayout();
			horizontalLayout.addComponent(verticalLayout);
			{			
				label.setCaption("Nick :");
				verticalLayout.addComponent(label);
				label2.setCaption("Name & Surname :");
				verticalLayout.addComponent(label2);
			}
			Button button=new ButtonPageNext("SIGN OUT", FontAwesome.SIGN_OUT);
			horizontalLayout.addComponent(button);
			button.addClickListener(e->{
				MyUI.getComponentHeader().removeAllComponents();
				ComponentHeader componentHeader=new NotLoginComponent();
				MyUI.setComponentHeader(componentHeader);
				
				MyUI.nextPage(new PageLogin(), PageNames.LOGIN_PAGE);
			});
		}
		
	}

	@Override
	protected ClickListener imageOnclickCustom() {
		@SuppressWarnings("serial")
		ClickListener clickListener=new ClickListener() {
			
			@Override
			public void click(ClickEvent event) {
				PageAdmin pageAdmin=new PageAdmin();
				MyUI.nextPage(pageAdmin, PageNames.ADMIN_PAGE);
				
			}
		};
		return clickListener;
	}


}
