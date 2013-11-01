package com.diboxku.client.view.user;

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
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.event.WindowListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitData;
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

public class PageUserRegister extends LayoutContainer {
	 
private final DiboxkuToolsServiceAsync service = GWT.create(DiboxkuToolsService.class);
	
	private GroupingStore storeGetUser;
	private ListStore storeGetGroupPage,storeGetDefaultPage;
	private FormData formData;
	private Grid gridUser,gridGroupPage,gridDefaultPage;
	private TextField<String> textRetypePwd,textNewPwd;
	private ContentPanel center,north,east,south,west;
	private FormPanel form;
	private TabPanel pagePanel;
	private BorderLayout layout;
	private Map mapParam;
	private TextFieldUppercase textUserStatus,textLoginName,textRegisterDate,textGender,textBirthDay,textFirstName,textLastName,textMobileNum,textEmail;
	
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
	  
	    
//	    Load Data GridUser
	    getListUser();
	    getListPage("default","");
	    getListPage("group","");
	    
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
		    
		    gridUser = createGridUser();	
			ToolBar toolBarTitle = new ToolBar();
			toolBarTitle.add(new LabelToolItem("<b>Data Users Register</b>"));
			toolBarTitle.add(new SeparatorToolItem());	
			Button buttonReload = new Button("Reload");
			buttonReload.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					// TODO Auto-generated method stub
					gridUser.mask("load Data ...", "x-mask-loading");
					getListUser();
				}
			});
			buttonReload.setIcon(IconHelper.createStyle("icon-refresh"));
			toolBarTitle.add(buttonReload);
			toolBarTitle.add(new SeparatorToolItem());	
			Button buttonResetPwd = new Button("Reset PWD");
			buttonResetPwd.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					// TODO Auto-generated method stub
					
					int rowIndex;
					rowIndex = gridUser.getStore().indexOf(gridUser.getSelectionModel().getSelectedItem());
					if (rowIndex >= 0 ){
						
						String loginUser = gridUser.getSelectionModel().getSelectedItem().get("login_name").toString();
						String idUser = gridUser.getSelectionModel().getSelectedItem().get("id_user").toString();
						
						popresetpwd(loginUser,idUser);						
					}else{
						MessageBox.alert("Info", "Please Select one of Account", null);
					}
					
				}
			});
			buttonResetPwd.setIcon(IconHelper.createStyle("icon-key"));
			toolBarTitle.add(buttonResetPwd);
			toolBarTitle.add(new SeparatorToolItem());	
			Button buttonDeleteAcc = new Button("Delete Account");
			buttonDeleteAcc.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					// TODO Auto-generated method stub					
					int rowIndex;					
					rowIndex = gridUser.getStore().indexOf(gridUser.getSelectionModel().getSelectedItem());										
					GWT.log("x " + rowIndex);
					if (rowIndex >= 0 ){												
						String idUser = gridUser.getSelectionModel().getSelectedItem().get("id_user").toString();						
						deleteAccount(idUser);						
					}else{
						MessageBox.alert("Info", "Please Select one of Account", null);
					}
					
				}
			});
			buttonDeleteAcc.setIcon(IconHelper.createStyle("icon-del-table"));
			toolBarTitle.add(buttonDeleteAcc);
		    center.setHeaderVisible(false);
		    center.setLayout(new RowLayout(Orientation.HORIZONTAL));
		    center.add(gridUser, new RowData(1, 1));		    
		    center.setTopComponent(toolBarTitle);
		    
		    return center;
	}
	private ContentPanel westPanel(){
	    
	    west = new ContentPanel();  
	    west.setHeading("west");
	    
	    form = formPanel();
	    pagePanel = pageTabPanel();
	    
	    west.setHeaderVisible(false);
	    west.setBodyBorder(false);
	    west.setLayout(new RowLayout(Orientation.VERTICAL));
	    west.add(form, new RowData(1, .50));
	    west.add(pagePanel, new RowData(1, .50));	
	    
	    return west;
	}
	
	private FormPanel formPanel(){
//	    ===== west panel ====== 
	    
		form = new FormPanel();
		form.setHeading("form");
		form.setHeaderVisible(false);
//		form.setBorders(false);
		form.setLayout(new RowLayout(Orientation.VERTICAL));
		form.setFrame(true);
		form.setScrollMode(Scroll.AUTO);
	    
	    formData = new FormData("-20");
	    
	    FieldSet fieldSet = new FieldSet();
		fieldSet.setHeading("Register Accounts");
		fieldSet.setCollapsible(false);
		
		FormLayout layout = new FormLayout();
		layout.setLabelWidth(100);
		fieldSet.setLayout(layout);
		
		textLoginName  = new TextFieldUppercase();
		textLoginName.setName("login_name");
		textLoginName.setWidth(130);
		textLoginName.setReadOnly(true);
		textLoginName.setFieldLabel("Login Name");
		fieldSet.add(textLoginName, formData);
				
		
		textFirstName= new TextFieldUppercase();
		textFirstName.setName("first_name");
		textFirstName.setWidth(130);
		textFirstName.setReadOnly(true);
//		textFirstName.setAllowBlank(false);
		textFirstName.setFieldLabel("First Name");
		fieldSet.add(textFirstName, formData);
		
		textLastName= new TextFieldUppercase();
		textLastName.setName("last_name");
		textLastName.setWidth(130);
		textLastName.setReadOnly(true);
		textLastName.setFieldLabel("Last Name");
		fieldSet.add(textLastName, formData);
		
		
		textMobileNum = new TextFieldUppercase();
		textMobileNum.setName("mobile_num");
		textMobileNum.setWidth(130);
		textMobileNum.setReadOnly(true);
		textMobileNum.setFieldLabel("Mobile Num");
		fieldSet.add(textMobileNum, formData);
		
		textEmail = new TextFieldUppercase();
		textEmail.setName("email");
		textEmail.setWidth(130);
		textEmail.setReadOnly(true);
		textEmail.setFieldLabel("Email");
		fieldSet.add(textEmail, formData);
		
		
		textBirthDay = new TextFieldUppercase();
		textBirthDay.setName("birth_day");
		textBirthDay.setWidth(130);
		textBirthDay.setReadOnly(true);
		textBirthDay.setFieldLabel("Birth Day");
		fieldSet.add(textBirthDay, formData);
		
		textGender = new TextFieldUppercase();
		textGender.setName("gender");
		textGender.setWidth(130);
		textGender.setReadOnly(true);
		textGender.setFieldLabel("Gender");
		fieldSet.add(textGender, formData);
		
		textRegisterDate = new TextFieldUppercase();
		textRegisterDate.setName("register_date");
		textRegisterDate.setWidth(130);
		textRegisterDate.setReadOnly(true);
		textRegisterDate.setFieldLabel("Register Date");
		fieldSet.add(textRegisterDate, formData);
		
		textUserStatus = new TextFieldUppercase();
		textUserStatus.setName("status");
		textUserStatus.setWidth(130);
		textUserStatus.setReadOnly(true);
		textUserStatus.setFieldLabel("Status");
		fieldSet.add(textUserStatus, formData);
		
		form.add(fieldSet);
		
		ContentPanel p = new ContentPanel();
		p.setHeaderVisible(false);
		p.setButtonAlign(HorizontalAlignment.RIGHT);
		p.addButton(new Button("Reset", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				form.reset();
			}
		}));
		
		Button submitButton = new Button("Submit");
		p.addButton(submitButton);
		
		submitButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if (!form.isValid()) {
					MessageBox.info("Warning", "Mohon Periksa Entry data", null);
					return;
				} else {
					MessageBox.confirm("Info", "Apakah Anda Yakin Ingin Menyimpan Data?", new Listener<MessageBoxEvent>() {

						@Override
						public void handleEvent(MessageBoxEvent be) {
							// TODO Auto-generated method stub
							Button btn = be.getButtonClicked();
							if (btn.getText().equals("Yes")) {
								mapParam = new FastMap();
								
//								mapParam.put("server_type",textServerType.getRawValue());
//								mapParam.put("server_name",textServerName.getRawValue());
//								mapParam.put("server_ip",textServerIp.getRawValue());								
//								mapParam.put("server_proc",textServerProc.getRawValue());
//								mapParam.put("server_hd",textServerHd.getRawValue());
//								mapParam.put("server_mem",textServerMem.getRawValue());
//								mapParam.put("webserver_version",textServerWs.getRawValue());
//								mapParam.put("database_version",textServerDb.getRawValue());
//								mapParam.put("server_function",textServerFunc.getRawValue());
								mapParam.put("createby", Registry.get("who?").toString());
								mapParam.put("code", "");
								mapParam.put("func_name", "SETUSERREGISTER");
								
								Set set = mapParam.entrySet();
								Iterator i = set.iterator();

								while (i.hasNext()) {
									Map.Entry me = (Map.Entry) i.next();
									GWT.log(me.getKey() + ": " + me.getValue());
								}

								form.mask("Processing .........", "x-mask-loading").show();
								service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
									public void onFailure(Throwable caught) {
										GWT.log(caught.getMessage(), null);
									}

									public void onSuccess(List<Map> result) {
										form.unmask();
										MessageBox.alert("Information", result.get(0).get("message").toString(), new Listener<MessageBoxEvent>() {

											@Override
											public void handleEvent(MessageBoxEvent be) {
												form.reset();
												gridUser.mask("Load Data ...", "x-mask-loading");
												getListUser();
											}
										});

									}
								});
							}
						}
					});
					// } //end
				}
			}
		});
		
		form.add(p);
		
	    return form;
		
