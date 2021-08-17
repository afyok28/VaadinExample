package com.example.ogun.Vaadin.component.search;

import java.util.List;

import com.example.ogun.Vaadin.MyUI;
import com.example.ogun.Vaadin.component.ButtonPageNext;
import com.example.ogun.Vaadin.component.HrComponent;
import com.example.ogun.Vaadin.repository.DbAll;
import com.example.ogun.Vaadin.service.DbAllService;
import com.example.ogun.Vaadin.utils.PageNames;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class AramaPage extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VerticalLayout verticalLayout;
	private Component component;
	private String pageName;
	public AramaPage(Component component,String pageName) {
		this.component=component;
		this.pageName=pageName;
		init();
	}

	private void init() {

		setSizeFull();

		Panel panel = new Panel();
		panel.setWidth("98%");
		addComponent(panel);
		setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSizeFull();
		panel.setContent(horizontalLayout);

		TextField textField = new TextField();
		textField.setWidth("100%");
		textField.setCaption("Arama");
		textField.setIcon(FontAwesome.USER);
		textField.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		textField.addStyleName(ValoTheme.TEXTFIELD_ALIGN_CENTER);
		textField.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
		horizontalLayout.addComponent(textField);
		horizontalLayout.setComponentAlignment(textField, Alignment.TOP_CENTER);

		ButtonPageNext button = new ButtonPageNext(FontAwesome.AMBULANCE);
		horizontalLayout.addComponent(button);
		horizontalLayout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT);
	

		horizontalLayout.setExpandRatio(textField, 0.95f);
		horizontalLayout.setExpandRatio(button, 0.05f);

		{
			Panel panel2 = new Panel();
			panel2.setVisible(false);
			panel2.setWidth("96%");
			addComponent(panel2);
			setComponentAlignment(panel2, Alignment.MIDDLE_CENTER);

			
			verticalLayout = new VerticalLayout();
			verticalLayout.setSizeFull();
			panel2.setContent(verticalLayout);
			button.addClickListener(e -> {	
				button.setEnabled(false);
				int size=aramaQuery(textField.getValue());				
				if(size==0)
				{
					Label label=new Label();
					label.setValue("row 0");
					verticalLayout.addComponent(label);
				}
				button.setEnabled(true);
				panel2.setVisible(true);
			});
		}
	}

	private int aramaQuery(String string) {
		verticalLayout.removeAllComponents();
		DbAllService dbAllService = new DbAllService();
		List<DbAll> dbAlls=dbAllService.findAllFilm2(string);
		for (DbAll dbAll :dbAlls ) {
			AramaQueryComponent aramaQueryComponent = new AramaQueryComponent(dbAll, 30);
			aramaQueryComponent.getButtonDetaylar().addClickListener(e->{
				AramaQueryDetaylarComponent aramaQueryDetaylarComponent=new AramaQueryDetaylarComponent(dbAll, component,pageName);
				MyUI.nextPage(aramaQueryDetaylarComponent, PageNames.Detaaylar_PAGE);
			});
			verticalLayout.addComponent(aramaQueryComponent);
			verticalLayout.setComponentAlignment(aramaQueryComponent, Alignment.MIDDLE_CENTER);

			Label label=new HrComponent();
			label.setWidth("95%");
			verticalLayout.addComponent(label);
			verticalLayout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
		}
		{
			for (DbAll dbAll : dbAllService.findAllFilm2(string)) {
				System.out.println(dbAll.toString());
			}
			/*
			Problem problem = new Problem((long) 1, "ff22", "");

			DbAll dbAll = new DbAll((long) 25, new User((long) 1, "ogün", "odabaş", "afyok28", "1"),
					new ProgramingLangues((long) 1, "Java", null), new PrograminLanguesCategory((long) 2, "vaadin"),
					problem);

			// dbAllService.save(dbAll);
			for (DbAll dbAll2 : dbAllService.findAllFilm2(string)) {
				System.out.println(dbAll2.toString());
			}
			// dbAllService.delete(dbAll);
			for (DbAll dbAll2 : dbAllService.findAllFilm2(string)) {
				System.out.println(dbAll2.toString());
			}
			*/
		}
		return dbAlls.size();
	}
}
