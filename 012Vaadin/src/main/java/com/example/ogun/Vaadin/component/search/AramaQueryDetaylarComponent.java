package com.example.ogun.Vaadin.component.search;

import com.example.ogun.Vaadin.MyUI;
import com.example.ogun.Vaadin.component.ButtonPageNext;
import com.example.ogun.Vaadin.component.HrComponent;
import com.example.ogun.Vaadin.repository.DbAll;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class AramaQueryDetaylarComponent extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VerticalLayout verticalLayout;

	public AramaQueryDetaylarComponent(DbAll dbAll,Component component,String pageName) {
		
		init( dbAll,component,pageName);
	}

	private void init(DbAll dbAll,Component component,String pageName) {
		
		setSizeFull();
		
		Panel panel2 = new Panel();
		panel2.setWidth("75%");
		addComponent(panel2);
		setComponentAlignment(panel2, Alignment.MIDDLE_CENTER);
		
		verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
		panel2.setContent(verticalLayout);
		
		HorizontalLayout horizontalLayout=new HorizontalLayout();
		horizontalLayout.setSizeFull();
		verticalLayout.addComponent(horizontalLayout);
		verticalLayout.setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);
		{
			Button button=new ButtonPageNext("Back", FontAwesome.BACKWARD);
			horizontalLayout.addComponent(button);
			button.addClickListener(e->{
				MyUI.nextPage(component, pageName);
			});
			AramaHeader aramaHeader=new AramaHeader(dbAll.getProgramingLangue().getImage(), dbAll.getProgramingLangue().getName(), 0);
			horizontalLayout.addComponent(aramaHeader);
			horizontalLayout.setComponentAlignment(aramaHeader, Alignment.MIDDLE_CENTER);

			horizontalLayout.setExpandRatio(button, 0.1f);
			horizontalLayout.setExpandRatio(aramaHeader, 0.9f);
			
			Label label=new HrComponent();
			label.setWidth("95%");
			verticalLayout.addComponent(label);
			verticalLayout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
		}
		{
			HorizontalLayout horizontalLayout3=new HorizontalLayout();
			horizontalLayout3.setMargin(new MarginInfo(false, true, false, true));
			horizontalLayout3.setSizeFull();
			verticalLayout.addComponent(horizontalLayout3);
			{

				Label labelNick=new Label();
				labelNick.setCaption("User nick :");
				labelNick.setValue(dbAll.getUser().getNick());
				horizontalLayout3.addComponent(labelNick);
				horizontalLayout3.setComponentAlignment(labelNick, Alignment.MIDDLE_CENTER);

				Label labelNames=new Label();
				labelNames.setCaption("User name & surname :");
				labelNames.setValue(dbAll.getUser().getName()+" "+dbAll.getUser().getSurName());
				horizontalLayout3.addComponent(labelNames);
				horizontalLayout3.setComponentAlignment(labelNames, Alignment.MIDDLE_CENTER);

				Label labelSubject=new Label();
				labelSubject.setCaption("Subject :");
				labelSubject.setValue(dbAll.getPrograminLangueCategory().getName());
				horizontalLayout3.addComponent(labelSubject);
				horizontalLayout3.setComponentAlignment(labelSubject, Alignment.MIDDLE_CENTER);

				Label labelProblem=new Label();
				labelProblem.setCaption("Problem :");
				labelProblem.setValue(dbAll.getProblem().getTitle());
				horizontalLayout3.addComponent(labelProblem);
				horizontalLayout3.setComponentAlignment(labelProblem, Alignment.MIDDLE_CENTER);

			}
			{
				TextArea textArea=new TextArea("Açıklama :", dbAll.getProblem().getExplanation());
				textArea.setEnabled(true);
				textArea.setWidth("95%");
				verticalLayout.addComponent(textArea);
				verticalLayout.setComponentAlignment(textArea, Alignment.MIDDLE_CENTER);

			}
			
		
		}
		
	}

}
