package com.example.ogun.Vaadin.component.search;

import com.example.ogun.Vaadin.component.ButtonPageNext;
import com.example.ogun.Vaadin.repository.DbAll;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class AramaQueryComponent extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonPageNext buttonDetaylar;
	
	public ButtonPageNext getButtonDetaylar() {
		return buttonDetaylar;
	}

	public AramaQueryComponent(DbAll dbAll,int count) {
		init(dbAll,count);
	}

	private void init(DbAll dbAll,int count) {

		setWidth("100%");
		{
			AramaHeader aramaHeader=new AramaHeader(dbAll.getProgramingLangue().getImage(), dbAll.getProgramingLangue().getName(), count);
			addComponent(aramaHeader);
		}
		{
			HorizontalLayout horizontalLayout=new HorizontalLayout();
			horizontalLayout.setMargin(new MarginInfo(false, true, false, true));
			horizontalLayout.setSizeFull();
			addComponent(horizontalLayout);
			{
				VerticalLayout verticalLayout=new VerticalLayout();
				verticalLayout.setMargin(true);
				verticalLayout.setSizeUndefined();
				horizontalLayout.addComponent(verticalLayout);
				
				Label labelNick=new Label();
				labelNick.setCaption("User nick :");
				labelNick.setValue(dbAll.getUser().getNick());
				verticalLayout.addComponent(labelNick);
				
				Label labelNames=new Label();
				labelNames.setCaption("User name & surname :");
				labelNames.setValue(dbAll.getUser().getName()+" "+dbAll.getUser().getSurName());
				verticalLayout.addComponent(labelNames);
				
			}
			{
				HorizontalLayout horizontalLayout2=new HorizontalLayout();
				horizontalLayout2.setSpacing(true);
				horizontalLayout2.setSizeUndefined();
				horizontalLayout.addComponent(horizontalLayout2);
				horizontalLayout.setComponentAlignment(horizontalLayout2, Alignment.MIDDLE_CENTER);
				
				Label labelSubject=new Label();
				labelSubject.setCaption("Subject :");
				labelSubject.setValue(dbAll.getPrograminLangueCategory().getName());
				horizontalLayout2.addComponent(labelSubject);
				
				Label labelProblem=new Label();
				labelProblem.setCaption("Problem :");
				labelProblem.setValue(dbAll.getProblem().getTitle());
				horizontalLayout2.addComponent(labelProblem);
				
			}
			buttonDetaylar=new ButtonPageNext("Detaylar", FontAwesome.WHATSAPP);
			horizontalLayout.addComponent(buttonDetaylar);
			horizontalLayout.setComponentAlignment(buttonDetaylar, Alignment.BOTTOM_RIGHT);
		}
	
	}

}
