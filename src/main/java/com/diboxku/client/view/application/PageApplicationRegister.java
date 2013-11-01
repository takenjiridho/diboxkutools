package com.diboxku.client.view.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.diboxku.client.app.service.DiboxkuToolsService;
import com.diboxku.client.app.service.DiboxkuToolsServiceAsync;
import com.diboxku.client.util.ClientModule;
import com.diboxku.client.util.TextAreaUppercase;
import com.diboxku.client.util.TextFieldUppercase;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PageApplicationRegister  extends LayoutContainer {
private final DiboxkuToolsServiceAsync service = GWT.create(DiboxkuToolsService.class);
	
	private GroupingStore storeGetModule;
	private FormData formData;
	private Grid gridModule;
	private ContentPanel center,north,east,south;
	private FormPanel west;
	private BorderLayout layout;
	private Map mapParam;
	private Radio radio2,radio;
	private ComboBox comboBoxModuleType,comboBoxModuleStatus,comboBoxServerName,comboBoxModuleDatabase,comboBoxModuleLanguage;
	private TextFieldUppercase textServerUrl,textUrlName,textModuleId,textModuleName,textModuleVer; 
	private ListStore storeComboBoxModuleStatus,storeComboBoxModuleType,storeComboBoxModuleLanguage,storeComboBoxModuleDatabase,storeComboBoxServerName;
	
	@Override  
	  protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		
		
		initStore();		
	    layout = new BorderLayout();  
	    setLayout(layout);  
	    setStyleAttribute("padding", "5px");  
	 
	    
	    BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 100);  
	    northData.setCollapsible(true);  
	    northData.setFloatable(true);
	    northData.setHideCollapseTool(true);  
	    northData.setSplit(true);  
	    northData.setMargins(new Margins(25, 0, 5, 0));  
	  
	    BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 400);  
	    westData.setSplit(true);	    
	    westData.setCollapsible(true);  
	    westData.setMargins(new Margins(25,0,-25,0));  
	  
	    BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);  
	    centerData.setMargins(new Margins(25,0,-25,5));  
	  
	    BorderLayoutData eastData = new BorderLayoutData(LayoutRegion.EAST, 150);  
	    eastData.setSplit(true);  
	    eastData.setCollapsible(true);  
	    eastData.setMargins(new Margins(25,0,0,5));  
	  
	    BorderLayoutData southData = new BorderLayoutData(LayoutRegion.SOUTH, 100);  
	    southData.setSplit(true);  
	    southData.setCollapsible(true);  
	    southData.setFloatable(true);  
	    southData.setMargins(new Margins(5, 0, 0, 0));  
	  
	    
//	    Load Data GridModule
	    getListModule();	    
	    
	    west = westPanel();
	    center = centerPanel();
//	    east = eastPanel();
//	    south = southPanel();
//	    north = northPanel();
	    
//	    add(north, northData);  
	    add(west, westData);  
	    add(center, centerData);  
