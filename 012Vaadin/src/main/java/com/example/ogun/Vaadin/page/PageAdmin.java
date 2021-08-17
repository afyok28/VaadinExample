package com.example.ogun.Vaadin.page;

import com.example.ogun.Vaadin.MyUI;
import com.example.ogun.Vaadin.component.ButtonPageNext;
import com.example.ogun.Vaadin.component.search.AramaPage;
import com.example.ogun.Vaadin.utils.PageNames;
import com.example.ogun.Vaadin.utils.table.TableColumnProperty;
import com.example.ogun.Vaadin.utils.table.TableContainerPropertyService;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PageAdmin extends HorizontalLayout {

	private static VerticalLayout cardLayout;
	public static void nextPage(Component c, String pageName) {
		cardLayout.removeAllComponents();
		cardLayout.addComponent(c);
		MyUI.getComponentHeader().setPageName(pageName);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PageAdmin() {

		setSizeFull();

		buildMenu();

		Panel panel = new Panel();
		panel.setSizeFull();
		addComponent(panel);
		setExpandRatio(panel, 0.80f);
		cardLayout = new VerticalLayout();
		cardLayout.setSizeFull();
		panel.setContent(cardLayout);

		AramaPage aramaPage = new AramaPage(this,PageNames.ADMIN_PAGE);
		aramaPage.setSizeFull();
		cardLayout.addComponent(aramaPage);
		

	}

	private void buildMenu() {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSpacing(true);
		verticalLayout.setSizeFull();
		addComponent(verticalLayout);
		setExpandRatio(verticalLayout, 0.20f);
		{
			VerticalLayout verticalLayoutDiv = new VerticalLayout();
			verticalLayoutDiv.setSizeFull();
			verticalLayoutDiv.setHeight("100%");
			verticalLayout.addComponent(verticalLayoutDiv);
			verticalLayout.setComponentAlignment(verticalLayoutDiv, Alignment.MIDDLE_CENTER);

			VerticalLayout verticalLayout2 = new VerticalLayout();
			verticalLayout2.setSpacing(true);
			verticalLayout2.setSizeFull();
			verticalLayoutDiv.addComponent(verticalLayout2);

			Button button = new ButtonPageNext("Programing Langue", FontAwesome.WEIBO);
			button.setSizeFull();
			verticalLayout2.addComponent(button);
			button.addClickListener(e->{
				TableContainerPropertyService service=new TableContainerPropertyService();
				service.addColumnProperty(new TableColumnProperty("id", Long.class, "ID"));
				service.addColumnProperty(new TableColumnProperty("name", String.class, "NAME"));
				service.addColumnProperty(new TableColumnProperty("image", Image.class, "IMAGE"));
				PageProgramingLangue c=new PageProgramingLangue("Programing Langue Table", service.getTableColumnProperties());
				//PageProgramingLangue2 c=new PageProgramingLangue2();

				PageAdmin.nextPage(c, PageNames.PROGRAMING_LANGUE_PAGE);
			});

			Button button2 = new ButtonPageNext("Programing Category", FontAwesome.WEIBO);
			button2.setSizeFull();
			verticalLayout2.addComponent(button2);
		}
		Button button2 = new ButtonPageNext("Programing Problem", FontAwesome.WEIBO);
		button2.setSizeFull();
		verticalLayout.addComponent(button2);
		verticalLayout.setComponentAlignment(button2, Alignment.BOTTOM_CENTER);

	}

}
