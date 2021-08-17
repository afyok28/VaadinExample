package com.example.ogun.Vaadin;

import javax.servlet.annotation.WebServlet;

import com.example.ogun.Vaadin.component.header.ComponentHeader;
import com.example.ogun.Vaadin.component.header.NotLoginComponent;
import com.example.ogun.Vaadin.page.PageAdmin;
import com.example.ogun.Vaadin.page.PageHome;
import com.example.ogun.Vaadin.utils.PageNames;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static VerticalLayout verticalLayout;
	private static ComponentHeader componentHeader;
	private  static VerticalLayout layout ;
	public static ComponentHeader getComponentHeader() {
		return componentHeader;
	}

	public static void setComponentHeader(ComponentHeader componentHeader) {
		MyUI.componentHeader=componentHeader;
		layout.removeAllComponents();
		verticalLayout= new VerticalLayout();
		verticalLayout.setSizeFull();
		layout.addComponent(componentHeader);
		layout.addComponent(verticalLayout);
		layout.setComponentAlignment(componentHeader, Alignment.TOP_CENTER);
	}

	public static void nextPage(Component c, String pageName) {
		verticalLayout.removeAllComponents();
		verticalLayout.addComponent(c);
		componentHeader.setPageName(pageName);
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		layout=new VerticalLayout();
		//layout.setSizeFull();
		
		// üst
		setComponentHeader( new NotLoginComponent());

		// orta

		verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
		layout.addComponent(verticalLayout);
		
		PageHome pageHome = new PageHome();
		pageHome.setSizeFull();
		nextPage(pageHome, PageNames.HOME_PAGE);
		
		//init2();
		
		setContent(layout);
		
		
	}
	@SuppressWarnings("unused")
	private void init2()
	{
		PageAdmin pageAdmin=new PageAdmin();
	
		nextPage(pageAdmin, PageNames.HOME_PAGE);
		
	}
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}
}