//	    add(east, eastData);  
//	    add(south, southData);  	    
	}
	
	private ContentPanel northPanel(){
	
	    north = new ContentPanel(); 
	    north.setHeading("north");  
	    return north;
	}
	private ContentPanel eastPanel(){
	    east = new ContentPanel();  
	    east.setHeading("east");
	    return east;
	}
	private ContentPanel southPanel(){
	    
	    south = new ContentPanel();  
	    south.setHeading("south");
	    
	    return south;
	}
	private ContentPanel centerPanel(){
			
		    center = new ContentPanel();  
		    center.setHeading("center BorderLayout Example");  
		    center.setScrollMode(Scroll.AUTOX);  	  	  
		    
		    gridModule = createGridModule();	
			ToolBar toolBarTitle = new ToolBar();
			toolBarTitle.add(new LabelToolItem("<b>Data Module</b>"));
			toolBarTitle.add(new SeparatorToolItem());	
			Button buttonReload = new Button("Reload");
			buttonReload.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					// TODO Auto-generated method stub
					gridModule.mask("load Data ...", "x-mask-loading");
					getListModule();
				}
			});
			buttonReload.setIcon(IconHelper.createStyle("icon-refresh"));
			toolBarTitle.add(buttonReload);
		    
		    center.setHeaderVisible(false);
		    center.setLayout(new RowLayout(Orientation.HORIZONTAL));
		    center.add(gridModule, new RowData(1, 1));		    
		    center.setTopComponent(toolBarTitle);
		    
		    return center;
	}
	
	private FormPanel westPanel(){
//	    ===== west panel ====== 
	    
		west = new FormPanel();
	    west.setHeading("west");
	    west.setHeaderVisible(false);
//	    west.setLayout(new FitLayout());
	    west.setLayout(new RowLayout(Orientation.VERTICAL));
	    west.setFrame(true);
	    
	    formData = new FormData("-20");
	    
	    FieldSet fieldSet = new FieldSet();
		fieldSet.setHeading("Register Module");
		fieldSet.setCollapsible(false);
		
		FormLayout layout = new FormLayout();
		layout.setLabelWidth(100);
		fieldSet.setLayout(layout);
		
		textModuleId  = new TextFieldUppercase();
		textModuleId.setName("module_id");
		textModuleId.setVisible(false);
		textModuleId.setFieldLabel("Module_id");
		fieldSet.add(textModuleId, formData);
		
		textModuleName  = new TextFieldUppercase();
		textModuleName.setName("module_name");
		textModuleName.setWidth(150);
		textModuleName.setFieldLabel("Name");
		fieldSet.add(textModuleName, formData);
		
		textModuleVer= new TextFieldUppercase();
		textModuleVer.setName("module_version");
		textModuleVer.setWidth(50);
		textModuleVer.setAllowBlank(false);
		textModuleVer.setFieldLabel("Version");
		fieldSet.add(textModuleVer, formData);
		
		
		textUrlName  = new TextFieldUppercase();
		textUrlName.setName("url_name");
		textUrlName.setWidth(150);
		textUrlName.setAllowBlank(false);
		textUrlName.setFieldLabel("URL Name");
		fieldSet.add(textUrlName, formData);
		
		comboBoxModuleType = new ComboBox();
		comboBoxModuleType.setFieldLabel("Module Type");
		comboBoxModuleType.setEmptyText("Choose Type...");
		comboBoxModuleType.setDisplayField("module_name");
		comboBoxModuleType.setValueField("module_type");
		comboBoxModuleType.setName("module_name");
		comboBoxModuleType.setAllowBlank(false);
		comboBoxModuleType.setWidth(100);
		comboBoxModuleType.setStore(storeComboBoxModuleType);
		comboBoxModuleType.setTypeAhead(true);
		comboBoxModuleType.setTriggerAction(TriggerAction.ALL);
		comboBoxModuleType.setForceSelection(true);
	    fieldSet.add(comboBoxModuleType, formData);	 
	    
	    comboBoxModuleLanguage = new ComboBox();
		comboBoxModuleLanguage.setFieldLabel("Language");
		comboBoxModuleLanguage.setEmptyText("Choose Language...");
		comboBoxModuleLanguage.setDisplayField("language_name");
		comboBoxModuleLanguage.setValueField("language_id");
		comboBoxModuleLanguage.setName("language_name");
		comboBoxModuleLanguage.setAllowBlank(false);
		comboBoxModuleLanguage.setWidth(100);
		comboBoxModuleLanguage.setStore(storeComboBoxModuleLanguage);
		comboBoxModuleLanguage.setTypeAhead(true);
		comboBoxModuleLanguage.setTriggerAction(TriggerAction.ALL);
		comboBoxModuleLanguage.setForceSelection(true);
	    fieldSet.add(comboBoxModuleLanguage, formData);	 
	    	    
	    
	  		comboBoxModuleDatabase = new ComboBox();
	  		comboBoxModuleDatabase.setFieldLabel("Database");
	  		comboBoxModuleDatabase.setEmptyText("Choose Database...");
	  		comboBoxModuleDatabase.setDisplayField("database_name");
	  		comboBoxModuleDatabase.setValueField("database_id");
	  		comboBoxModuleDatabase.setName("database_name");
	  		comboBoxModuleDatabase.setAllowBlank(false);
	  		comboBoxModuleDatabase.setWidth(100);
	  		comboBoxModuleDatabase.setStore(storeComboBoxModuleDatabase);
	  		comboBoxModuleDatabase.setTypeAhead(true);
	  		comboBoxModuleDatabase.setTriggerAction(TriggerAction.ALL);
	  		comboBoxModuleDatabase.setForceSelection(true);
	  	    fieldSet.add(comboBoxModuleDatabase, formData);	 
	  	  
	  	    
	  	    radio = new Radio();  
	  	    radio.setBoxLabel("Default");
	  	    
	  	    radio2 = new Radio();  
	  	    radio2.setBoxLabel("Group");	  	    
	  	    radio2.setValue(true);  
	  	    
	  	    RadioGroup radioGroup = new RadioGroup();  
	  	    radioGroup.setFieldLabel("Category Page");  
	  	    radioGroup.add(radio);  
	  	    radioGroup.add(radio2);  
	  	    fieldSet.add(radioGroup, formData);  
	  	    
	  		comboBoxServerName = new ComboBox();
	  		comboBoxServerName.setFieldLabel("Server Name");
	  		comboBoxServerName.setEmptyText("Choose Server...");
	  		comboBoxServerName.setDisplayField("server_name");
	  		comboBoxServerName.setValueField("server_id");
	  		comboBoxServerName.setName("server_name");
	  		comboBoxServerName.setAllowBlank(false);
	  		comboBoxServerName.setWidth(100);
	  		comboBoxServerName.setStore(storeComboBoxServerName);
	  		comboBoxServerName.setTypeAhead(true);
	  		comboBoxServerName.setTriggerAction(TriggerAction.ALL);
	  		comboBoxServerName.setForceSelection(true);
	  		comboBoxServerName.addListener(Events.SelectionChange , new Listener<BaseEvent>(){
					@Override
					public void handleEvent(BaseEvent be) {
						// TODO Auto-generated method stub
//						if (textUrlName.getValue().length() < 0){
//							MessageBox.info("Information", "Please Input Url Server", null);
//						}else{
							textServerUrl.setRawValue(comboBoxServerName.getValue().get("server_url").toString().toLowerCase()+"/"+textUrlName.getRawValue().toString().toLowerCase());
//						}
					}
			    });
	  	    fieldSet.add(comboBoxServerName, formData);	 
	  	    	  	    

		textServerUrl = new TextFieldUppercase();
		textServerUrl.setName("module_url");
		textServerUrl.setWidth(130);
		textServerUrl.setReadOnly(true);
		textServerUrl.setAllowBlank(false);
		textServerUrl.setFieldLabel("Server URL");
		fieldSet.add(textServerUrl, formData);
		
		comboBoxModuleStatus = new ComboBox();
		comboBoxModuleStatus.setFieldLabel("Status");
		comboBoxModuleStatus.setEmptyText("Choose Status...");
		comboBoxModuleStatus.setDisplayField("status_name");
		comboBoxModuleStatus.setValueField("status_id");
		comboBoxModuleStatus.setName("status_name");
		comboBoxModuleStatus.setAllowBlank(false);
		comboBoxModuleStatus.setWidth(100);
		comboBoxModuleStatus.setStore(storeComboBoxModuleStatus);
		comboBoxModuleStatus.setTypeAhead(true);
  		comboBoxModuleStatus.setTriggerAction(TriggerAction.ALL);
  		comboBoxModuleStatus.setForceSelection(true);
  	    fieldSet.add(comboBoxModuleStatus, formData);	 
		
		
		
		west.add(fieldSet);
		
		ContentPanel p = new ContentPanel();
		p.setHeaderVisible(false);
		p.setButtonAlign(HorizontalAlignment.RIGHT);
		p.addButton(new Button("Reset", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				west.reset();
			}
		}));
		
		Button submitButton = new Button("Submit");
		p.addButton(submitButton);
		
		submitButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if (!west.isValid()) {
					MessageBox.info("Warning", "Mohon Periksa Entry data", null);
					return;
				} else {
					MessageBox.confirm("Info", "Apakah Anda Yakin Ingin Menyimpan Data?", new Listener<MessageBoxEvent>() {

						@Override
						public void handleEvent(MessageBoxEvent be) {
							// TODO Auto-generated method stub
							Button btn = be.getButtonClicked();
							if (btn.getText().equals("Yes")) {
								Map mapParam = new FastMap();
								
								String moduleId;
								if (textModuleId.getRawValue().length() == 0){
									moduleId = "0";
								}else{
									moduleId = textModuleId.getRawValue().toString();
								}										
								
								mapParam.put("application_id",moduleId);
								mapParam.put("name",textModuleName.getValue());
								mapParam.put("database_id",comboBoxModuleDatabase.getValue().get("database_id").toString());
								mapParam.put("is_enable",comboBoxModuleStatus.getValue().get("status_id").toString());								
								mapParam.put("language_id",comboBoxModuleLanguage.getValue().get("language_id").toString());
								mapParam.put("server_id",comboBoxServerName.getValue().get("server_id").toString());
								mapParam.put("relative_path",textUrlName.getValue());
								mapParam.put("type",comboBoxModuleType.getValue().get("module_type").toString());
								mapParam.put("version",textModuleVer.getValue());
								mapParam.put("default_page",(radio.getValue() == true) ? "1":"0");
								mapParam.put("createby", Registry.get("who?").toString());
								mapParam.put("code", "");
								mapParam.put("func_name", "SETMODULEREGISTER");
								
								Set set = mapParam.entrySet();
								Iterator i = set.iterator();

								while (i.hasNext()) {
									Map.Entry me = (Map.Entry) i.next();
									GWT.log(me.getKey() + ": " + me.getValue());
								}

								west.mask("Processing .........", "x-mask-loading").show();
								service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
									public void onFailure(Throwable caught) {
										GWT.log(caught.getMessage(), null);
										MessageBox.alert("Information", "Internal Server Problem Please Contact Administrator",null);
									}

									public void onSuccess(List<Map> result) {
										west.unmask();
										MessageBox.alert("Information", result.get(0).get("message").toString().toLowerCase(), new Listener<MessageBoxEvent>() {

											@Override
											public void handleEvent(MessageBoxEvent be) {
												gridModule.mask("Load Data ...", "x-mask-loading");
												getListModule();																					
											}
										});
										west.reset();			
									}
								});
							}
						}
					});
					// } //end
				}
			}
		});
		
		west.add(p);
		
	    return west;
		