//	    ===== west panel ======   
	}
	
	
	private void initStore() {				
		storeGetUser = new GroupingStore();	
		storeGetDefaultPage = new ListStore();
		storeGetGroupPage = new ListStore();
	}
	private TabPanel pageTabPanel(){
		pagePanel = new TabPanel();  
		pagePanel.setBorders(false);  
		
		
		    TabItem item1 = new TabItem("Default Page");
		    gridDefaultPage = createGridDefaultPage();
		    item1.setLayout(new FitLayout());
		    item1.add(gridDefaultPage);  
		    pagePanel.add(item1);
		    
		    TabItem item2 = new TabItem("Group Page");  
		    gridGroupPage = createGridGroupPage();
		    item2.setLayout(new FitLayout());
		    item2.add(gridGroupPage);
		    pagePanel.add(item2);  
		    
		  return pagePanel;  
	}
	private Grid createGridDefaultPage(){
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		ColumnConfig column = new ColumnConfig();
		
		column = new ColumnConfig();
		column.setId("module_name");
		column.setHeader("Module Name");
		column.setWidth(250);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("is_load");
		column.setHeader("Is Load");
		column.setWidth(60);
		configs.add(column);
		
		storeGetDefaultPage.setMonitorChanges(true);

		final ColumnModel cm = new ColumnModel(configs);

		gridDefaultPage = new Grid(storeGetDefaultPage, cm);
		gridDefaultPage.setLoadMask(true);
		gridDefaultPage.mask("Load Data ...", "x-mask-loading");
		gridDefaultPage.getView().setEmptyText("Data Empty");
//		gridDefaultPage.setBorders(false);
		
		return gridDefaultPage;
	}
	private Grid createGridGroupPage(){
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		ColumnConfig column = new ColumnConfig();
		
		column = new ColumnConfig();
		column.setId("module_name");
		column.setHeader("Group Name");
		column.setWidth(250);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("is_load");
		column.setHeader("Is Load");
		column.setWidth(60);
		configs.add(column);
		
		storeGetGroupPage.setMonitorChanges(true);

		final ColumnModel cm = new ColumnModel(configs);

		gridGroupPage = new Grid(storeGetGroupPage, cm);
		gridGroupPage.setLoadMask(true);
		gridGroupPage.mask("Load Data ...", "x-mask-loading");
		gridGroupPage.getView().setEmptyText("Data Empty");
//		gridGroupPage.setBorders(false);
		
		return gridGroupPage;
	}
	private Grid createGridUser() {

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		storeGetUser.groupBy("status");
		
		ColumnConfig column = new ColumnConfig();

		column = new ColumnConfig();
		column.setId("id_user");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);


		column = new ColumnConfig();
		column.setId("login_name");
		column.setHeader("Login Name");
		column.setWidth(150);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("first_name");
		column.setHeader("First Name");
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("last_name");
		column.setHeader("Last Name");
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("phone_number");
		column.setHeader("Mobile phone");
		column.setWidth(90);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("email");
		column.setHeader("Email");
		column.setWidth(200);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("birt_day");
		column.setHeader("Birthday");
		column.setWidth(90);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("gender");
		column.setHeader("Gender");
		column.setWidth(60);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("createdate");
		column.setHeader("Register Date");
		column.setWidth(90);
		configs.add(column);

		storeGetUser.setMonitorChanges(true);

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
				
		gridUser = new Grid(storeGetUser, cm);
		gridUser.setLoadMask(true);
		gridUser.mask("Load Data ...", "x-mask-loading");
		gridUser.getView().setEmptyText("Data Empty");
		gridUser.setView(view);
		gridUser.setBorders(false);
		gridUser.addListener(Events.CellClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent ge) {
				textLoginName.setValue(gridUser.getSelectionModel().getSelectedItem().get("login_name").toString());
				textRegisterDate.setValue(gridUser.getSelectionModel().getSelectedItem().get("createdate").toString());
				textGender.setValue(gridUser.getSelectionModel().getSelectedItem().get("gender").toString());
				textBirthDay.setValue(gridUser.getSelectionModel().getSelectedItem().get("birt_day").toString());
				textFirstName.setValue(gridUser.getSelectionModel().getSelectedItem().get("first_name").toString());
				textLastName.setValue(gridUser.getSelectionModel().getSelectedItem().get("last_name").toString());
				textMobileNum.setValue(gridUser.getSelectionModel().getSelectedItem().get("phone_number").toString());
				textEmail.setValue(gridUser.getSelectionModel().getSelectedItem().get("email").toString());
				textUserStatus.setValue(gridUser.getSelectionModel().getSelectedItem().get("status").toString());
				
				gridDefaultPage.mask("Load Data ...", "x-mask-loading");
				getListPage("default",gridUser.getSelectionModel().getSelectedItem().get("id_user").toString());
				gridGroupPage.mask("Load Data ...", "x-mask-loading");
				getListPage("group",gridUser.getSelectionModel().getSelectedItem().get("id_user").toString());
			}
		});
		return gridUser;
	}

	private void getListPage(String page,String idUser) {
		Map mapParam = new FastMap();
		mapParam.put("code", "");
		mapParam.put("id_user", idUser);
		
		if (page.equals("default")){
			mapParam.put("func_name", "GETDEFAULTPAGE");
			service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
				@Override
				public void onFailure(Throwable caught) {
					gridDefaultPage.unmask();
				}

				@Override
				public void onSuccess(List<Map> result) {
					// TODO Auto-generated method stub
					storeGetDefaultPage.removeAll();
					storeGetDefaultPage.add(ClientModule.setListBaseModelFromListMap(result));
					gridDefaultPage.unmask();				
				}
			});
		}else{
			mapParam.put("func_name", "GETGROUPPAGE");
		service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
			@Override
			public void onFailure(Throwable caught) {
				gridGroupPage.unmask();
			}

			@Override
			public void onSuccess(List<Map> result) {
				// TODO Auto-generated method stub
				storeGetGroupPage.removeAll();
				storeGetGroupPage.add(ClientModule.setListBaseModelFromListMap(result));
				gridGroupPage.unmask();				
			}
		});
		}
	}
	
	private void getListUser() {
		Map mapParam = new FastMap();
		mapParam.put("code", "");
		mapParam.put("func_name", "GETUSERREGISTER");
		service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
			@Override
			public void onFailure(Throwable caught) {
				gridUser.unmask();
			}

			@Override
			public void onSuccess(List<Map> result) {
				// TODO Auto-generated method stub
				storeGetUser.removeAll();
				storeGetUser.add(ClientModule.setListBaseModelFromListMap(result));
				gridUser.unmask();				
			}
		});
	}
	private void deleteAccount(final String userId){
		
	MessageBox.confirm("Info", "Apakah Anda Yakin Ingin Menyimpan Data?", new Listener<MessageBoxEvent>() {
		
		@Override
		public void handleEvent(MessageBoxEvent be) {
			// TODO Auto-generated method stub
			Button btn = be.getButtonClicked();					
					if (btn.getText().equals("Yes")) {
							Map mapParam = new FastMap();
							mapParam.put("code", "");
							mapParam.put("id_user",userId);
							mapParam.put("func_name", "SETUSERDELETE");
							
							service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
								@Override
								public void onFailure(Throwable caught) {
									gridUser.unmask();
								}
					
								@Override
								public void onSuccess(final List<Map> result) {
									// TODO Auto-generated method stub
									MessageBox.alert("Information", result.get(0).get("message").toString().toLowerCase(), new Listener<MessageBoxEvent>() {

										@Override
										public void handleEvent(MessageBoxEvent be) {											
											form.reset();
											gridUser.mask("Load Data ...", "x-mask-loading");
											getListUser();
										}
									});
													
								}
							});
					}
			}	
		});	
					
	}
	private void popresetpwd(String loginTitle,final String userId) {     
			final Window window = new Window();  
		    window.setSize(500, 150);  
		    window.setPlain(true);  
		    window.setModal(true);  
		    window.setBlinkModal(true);  
		    window.setHeading("Reset Password " + loginTitle);  
		    window.setLayout(new FitLayout());
		    
		    
		    
		    FormData formData = new FormData("-20");
		    
		    ContentPanel cp = new ContentPanel();  
		    cp.setHeading("center BorderLayout Example");  
		    cp.setHeaderVisible(false);
		    cp.setScrollMode(Scroll.AUTOX);
		    
		    FieldSet fieldSet = new FieldSet();
			fieldSet.setHeading("");
			fieldSet.setBorders(false);
			fieldSet.setCollapsible(false);
			
			FormLayout layout = new FormLayout();
			layout.setLabelWidth(100);
			fieldSet.setLayout(layout);
		    
			textNewPwd  = new TextField<String>();
			textNewPwd.setName("new_password");
			textNewPwd.setWidth(130);
			textNewPwd.setPassword(true);
			textNewPwd.setFieldLabel("New Password");
			fieldSet.add(textNewPwd, formData);								
			
			textRetypePwd= new TextField<String>();
			textRetypePwd.setName("retype_password");
			textRetypePwd.setWidth(130);
			textRetypePwd.setPassword(true);
			textRetypePwd.setAllowBlank(false);
			textRetypePwd.setFieldLabel("Retype Password");
			fieldSet.add(textRetypePwd, formData);
			
			cp.add(fieldSet);
			
			window.add(cp);  
			
			window.addButton(new Button("Save", new SelectionListener<ButtonEvent>() {  
		        @Override  
		        public void componentSelected(ButtonEvent ce) {  
		        	if (!form.isValid()) {
						MessageBox.info("Warning", "Please check your Data Entry", null);
						return;
					} else {
						MessageBox.confirm("Info", "Apakah Anda Yakin Ingin Menyimpan Data?", new Listener<MessageBoxEvent>() {

							@Override
							public void handleEvent(MessageBoxEvent be) {
								// TODO Auto-generated method stub
								Button btn = be.getButtonClicked();
								
								if (textNewPwd.getRawValue().equals(textRetypePwd.getRawValue())){
								
										if (btn.getText().equals("Yes")) {
											mapParam = new FastMap();
											
											mapParam.put("id_user",userId);
											mapParam.put("password",textNewPwd.getRawValue());
		
											mapParam.put("code", "");
											mapParam.put("func_name", "SETRESETPASSWORD");
											
											Set set = mapParam.entrySet();
											Iterator i = set.iterator();
		
											while (i.hasNext()) {
												Map.Entry me = (Map.Entry) i.next();
												GWT.log(me.getKey() + ": " + me.getValue());
											}									
											service.getUtilDao("", mapParam, new AsyncCallback<List<Map>>() {
												public void onFailure(Throwable caught) {
													GWT.log(caught.getMessage(), null);
												}
		
												public void onSuccess(List<Map> result) {
//													MessageBox.alert("Information", result.get(0).get("message").toString(), null);										
													MessageBox.alert("Information", result.get(0).get("message").toString().toLowerCase(), new Listener<MessageBoxEvent>() {

														@Override
														public void handleEvent(MessageBoxEvent be) {
															window.close();
														}
													});

												}
											});
										}
								}else{
									MessageBox.alert("Information", "Invalid New Password and Retype password ", null);
									return;
								}
							}
						});
					}
		        }	
		      })
			);
			
		    window.addButton(new Button("Close", new SelectionListener<ButtonEvent>() {  
		        @Override  
		        public void componentSelected(ButtonEvent ce) {  
		          window.hide();  
		        }  
		      }));  
		    window.show();
	}
}
