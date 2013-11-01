package com.diboxku.client.view.server;

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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
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


public class PageServerRegister extends LayoutContainer {
	private final DiboxkuToolsServiceAsync service = GWT.create(DiboxkuToolsService.class);
	
	private ListStore storeGetServer;
	private FormData formData;
	private Grid gridServer;
	private ContentPanel center,north,east,south;
	private FormPanel west;
	private BorderLayout layout;
	private TextFieldUppercase textServerPort;
	private TextAreaUppercase textServerFunc,textServerDb,textServerWs;
	private TextFieldUppercase textServerMem,textServerHd,textServerId,textServerType,textServerName,textServerIp,textServerProc;
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
	  
	    
//	    Load Data GridServer
	    getListServer();
	    
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
		    
		    gridServer = createGridServer();	
			ToolBar toolBarTitle = new ToolBar();
			toolBarTitle.add(new LabelToolItem("<b>Data Server</b>"));
			toolBarTitle.add(new SeparatorToolItem());	
			Button buttonReload = new Button("Reload");
			buttonReload.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					// TODO Auto-generated method stub
					gridServer.mask("load Data ...", "x-mask-loading");
					getListServer();
				}
			});
			buttonReload.setIcon(IconHelper.createStyle("icon-refresh"));
			toolBarTitle.add(buttonReload);
			
		    center.setHeaderVisible(false);
		    center.setLayout(new RowLayout(Orientation.HORIZONTAL));
		    center.add(gridServer, new RowData(1, 1));		    
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
		fieldSet.setHeading("Register Server");
		fieldSet.setCollapsible(false);
		
		FormLayout layout = new FormLayout();
		layout.setLabelWidth(100);
		fieldSet.setLayout(layout);
		
		textServerId  = new TextFieldUppercase();
		textServerId.setName("server_id");
		textServerId.setVisible(false);
		textServerId.setFieldLabel("server_id");
		fieldSet.add(textServerId, formData);
		
		textServerType  = new TextFieldUppercase();
		textServerType.setName("server_type");
		textServerType.setWidth(130);
		textServerType.setFieldLabel("Merek");
		fieldSet.add(textServerType, formData);
		
		textServerName= new TextFieldUppercase();
		textServerName.setName("server_name");
		textServerName.setWidth(130);
		textServerName.setAllowBlank(false);
		textServerName.setFieldLabel("Name");
		fieldSet.add(textServerName, formData);
		
		textServerIp = new TextFieldUppercase();
		textServerIp.setName("server_ip");
		textServerIp.setWidth(130);
		textServerIp.setAllowBlank(false);
		textServerIp.setFieldLabel("IP Address");
		fieldSet.add(textServerIp, formData);
		
		textServerPort = new TextFieldUppercase();
		textServerPort.setName("server_ip");
		textServerPort.setWidth(130);
		textServerPort.setAllowBlank(false);
		textServerPort.setFieldLabel("Port Default");
		fieldSet.add(textServerPort, formData);

		textServerProc = new TextFieldUppercase();
		textServerProc.setName("server_processor");
		textServerProc.setWidth(130);
		textServerProc.setAllowBlank(false);
		textServerProc.setFieldLabel("Processor");
		fieldSet.add(textServerProc, formData);
		
		
		
		textServerHd = new TextFieldUppercase();
		textServerHd.setName("server_hd");
		textServerHd.setWidth(130);
		textServerHd.setAllowBlank(false);
		textServerHd.setFieldLabel("HardDisk Size");
		fieldSet.add(textServerHd, formData);
		
		textServerMem = new TextFieldUppercase();
		textServerMem.setName("server_mem");
		textServerMem.setWidth(130);
		textServerMem.setAllowBlank(false);
		textServerMem.setFieldLabel("Memory");
		fieldSet.add(textServerMem, formData);
		
		textServerWs = new TextAreaUppercase();
		textServerWs.setName("server_ws");
		textServerWs.setWidth(130);
		textServerWs.setAllowBlank(false);
		textServerWs.setFieldLabel("Web Server");
		fieldSet.add(textServerWs, formData);
		
		
		
		textServerDb = new TextAreaUppercase();
		textServerDb.setName("server_db");
		textServerDb.setWidth(130);
		textServerDb.setAllowBlank(false);
		textServerDb.setFieldLabel("Data Base");
		fieldSet.add(textServerDb, formData);
		
		textServerFunc = new TextAreaUppercase();
		textServerFunc.setName("server_func");
		textServerFunc.setWidth(130);
		textServerFunc.setAllowBlank(false);
		textServerFunc.setFieldLabel("Function");
		fieldSet.add(textServerFunc, formData);
		
		
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
								
								String serverId;
								if (textServerId.getRawValue().length() == 0){
									serverId = "0";
								}else{
									serverId = textServerId.getRawValue().toString();
								}	
								
								mapParam.put("server_id",serverId);
								mapParam.put("server_type",textServerType.getValue());
								mapParam.put("server_name",textServerName.getValue());
								mapParam.put("server_ip",textServerIp.getValue().toString());								
								mapParam.put("server_proc",textServerProc.getValue());
								mapParam.put("server_hd",textServerHd.getValue());
								mapParam.put("port",textServerPort.getValue().toString());
								mapParam.put("server_mem",textServerMem.getValue());
								mapParam.put("server_status","1");
								mapParam.put("webserver_version",textServerWs.getValue());
								mapParam.put("database_version",textServerDb.getValue());
								mapParam.put("server_function",textServerFunc.getValue());
								mapParam.put("createby", Registry.get("who?").toString());
								mapParam.put("code", "");
								mapParam.put("func_name", "SETSERVERREGISTER");
								
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
									}

									public void onSuccess(List<Map> result) {
										west.unmask();
										MessageBox.alert("Information", result.get(0).get("message").toString().toLowerCase(), new Listener<MessageBoxEvent>() {
											@Override
											public void handleEvent(MessageBoxEvent be) {												
												gridServer.mask("Load Data ...", "x-mask-loading");
												getListServer();
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
	
	
	private void initStore() {				
		storeGetServer = new ListStore();		
	}
	
	private Grid createGridServer() {

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig column = new ColumnConfig();

		column = new ColumnConfig();
		column.setId("server_id");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("port");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);


		column = new ColumnConfig();
		column.setId("server_name");
		column.setHeader("Name");
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("server_ip");
		column.setHeader("IP Address");
		column.setWidth(90);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("server_proc");
		column.setHeader("Processor");
		column.setWidth(90);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("server_mem");
		column.setHeader("Memory");
		column.setWidth(60);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("server_hd");
		column.setHeader("Hard Disk");
		column.setWidth(60);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("server_type");
		column.setHeader("Merek");
		column.setWidth(70);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("webserver");
		column.setHeader("Web Server");
		column.setWidth(200);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("database");
		column.setHeader("Database");
		column.setWidth(200);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("server_function");
		column.setHeader("Function");
		column.setWidth(200);
		configs.add(column);
		
		storeGetServer.setMonitorChanges(true);

		ColumnModel cm = new ColumnModel(configs);

		gridServer = new Grid(storeGetServer, cm);
		gridServer.setLoadMask(true);
		gridServer.mask("Load Data ...", "x-mask-loading");
		gridServer.getView().setEmptyText("Data Empty");
		gridServer.setBorders(false);
		gridServer.addListener(Events.CellClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent ge) {
				textServerMem.setValue(gridServer.getSelectionModel().getSelectedItem().get("server_mem").toString());
				textServerHd.setValue(gridServer.getSelectionModel().getSelectedItem().get("server_hd").toString());
				textServerId.setValue(gridServer.getSelectionModel().getSelectedItem().get("server_id").toString());
				textServerType.setValue(gridServer.getSelectionModel().getSelectedItem().get("server_type").toString());
				textServerName.setValue(gridServer.getSelectionModel().getSelectedItem().get("server_name").toString());
				textServerIp.setValue(gridServer.getSelectionModel().getSelectedItem().get("server_ip").toString());
				textServerProc.setValue(gridServer.getSelectionModel().getSelectedItem().get("server_proc").toString());
				textServerFunc.setValue(gridServer.getSelectionModel().getSelectedItem().get("server_function").toString());
				textServerDb.setValue(gridServer.getSelectionModel().getSelectedItem().get("database").toString());
				textServerWs.setValue(gridServer.getSelectionModel().getSelectedItem().get("webserver").toString());
				textServerPort.setValue(gridServer.getSelectionModel().getSelectedItem().get("port").toString());
				
			}
		});
		return gridServer;
	}

	
	private void getListServer() {
		Map mapParam = new FastMap();
		mapParam.put("code", "");
		mapParam.put("func_name", "GETSERVERREGISTER");
		service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
			@Override
			public void onFailure(Throwable caught) {
				gridServer.unmask();
			}

			@Override
			public void onSuccess(List<Map> result) {
				// TODO Auto-generated method stub
				storeGetServer.removeAll();
				storeGetServer.add(ClientModule.setListBaseModelFromListMap(result));
				gridServer.unmask();				
			}
		});
	}
}