//	    ===== west panel ======   
	}
		
	
	private Grid createGridModule() {

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		storeGetModule.groupBy("groupheader");
		
		ColumnConfig column = new ColumnConfig();

		column = new ColumnConfig();
		column.setId("server_id");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("server_name");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("module_id");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("is_enable");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("module_name");
		column.setHeader("Name");
		column.setWidth(150);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("module_version");
		column.setHeader("Version");
		column.setWidth(50);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("module_type");
		column.setHeader("Type");
		column.setWidth(70);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("module_status");
		column.setHeader("Status");
		column.setWidth(50);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("module_default_page");
		column.setHeader("Default / Group");
		column.setWidth(80);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("module_language");
		column.setHeader("Language");
		column.setWidth(80);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("module_db");
		column.setHeader("Database");
		column.setWidth(80);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("module_url");
		column.setHeader("URL");
		column.setWidth(250);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("url_name");
		column.setHeader("URL Module");
		column.setWidth(150);
		configs.add(column);
		
		
		storeGetModule.setMonitorChanges(true);


		final ColumnModel cm = new ColumnModel(configs);
		
		GroupingView view = new GroupingView();
		view.setShowGroupedColumn(false);
		view.setGroupRenderer(new GridGroupRenderer() {
			@Override
			public String render(GroupColumnData data) {
				// TODO Auto-generated method stub
				return data.group;
			}
		});
				

		gridModule = new Grid(storeGetModule, cm);
		gridModule.setLoadMask(true);
		gridModule.mask("Load Data ...", "x-mask-loading");
		gridModule.getView().setEmptyText("Data Empty");
		gridModule.setView(view);
		gridModule.setBorders(false);
		gridModule.addListener(Events.CellClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent ge) {
				 textModuleId.setValue(gridModule.getSelectionModel().getSelectedItem().get("module_id").toString());
				 textModuleName.setValue(gridModule.getSelectionModel().getSelectedItem().get("module_name").toString());
				 textModuleVer.setValue(gridModule.getSelectionModel().getSelectedItem().get("module_version").toString());
				 comboBoxModuleDatabase.setRawValue(gridModule.getSelectionModel().getSelectedItem().get("module_db").toString());
				 comboBoxModuleLanguage.setRawValue(gridModule.getSelectionModel().getSelectedItem().get("module_language").toString());
				 comboBoxModuleType.setRawValue(gridModule.getSelectionModel().getSelectedItem().get("module_type").toString());
				 comboBoxModuleStatus.setRawValue(gridModule.getSelectionModel().getSelectedItem().get("module_status").toString());
				 textServerUrl.setValue(gridModule.getSelectionModel().getSelectedItem().get("module_url").toString().toLowerCase());
				 comboBoxServerName.setRawValue(gridModule.getSelectionModel().getSelectedItem().get("server_name").toString());
				 textUrlName.setValue(gridModule.getSelectionModel().getSelectedItem().get("url_name").toString());
				 if (gridModule.getSelectionModel().getSelectedItem().get("module_default_page").equals("YES")){
					 radio.setValue(true);
				 }else{
					 radio2.setValue(true);
				 }
					 
			}
		});
		return gridModule;
	}

	
	private void getListModule() {
		Map mapParam = new FastMap();
		mapParam.put("code", "");
		mapParam.put("func_name", "GETMODULEREGISTER");
		service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
			@Override
			public void onFailure(Throwable caught) {
				gridModule.unmask();
			}

			@Override
			public void onSuccess(List<Map> result) {
				// TODO Auto-generated method stub
				storeGetModule.removeAll();
				storeGetModule.add(ClientModule.setListBaseModelFromListMap(result));
				gridModule.unmask();				
			}
		});
	}
	private void dataStoreComboBox(String funcName) {
		Map mapParam = new FastMap();
		if (funcName.equals("GETCOMBOMODULETYPE")) {
			mapParam.put("code", "");
			mapParam.put("func_name", funcName);
			service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {							
				@Override
				public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage(), null);
				}			
				@Override
				public void onSuccess(List<Map> result) {
					// TODO Auto-generated method stub
					storeComboBoxModuleType.removeAll();
					storeComboBoxModuleType.add(ClientModule.setListBaseModelFromListMap(result));
				}
		  });	
		} else if (funcName.equals("GETCOMBOMODULELANGUAGE")) {
			mapParam.put("code", "");
			mapParam.put("func_name", funcName);
			service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {						
				@Override
				public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage(), null);
				}			
				@Override
				public void onSuccess(List<Map> result) {
					// TODO Auto-generated method stub
					storeComboBoxModuleLanguage.removeAll();
					storeComboBoxModuleLanguage.add(ClientModule.setListBaseModelFromListMap(result));
				}
			});
		} else if (funcName.equals("GETCOMBOMODULEDATABASE")) {
			mapParam.put("code", "");
			mapParam.put("func_name", funcName);
			service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {						
				@Override
				public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage(), null);
				}			
				@Override
				public void onSuccess(List<Map> result) {
					// TODO Auto-generated method stub
					storeComboBoxModuleDatabase.removeAll();
					storeComboBoxModuleDatabase.add(ClientModule.setListBaseModelFromListMap(result));
				}
			});	
		} else if (funcName.equals("GETCOMBOSERVERNAME")) {
			mapParam.put("code", "");
			mapParam.put("func_name", funcName);
			service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {						
				@Override
				public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage(), null);
				}			
				@Override
				public void onSuccess(List<Map> result) {
					// TODO Auto-generated method stub
					storeComboBoxServerName.removeAll();
					storeComboBoxServerName.add(ClientModule.setListBaseModelFromListMap(result));
				}
			});					
		} else if (funcName.equals("GETCOMBOMODULESTATUS")) {
			mapParam.put("code", "");
			mapParam.put("func_name", funcName);
			service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {						
				@Override
				public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage(), null);
				}			
				@Override
				public void onSuccess(List<Map> result) {
					// TODO Auto-generated method stub
					storeComboBoxModuleStatus.removeAll();
					storeComboBoxModuleStatus.add(ClientModule.setListBaseModelFromListMap(result));
				}
			});								
		} 
	}
	private void initStore() {				
		storeGetModule = new GroupingStore();		
		storeComboBoxModuleType = new ListStore();
		storeComboBoxModuleLanguage = new ListStore();
		storeComboBoxModuleDatabase = new ListStore();
		storeComboBoxServerName = new ListStore();
		storeComboBoxModuleStatus = new ListStore();
		
		dataStoreComboBox("GETCOMBOMODULETYPE");
		dataStoreComboBox("GETCOMBOMODULESTATUS");
		dataStoreComboBox("GETCOMBOMODULEDATABASE");
		dataStoreComboBox("GETCOMBOMODULELANGUAGE");
		dataStoreComboBox("GETCOMBOSERVERNAME");
		
	}
}
