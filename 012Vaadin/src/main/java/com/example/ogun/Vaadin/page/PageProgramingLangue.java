package com.example.ogun.Vaadin.page;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.example.ogun.Vaadin.component.TableUI;
import com.example.ogun.Vaadin.repository.ProgramingLangue;
import com.example.ogun.Vaadin.service.ProgramingLangueService;
import com.example.ogun.Vaadin.utils.Converter;
import com.example.ogun.Vaadin.utils.table.TableColumnProperty;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.Resource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class PageProgramingLangue extends TableUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BeanItem<ProgramingLangue> beanItem;
	private BeanFieldGroup<ProgramingLangue> fieldGroup;

	@PropertyId("id")
	private TextField textId;

	@PropertyId("name")
	private TextField textName;
	
	private Image image;
	  private Upload upload;
	    private ByteArrayOutputStream baos = new ByteArrayOutputStream();


	public PageProgramingLangue(String tableName, List<TableColumnProperty> tableColumnProperties) {
		super(tableName, tableColumnProperties);
		System.out.println("PageProgramingLangue1");
		System.out.println(this.textId==null);
		System.out.println(this.image==null);
		this.refresh();
		this.buildFieldGroupItem();
	
	}

	public PageProgramingLangue(List<TableColumnProperty> tableColumnProperties) {
		super(tableColumnProperties);
		System.out.println("PageProgramingLangue2");
		System.out.println(this.textId==null);
		System.out.println(this.image==null);
		this.refresh();
		buildFieldGroupItem();
	

	}
	
	@Override
	protected void setFieldGroupItem(Object o) {
		ProgramingLangue programingLangue = (ProgramingLangue) o;
		beanItem = new BeanItem<ProgramingLangue>(programingLangue);
		fieldGroup.setItemDataSource(beanItem);

		byte[] b = programingLangue.getImage();
		/*Resource resource = new StreamResource(() -> new ByteArrayInputStream(b),
				"ok.png");*/
		Resource resource = Converter.byteToResource(b,programingLangue.getId());
		if (resource != null) {
			image.setSource(resource);
		} else
			image.setSource(null);
		image.setImmediate(true);

	}

	@Override
	protected void buildFieldGroupItem() {
		fieldGroup = new BeanFieldGroup<ProgramingLangue>(ProgramingLangue.class);
		setFieldGroupItem(new ProgramingLangue());
		fieldGroup.bindMemberFields(PageProgramingLangue.this);

	}

	@SuppressWarnings({ "serial", "serial" })
	@Override
	protected FormLayout buildFormCustom() {
		FormLayout formLayout = new FormLayout();

		textId = new TextField("Id :");
		textId.setEnabled(true);
		formLayout.addComponent(textId);

		textName = new TextField("Name :");
		formLayout.addComponent(textName);

		image = new Image("Image :");
		formLayout.addComponent(image);
		
		upload = new Upload();
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
            	
            	image.setSource(Converter.byteToResource(baos.toByteArray(), programingLangue.getId()));
            	
            	
            	try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        formLayout.addComponent(upload);

		return formLayout;
	}

	@Override
	protected ClickListener updateButton() {
		@SuppressWarnings("serial")
		ClickListener clickListener = new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
                    fieldGroup.commit();
                    BeanItem<ProgramingLangue> itemDataSource = fieldGroup.getItemDataSource();
                    ProgramingLangue programingLangue = itemDataSource.getBean();

                    ProgramingLangueService service = new ProgramingLangueService();
                    service.save(programingLangue);
                    refresh();
                    Notification.show("update Successfuly", "Ok", Notification.Type.HUMANIZED_MESSAGE);
                } catch (Exception e) {
                	Notification.show("update not  Successfuly /n"+e.getMessage(), "Not update", Notification.Type.WARNING_MESSAGE);
                }


			}
		};
		return clickListener;
	}

	@Override
	protected ClickListener insertButton() {
		@SuppressWarnings("serial")
		ClickListener clickListener = new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				setFieldGroupItem(new ProgramingLangue());
			}
		};
		return clickListener;
	}

	@Override
	protected ClickListener selectButton() {
		@SuppressWarnings("serial")
		ClickListener clickListener = new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				refresh();

			}
		};
		return clickListener;
	}

	@Override
	protected ClickListener deleteButton() {
		@SuppressWarnings("serial")
		ClickListener clickListener = new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				
				try {
                    fieldGroup.commit();
                    BeanItem<ProgramingLangue> itemDataSource = fieldGroup.getItemDataSource();
                    ProgramingLangue programingLangue = itemDataSource.getBean();

                    ProgramingLangueService service=new ProgramingLangueService();
                    if(service.delete(new ProgramingLangue(programingLangue.getId())))
                    {
                    	Notification.show("delete Successfuly", "Ok", Notification.Type.HUMANIZED_MESSAGE);
                    	 refresh();
                    }
                    else
                    {
                    	Notification.show("delete not  Successfuly", "Not delete", Notification.Type.WARNING_MESSAGE);
                    }

                } catch (Exception e) {
                	Notification.show("delete not  Successfuly /n"+e.getMessage(), "Not delete", Notification.Type.WARNING_MESSAGE);
                }

				

			}
		};
		return clickListener;
	}

	@SuppressWarnings("serial")
	@Override
	protected void tableAddItemClickListener() {
		this.getTable().addItemClickListener(new ItemClickEvent.ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent itemClickEvent) {
				ProgramingLangue programingLangues = (ProgramingLangue) itemClickEvent.getItemId();
				PageProgramingLangue.this.setFieldGroupItem(programingLangues);
			}
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void refreshCustom() {
		ProgramingLangueService service = new ProgramingLangueService();
		List<ProgramingLangue> programingLangues = service.select();
		for (ProgramingLangue programingLangue : programingLangues) {
			Item item = this.getIndexedContainer().addItem(programingLangue);

			item.getItemProperty("id").setValue(Long.valueOf(programingLangue.getId()));
			item.getItemProperty("name").setValue(programingLangue.getName());
			
			byte[] b = programingLangue.getImage();
			Image image=new Image();
			/*StreamResource resource = new StreamResource(() -> new ByteArrayInputStream(b),
					"ok.png");*/
			Resource resource=Converter.byteToResource(b,programingLangue.getId());
			if (resource != null) {
				image.setSource(resource);
			} else
				image.setSource(null);
			item.getItemProperty("image").setValue(image);
			image.setImmediate(true);
		}
	}

}
