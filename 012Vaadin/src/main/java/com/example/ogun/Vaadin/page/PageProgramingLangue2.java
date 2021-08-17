package com.example.ogun.Vaadin.page;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.example.ogun.Vaadin.repository.ProgramingLangue;
import com.example.ogun.Vaadin.service.ProgramingLangueService;
import com.example.ogun.Vaadin.utils.Converter;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.Resource;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Table.RowHeaderMode;

public class PageProgramingLangue2 extends VerticalLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Table table;
	private IndexedContainer indexedContainer;
	private ByteArrayOutputStream baos = null;
	private BeanItem<ProgramingLangue> beanItem;
	private BeanFieldGroup<ProgramingLangue> fieldGroup;

	@PropertyId("id")
	private TextField textId;

	@PropertyId("name")
	private TextField textName;

	@PropertyId("image")
	private TextField imbdScore;

	private Image image;
	@SuppressWarnings("unused")
	private Upload upload;

	public PageProgramingLangue2() {
		image=new Image();
		buildTable();
		addComponent(table);

		buildFormLayout();

		fillTable();

		fieldGroup = new BeanFieldGroup<ProgramingLangue>(ProgramingLangue.class);
		setFieldGroupItem(new ProgramingLangue());
		fieldGroup.bindMemberFields(this);

	}

	private void setFieldGroupItem(ProgramingLangue programingLangue) {
		beanItem = new BeanItem<ProgramingLangue>(programingLangue);
		fieldGroup.setItemDataSource(beanItem);

		byte[] imageAsByteArray = programingLangue.getImage();
		Resource resource=Converter.byteToResource(imageAsByteArray,programingLangue.getId());
		if (resource != null) {
			image.setSource(resource);
		} else
			image.setSource(null);
		image.setImmediate(true);
	}

	@SuppressWarnings("unchecked")
	private void fillTable() {

		indexedContainer.removeAllItems();
		ProgramingLangueService service = new ProgramingLangueService();
		List<ProgramingLangue> programingLangues = service.select();
		for (ProgramingLangue programingLangue : programingLangues) {
			System.out.println(programingLangue);
			Item item = indexedContainer.addItem(programingLangue);

			item.getItemProperty("id").setValue(Long.valueOf(programingLangue.getId()));
			item.getItemProperty("name").setValue(programingLangue.getName());
			
			byte[] imageAsByteArray = programingLangue.getImage();
			Image image=new Image();
			
			Resource resource=Converter.byteToResource(imageAsByteArray,programingLangue.getId());
			if (resource != null) {
				image.setSource(resource);
			} else
				image.setSource(null);
			item.getItemProperty("image").setValue(image);
			image.setImmediate(true);
		}
	}

	@SuppressWarnings("serial")
	private void buildTable() {
		table = new Table("Programing Langue Page");
		table.setSizeFull();
		table.setPageLength(10);
		table.setSelectable(true);
		table.setRowHeaderMode(RowHeaderMode.ICON_ONLY);
		table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent itemClickEvent) {
				ProgramingLangue programingLangues = (ProgramingLangue) itemClickEvent.getItemId();
				setFieldGroupItem(programingLangues);
			}
		});

		indexedContainer = new IndexedContainer();
		indexedContainer.addContainerProperty("id", Long.class, null);
		indexedContainer.addContainerProperty("name", String.class, null);
		indexedContainer.addContainerProperty("image", Image.class, null);

		table.setContainerDataSource(indexedContainer);
		table.setColumnHeaders("ID", "PROGRAMING LANGUE", "IMAGE");

	}

	@SuppressWarnings("serial")
	private void buildFormLayout() {
		FormLayout formLayout = new FormLayout();
		addComponent(formLayout);
		image = new Image();
		formLayout.addComponent(image);

		Upload upload = new Upload();
		upload.setReceiver(new Upload.Receiver() {
			@Override
			public OutputStream receiveUpload(String filename, String mimeType) {

				baos = new ByteArrayOutputStream();
				return baos; // Return the output stream to write to
			}
		});
		upload.addSucceededListener(new Upload.SucceededListener() {
			@Override
			public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
				ProgramingLangue programingLangue = beanItem.getBean();
				programingLangue.setImage(baos.toByteArray());
			}
		});
		formLayout.addComponent(upload);

		textId = new TextField();
		textId.setCaption("Programing Langues Id");
		formLayout.addComponent(textId);
		;

		textName = new TextField();
		textName.setCaption("Name :");
		formLayout.addComponent(textName);

		// formLayout.addComponent(kaydet);
		// formLayout.addComponent(yeni);
	}

}
