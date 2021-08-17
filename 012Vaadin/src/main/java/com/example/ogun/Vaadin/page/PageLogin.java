package com.example.ogun.Vaadin.page;

import com.example.ogun.Vaadin.MyUI;
import com.example.ogun.Vaadin.component.header.ComponentHeader;
import com.example.ogun.Vaadin.component.header.LoginComponentHeader;
import com.example.ogun.Vaadin.service.UserService;
import com.example.ogun.Vaadin.utils.PageNames;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class PageLogin extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PageLogin() {
		init();
	}

	private void init() {
		
		setSizeFull();



		FormLayout formLayout=new FormLayout();
		addComponent(formLayout);
		formLayout.setSizeUndefined();
		setComponentAlignment(formLayout,Alignment.TOP_CENTER);
		formLayout.setMargin(true);
		formLayout.setSpacing(true);
		
		{
			TextField textField=new TextField("User Name: ");	
			textField.setRequired(true);
			formLayout.addComponent(textField);
			
			PasswordField passwordField=new PasswordField("Password: ");
			passwordField.setRequired(true);
			formLayout.addComponent(passwordField);
			
			HorizontalLayout horizontalLayout=new HorizontalLayout();
			setImmediate(true);
			formLayout.addComponent(horizontalLayout);
			
			Button button=new Button("Login");
			button.setStyleName(ValoTheme.BUTTON_PRIMARY);
			horizontalLayout.addComponent(button);
		    button.addClickListener(e -> {
				//MyUI.getLayout().removeAllComponents();
				String userName=textField.getValue();
				String password=passwordField.getValue();
				System.out.println(userName);
				System.out.println(password);
				if(userName==null || userName.isEmpty())
				{
					Notification.show("User Name is null",
			                  "Error1",
			                  Notification.Type.WARNING_MESSAGE);
					return;
				}
				
				if(password==null || password.isEmpty())
				{
					Notification.show("Password is null",
			                  "Error2",
			                  Notification.Type.WARNING_MESSAGE);
					return;
				}
				UserService userService=new UserService();
				
				if(userService.validate(userName, password))
				{
					Notification.show("succes",
			                  "Ok",
			                  Notification.Type.TRAY_NOTIFICATION);
					MyUI.getComponentHeader().removeAllComponents();
					ComponentHeader componentHeader=new LoginComponentHeader(userName);
					MyUI.setComponentHeader(componentHeader);
					
					MyUI.nextPage(new PageAdmin(), PageNames.ADMIN_PAGE);
					
				}
				else
					Notification.show("password or user name error",
			                  "Error",
			                  Notification.Type.WARNING_MESSAGE);
				//MyUI.getLayout().addComponent(null);
			});
		}
	
		
	}

}
