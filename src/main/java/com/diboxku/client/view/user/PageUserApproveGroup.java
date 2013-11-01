package com.diboxku.client.view.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.diboxku.client.app.service.DiboxkuToolsService;
import com.diboxku.client.app.service.DiboxkuToolsServiceAsync;
import com.diboxku.client.util.ClientModule;
import com.diboxku.client.util.TextFieldUppercase;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PageUserApproveGroup extends LayoutContainer {
	
	private final DiboxkuToolsServiceAsync service = GWT.create(DiboxkuToolsService.class);
		
	private ListStore storeGetGroupPage,storeGetGroupRequest;
	private Grid gridGroupPage,gridGroupUserRequest;	
	private ContentPanel center,north,east,south,west;
	private FormPanel form;
	private TabPanel pagePanel;
	private BorderLayout layout;	
	
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
		    
		    gridGroupUserRequest = createGridUserRequest();	
			ToolBar toolBarTitle = new ToolBar();
			toolBarTitle.add(new LabelToolItem("<b>Data Users Request</b>"));			
			toolBarTitle.add(new SeparatorToolItem());	
			Button buttonApprovUser = new Button("Approve User");
			buttonApprovUser.addSelectionListener(new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					// TODO Auto-generated method stub
					
//					int rowIndex;
//					
//					rowIndex = gridGroupUserRequest.getStore().indexOf(gridGroupUserRequest.getSelectionModel().getSelectedItem());
//					
//					GWT.log("x " + rowIndex);
//					
//					if (rowIndex >= 0 ){
//						
////						String loginUser = gridGroupUserRequest.getSelectionModel().getSelectedItem().get("login_name").toString();
//						String idUser = gridGroupUserRequest.getSelectionModel().getSelectedItem().get("id_user").toString();
//						
////						popresetpwd(loginUser,idUser);						
//					}else{
//						MessageBox.alert("Info", "Please Select one of Account", null);
//					}
					
					MessageBox.alert("Info", "Please Select one of Account", null);
					
				}
			});
			buttonApprovUser.setIcon(IconHelper.createStyle("icon-grid"));
			toolBarTitle.add(buttonApprovUser);
			
		    center.setHeaderVisible(false);
		    center.setLayout(new RowLayout(Orientation.HORIZONTAL));
		    center.add(gridGroupUserRequest, new RowData(1, 1));		    
		    center.setTopComponent(toolBarTitle);
		    
		    return center;
	}
	private ContentPanel westPanel(){
	    
	    west = new ContentPanel();  
	    west.setHeading("west");
	    
	    gridGroupPage = createGridGroupPage();
	    ToolBar toolBarTitle = new ToolBar();
		toolBarTitle.add(new LabelToolItem("<b>Data Group Page</b>"));			
		toolBarTitle.add(new SeparatorToolItem());
		Button buttonReload = new Button("Reload");
		buttonReload.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				gridGroupPage.mask("load Data ...", "x-mask-loading");
				getListPage("group","");
			}
		});
		buttonReload.setIcon(IconHelper.createStyle("icon-refresh"));
		toolBarTitle.add(buttonReload);
	    
	    west.setHeaderVisible(false);
	    west.setBodyBorder(true);
	    west.setLayout(new RowLayout(Orientation.VERTICAL));
	    west.add(gridGroupPage, new RowData(1, 1));
	    west.setTopComponent(toolBarTitle);
	    
	    return west;
	}
	private Grid createGridUserRequest(){
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		ColumnConfig column = new ColumnConfig();
		
		column = new ColumnConfig();
		column.setId("id_user");
		column.setHidden(true);
		column.setWidth(60);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("account_name");
		column.setHeader("Account name");
		column.setWidth(250);
		configs.add(column);

		
		column = new ColumnConfig();
		column.setId("date_request");
		column.setHeader("Date Req");
		column.setWidth(60);
		configs.add(column);
		
		storeGetGroupRequest.setMonitorChanges(true);

		final ColumnModel cm = new ColumnModel(configs);

		gridGroupUserRequest = new Grid(storeGetGroupRequest, cm);
		gridGroupUserRequest.setLoadMask(true);
//		gridGroupUserRequest.mask("Load Data ...", "x-mask-loading");
		gridGroupUserRequest.getView().setEmptyText("Data Empty");
//		gridGroupPage.setBorders(false);
		
		return gridGroupUserRequest;
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
		column.setId("user_request");
		column.setHeader("User Req");
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
	private void initStore() {				
		storeGetGroupRequest = new ListStore();
		storeGetGroupPage = new ListStore();
	}
	private void getListPage(String page,String idUser) {
		Map mapParam = new FastMap();
		mapParam.put("code", "");
//		mapParam.put("id_user", idUser);		
		if (page.equals("group")){		
			mapParam.put("func_name", "GETLISTGROUPPAGE");
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
}
