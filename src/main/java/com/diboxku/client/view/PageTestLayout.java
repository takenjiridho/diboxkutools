package com.diboxku.client.view;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Element;


public class PageTestLayout extends LayoutContainer {
//	private final DinamisRPCServicesAsync serviceDao = GWT.create(DinamisRPCServices.class);
	
	private ListStore storeBulan, storeTahun, storePembangkit;
	private Grid gridPengiriman, gridPembangkit;
	private Grid gridRakor, gridDinamis;
	private GroupingStore storeRakor,storeDinamis;
	private ListStore storePengiriman,storeDinamisKolom;
	private ContentPanel west,center,north,east,south;
	private BorderLayout layout;
	private Map mapParam;
	private List<String> newCols = new ArrayList<String>();
	private Menu menu;
	private List<Map> resultDinamis;
	private String groupBy;
	private ColumnModel cm;
	private MenuItem menuItemSIL;
	private ContentPanel cp;
	private MenuItem menuItemSIS;
	private MenuItem menuItemSIB;
	private MenuItem menuItemCOA;
	private MenuItem menuItemCOW;
	private MenuItem menuItemBABongkar;
	private MenuItem menuItemBAST;
	private MenuItem menuItemBAPH;
	private MenuItem menuItemBAKeterlambatan;
	private MenuItem menuItemRincianDenda;
	private MenuItem menuItemBAPenolakan;
	private Button btnViewShip;
	private Button btnViewBA;
	
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
	  
	    BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 300);  
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
		    
//		    gridPengiriman = createGridPengiriman();	
		    gridDinamis = createGridDinamis();
			ToolBar tbPltu = new ToolBar();
			tbPltu.add(new LabelToolItem("<b>Data Pengiriman</b>"));
		    
			btnViewShip = new Button("View Dok Ship");
			btnViewShip.setMenu(viewMenuShipment());
			btnViewShip.setIcon(IconHelper.createStyle("icon-open-download"));
			btnViewShip.setEnabled(false);
			tbPltu.add(new SeparatorToolItem());
			tbPltu.add(btnViewShip);

			btnViewBA = new Button("View Dok BA");
			btnViewBA.setMenu(viewMenuBA());
			btnViewBA.setIcon(IconHelper.createStyle("icon-open-download"));
			btnViewBA.setEnabled(false);
			tbPltu.add(new SeparatorToolItem());
			tbPltu.add(btnViewBA);
			tbPltu.add(new SeparatorToolItem());
		    
		    center.setHeaderVisible(false);
		    center.setLayout(new RowLayout(Orientation.HORIZONTAL));
//		    center.add(gridPengiriman, new RowData(1, 1));		    
		    center.add(gridDinamis, new RowData(1, 1));
		    center.setTopComponent(tbPltu);
		    
//		    FlexTable table = new FlexTable();  
//		    table.getElement().getStyle().setProperty("margin", "10px");  
//		    table.setCellSpacing(8);  
//		    table.setCellPadding(4);  
//		  
//		    for (int i = 0; i < LayoutRegion.values().length; i++) {  
//		      final LayoutRegion r = LayoutRegion.values()[i];  
//		      if (r == LayoutRegion.CENTER) {  
//		        continue;  
//		      }  
//		      SelectionListener<ButtonEvent> sl = new SelectionListener<ButtonEvent>() {  
//		  
//		        @Override  
//		        public void componentSelected(ButtonEvent ce) {  
//		          String txt = ce.getButton().getText();  
//		          if (txt.equals("Expand")) {  
//		            layout.expand(r);  
//		          } else if (txt.equals("Collapse")) {  
//		            layout.collapse(r);  
//		          } else if (txt.equals("Show")) {  
//		            layout.show(r);  
//		          } else {  
//		            layout.hide(r);  
//		          }  
//		  
//		        }  
//		      };  
//		      table.setHTML(i, 0, "<div style='font-size: 12px; width: 100px'>" + r.name() + ":</span>");  
//		      table.setWidget(i, 1, new Button("Expand", sl));  
//		      table.setWidget(i, 2, new Button("Collapse", sl));  
//		      table.setWidget(i, 3, new Button("Show", sl));  
//		      table.setWidget(i, 4, new Button("Hide", sl));  
//		    }  
//		    center.add(table);  
		    
		    return center;
	}
	
	private ContentPanel westPanel(){
//	    ===== west panel ====== 
	    
		west = new ContentPanel();
	    west.setHeading("west");
	    west.setHeaderVisible(false);
//	    west.setLayout(new FitLayout());
	    west.setLayout(new RowLayout(Orientation.VERTICAL));
	    
	    Button btMin = new Button("", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				west.collapse();
			}
		});
	    btMin.setIcon(IconHelper.createStyle("icon-collapse",16,16));
	    
	    
	    Button btload = new Button("Reload", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				gridPembangkit.mask("load Data ...", "x-mask-loading");
				storeRakor.removeAll();
				storePengiriman.removeAll();
				btnViewBA.setEnabled(false);
				btnViewShip.setEnabled(false);
//				getListPembangkit();
			}
		});
		btload.setIcon(IconHelper.createStyle("icon-refresh"));
		
	    
	    gridPembangkit = createGridPembangkit();
		ToolBar tbShip = new ToolBar();
		tbShip.add(btMin);
		tbShip.add(new LabelToolItem("<b>Data PLTU</b>"));
		tbShip.add(new SeparatorToolItem());
		tbShip.add(btload);
		tbShip.add(new SeparatorToolItem());
	    
		gridRakor = createGridRakor();
		
	    west.add(gridPembangkit,new RowData(1, .4));
	    west.add(gridRakor, new RowData(1, .6));
	    west.setTopComponent(tbShip);
	    
	    return west;
		
//	    ===== west panel ======   
	}
	
	private void initStore() {				
		storePembangkit = new ListStore();
		storeDinamisKolom = new ListStore();
		storePengiriman = new GroupingStore();
		storeRakor = new GroupingStore();
		storeDinamis = new GroupingStore();		
//		getListPembangkit();
		
	}
	
	private Grid createGridPembangkit() {

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig column = new ColumnConfig();

		column = new ColumnConfig();
		column.setId("id_pemasok");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("id_pltu");
		column.setHidden(true);
		column.setWidth(1);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("nama_pembangkit");
		column.setHeader("Nama Pembangkit");
		column.setWidth(200);
		configs.add(column);

		storePembangkit.setMonitorChanges(true);

		ColumnModel cm = new ColumnModel(configs);

		gridPembangkit = new Grid(storePembangkit, cm);
		gridPembangkit.setLoadMask(true);
		gridPembangkit.mask("load Data ...", "x-mask-loading");
		gridPembangkit.getView().setEmptyText("Data Empty");
		gridPembangkit.setBorders(false);
		gridPembangkit.addListener(Events.CellClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent ge) {
				gridRakor.mask("load Data ...", "x-mask-loading").show();
//				storePengiriman.removeAll();
//				getListRakor();
				
			}
		});
		return gridPembangkit;
	}
	private Grid createGridRakor() {
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		storeRakor.groupBy("tahun");
//		storeRakor.isGroupOnSort();
		
		ColumnConfig column = new ColumnConfig();

		column = new ColumnConfig();
		column.setId("id_rakor");
		column.setHidden(true);
		column.setWidth(10);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("no_rakor");
		column.setHeader("No Rakor");
		column.setWidth(150);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("tanggal");
		column.setHeader("BLTH");
		column.setWidth(100);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("tahun");
		column.setHeader("Tahun");
		column.setWidth(10);
		column.setHidden(true);
		configs.add(column);

		storeRakor.setMonitorChanges(true);
//		storeRakor.setSortField("tanggal");

		final ColumnModel cm = new ColumnModel(configs);
		GroupingView view = new GroupingView();
		view.setShowGroupedColumn(false);
		view.setStartCollapsed(rendered);
		view.setGroupRenderer(new GridGroupRenderer() {
			@Override
			public String render(GroupColumnData data) {
				// TODO Auto-generated method stub
				String f = cm.getColumnById(data.field).getHeader();
				String l = data.models.size() == 1 ? "Tahun" : "tahun";
				return f + ": " + data.group;
			}
		});

		gridRakor = new Grid(storeRakor, cm);
		gridRakor.setLoadMask(true);
		gridRakor.getView().setEmptyText("Data Empty");
		gridRakor.setView(view);
		gridRakor.setBorders(false);
		gridRakor.addListener(Events.CellClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent ge) {
				try {
//					loadData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return gridRakor;

	}
	
//	private void getListPembangkit() {
//		Map mapParam = new FastMap();
//		mapParam.put("crud", "PLN");
////		serviceDao.getUtilDao("GETDATA_PEMBANGKIT", mapParam, new AsyncCallback<List<Map>>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				gridPembangkit.unmask();
//			}
//
//			@Override
//			public void onSuccess(List<Map> result) {
//				// TODO Auto-generated method stub
//				storePembangkit.removeAll();
////				storePembangkit.add(ClientModule.setListBaseModelFromListMap(result));
//				gridPembangkit.unmask();
////				loadDataKolom("G_TRACKING_SHIPMENT");
//			}
//		});
//	}
//	private void getListRakor() {
//		Map mapParam = new FastMap();
//		mapParam.put("id_pltu", gridPembangkit.getSelectionModel().getSelectedItem().get("id_pltu").toString());
//		mapParam.put("id_pemasok", Registry.get("idPltu"));
//		mapParam.put("crud", "GETDATA_RAKOR");
//		serviceDao.getUtilDao("GETDATA_RAKOR", mapParam, new AsyncCallback<List<Map>>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				gridRakor.unmask();
//			}
//
//			@Override
//			public void onSuccess(List<Map> result) {
//				// TODO Auto-generated method stub
//				storeRakor.removeAll();
//				storeRakor.add(ClientModule.setListBaseModelFromListMap(result));
//				gridRakor.unmask();
//			}
//		});
//	}
//	private void loadDataKolom(String dpNamaUi){
//		Map mapParam = new FastMap();
//		mapParam.put("dp_namaui", "G_TRACKING_SHIPMENT");
//		mapParam.put("crud", "GETKOLOM_TS");
//		serviceDao.getUtilDao("GETLISTKOLOM_TS", mapParam, new AsyncCallback<List<Map>>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//					System.out.println("on failure " );
//			}
//
//			@Override
//			public void onSuccess(List<Map> result) {
//				// TODO Auto-generated method stub			
////				storeDinamisKolom.add(ClientModule.setListBaseModelFromListMap(result));
//				System.out.println("getcountx = " + storeDinamisKolom.getCount());
//				
//				List<String> newColsx = new ArrayList<String>();
////				newColsx.add("bln");
//				List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//				for (int i = 0; i < result.size(); i++) {  
//					if (result.get(i).get("setgroup").toString().equals("1")){
//						groupBy = result.get(i).get("setid").toString();
//						storeDinamis.groupBy(groupBy);
////						newColsx.add(result.get(i).get("setid").toString().toLowerCase());
//					}else{
//						newColsx.add(result.get(i).get("setid").toString().toLowerCase());
////						System.out.println("setid = " +  storeDinamisKolom.getAt(i).get("setid").toString());
////						System.out.println("setcol = " +  string);
//						ColumnConfig columnConfig = new ColumnConfig();
//						columnConfig.setId(result.get(i).get("setid").toString().toLowerCase());
//						columnConfig.setHeader(result.get(i).get("setheader").toString());
//						columnConfig.setWidth(100);
////							columnConfig.setAlignment(string.equals("bln") ? HorizontalAlignment.LEFT : HorizontalAlignment.RIGHT);
//						configs.add(columnConfig);
//					}
//				}
//				
////				System.out.println("groupby = " + groupBy);
////				storeDinamis.groupBy(groupBy);
//				
//				
//				
//				
//				
////				for (String string : newColsx) {
////					System.out.println("setcol = " +  string);
////					ColumnConfig columnConfig = new ColumnConfig();
////					columnConfig.setId(string);
////					columnConfig.setHeader(string+"x");
////					columnConfig.setWidth(100);
//////						columnConfig.setAlignment(string.equals("bln") ? HorizontalAlignment.LEFT : HorizontalAlignment.RIGHT);
////					configs.add(columnConfig);
////				}
//				cm = new ColumnModel(configs);
//				
//				gridDinamis.reconfigure(storeDinamis, cm);
////				gridDinamis.getView().refresh(true);
////				gridDinamis.setView(view);
//				
//			}
//		});
//	}
	private Grid createGridDinamis() {
		// TODO Auto-generated method stub
		
			
//		newCols.add("bln");
//		newCols.add("status");
//		for (String string : newCols) {
//			ColumnConfig columnConfig = new ColumnConfig();
//			columnConfig.setHeader(resultDinamis.get(i).get("setid").toString());
//			columnConfig.setId(resultDinamis.get(i).get("setheader").toString());
//			columnConfig.setWidth(100);
////			columnConfig.setAlignment(string.equals("bln") ? HorizontalAlignment.LEFT : HorizontalAlignment.RIGHT);
//			configs.add(columnConfig);
//		}
						
		storeDinamis.groupBy("no");
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
//		for (String string : newCols) {
//			System.out.println("setcol = " +  string);
			ColumnConfig columnConfig = new ColumnConfig();
			columnConfig.setHeader("No");
			columnConfig.setId("no");
			columnConfig.setWidth(100);
//				columnConfig.setAlignment(string.equals("bln") ? HorizontalAlignment.LEFT : HorizontalAlignment.RIGHT);
			configs.add(columnConfig);
//		}
		cm = new ColumnModel(configs);
		storeDinamis.setMonitorChanges(true);

		cm = new ColumnModel(configs);
		GroupingView view = new GroupingView();
		view.setShowGroupedColumn(false);
		view.setGroupRenderer(new GridGroupRenderer() {
			@Override
			public String render(GroupColumnData data) {
				// TODO Auto-generated method stub
				String f = cm.getColumnById(data.field).getHeader();
				String l = data.models.size() == 1 ? "no" : "no";
				return f + ": " + data.group;
			}
		});
		
		gridDinamis = new Grid(storeDinamis, cm);
		gridDinamis.getView().setEmptyText("Data Empty");
		gridDinamis.setView(view);
		gridDinamis.setLoadMask(true);
		gridDinamis.setBorders(false);
	

		return gridDinamis;
	}
//	private void loadData() {
//		gridPengiriman.mask("load Data ....", "x-mask-loading").show();
//
//		Map mapParam = new FastMap();
//		mapParam.put("no_rakor", gridRakor.getSelectionModel().getSelectedItem().get("no_rakor").toString());
//		mapParam.put("id_pltu", gridPembangkit.getSelectionModel().getSelectedItem().get("id_pltu").toString());
//		mapParam.put("id_pemasok", Registry.get("idPltu"));
//		mapParam.put("crud", "GETDATA_PENGIRIMAN");
//		serviceDao.getUtilDao("GETDATA_PENGIRIMAN", mapParam, new AsyncCallback<List<Map>>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				gridPengiriman.unmask();
//			}
//
//			@Override
//			public void onSuccess(List<Map> result) {
//				// TODO Auto-generated method stub
//				storePengiriman.removeAll();
//				storePengiriman.add(ClientModule.setListBaseModelFromListMap(result));
//				gridPengiriman.unmask();
//			}
//		});
//	}
	private void getListPengiriman(final String codectrl) {
		Map mapParam = new FastMap();
		mapParam.put("id_pemasok", Registry.get("idPltu"));
		mapParam.put("id_pltu", Registry.get("id_pltu"));

//		service.getListPengiriman(codectrl, mapParam, new AsyncCallback<List<Map>>() {
//			public void onFailure(Throwable caught) {
//				GWT.log(caught.getMessage(), null);
//			}
//
//			public void onSuccess(List<Map> result) {
//				if (codectrl.equals("PORTLISTPLTU")) {
//					storePembangkit.removeAll();
//					storePembangkit.add(ClientModule.setListBaseModelFromListMap(result));
//					gridPembangkit.unmask();
//				} else if (codectrl.equals("DAFTARPENGIRIMANBYPLTU")) {
//					storePengiriman.removeAll();
//					storePengiriman.add(ClientModule.setListBaseModelFromListMap(result));
//					gridPengiriman.unmask();
//
//				}
//			}
//		});
	}
	private Grid createGridPengiriman() {
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig column = new ColumnConfig();

		column = new ColumnConfig();
		column.setId("no");
		column.setHeader("No.");
		column.setWidth(50);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("no_jadwal");
		column.setHeader("No Jadwal");
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("kapal");
		column.setHeader("Nama Kapal");
		column.setWidth(240);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("status");
		column.setHeader("Status");
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("no_pengiriman");
		column.setHeader("No Pengiriman");
		column.setHidden(true);
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("tgl_td");
		column.setHeader("TD");
		column.setWidth(90);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("tgl_ta");
		column.setHeader("ETA");
		column.setWidth(90);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("ta");
		column.setHeader("TA");
		column.setWidth(90);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("tgl_antri");
		column.setHeader("Tgl Antri");
		column.setWidth(90);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setHidden(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("tgl_bongkar");
		column.setHeader("Tgl Bongkar");
		column.setWidth(90);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("time_selesai");
		column.setHeader("Tgl Selesai");
		column.setWidth(90);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("volume");
		column.setHeader("Volume (Ton)");
		column.setWidth(90);
		column.setAlignment(HorizontalAlignment.RIGHT);
		configs.add(column);

//		storePengiriman.setMonitorChanges(true);

		final ColumnModel cm = new ColumnModel(configs);

		gridPengiriman = new Grid(storePengiriman, cm);
		gridPengiriman.getView().setEmptyText("Data Empty");
		gridPengiriman.setBorders(false);
		gridPengiriman.addListener(Events.CellClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent ge) {
				try {
					btnViewBA.setEnabled(true);
					btnViewShip.setEnabled(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		return gridPengiriman;
	}
	private Menu viewMenuShipment() {
		menu = new Menu();

		menu.setAutoWidth(true);

		menuItemSIL = new MenuItem("Surat Izin Loading");
		menuItemSIL.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("no_sil").toString().equals("")) {
					MessageBox.alert("Info", "Tidak Ada Surat Izin Loading", null);
				} else if (!gridPengiriman.getSelectionModel().getSelectedItem().get("flag_loading").toString().equals("1")) {
					MessageBox.alert("Info", "Permohonan Izin Loading Belum Di Setujui", null);
				} else {
					showViewJasper("SIL", "");
				}
			}
		});
		menu.add(menuItemSIL);

		menuItemSIS = new MenuItem("Surat Izin Sandar");
		menuItemSIS.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("no_sis").toString().equals("")) {
					MessageBox.alert("Info", "Belum Ada Surat Izin Sandar", null);
				} else if (!gridPengiriman.getSelectionModel().getSelectedItem().get("flag_pis").toString().equals("1")) {
					MessageBox.alert("Info", "Permohonan Izin Sandar Belum Di Setujui", null);
				} else {
					showViewJasper("SIS", "");
				}
			}
		});
		menu.add(menuItemSIS);

		menuItemSIB = new MenuItem("Surat Izin Bongkar");
		menuItemSIB.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("no_sib").toString().equals("")) {
					MessageBox.alert("Info", "Belum Ada Surat Izin Bongkar", null);
				} else if (!gridPengiriman.getSelectionModel().getSelectedItem().get("flag_bongkar").toString().equals("1")) {
					MessageBox.alert("Info", "Permohonan Izin Bongkar Belum Di Setujui", null);
				} else {
					showViewJasper("SIB", "");
				}
			}
		});
		menu.add(menuItemSIB);

		menuItemCOA = new MenuItem("COA");
		menuItemCOA.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("coa").toString().equals("") || gridPengiriman.getSelectionModel().getSelectedItem().get("coa").toString().equals("n")) {
					MessageBox.alert("Info", "Belum Ada COA Dari Surveyor", null);
				} else {
//					showViewBLOB("BLOB_COAA", "BLOB_COAA", gridPengiriman.getSelectionModel().getSelectedItem().get("id_pengiriman").toString());
				}
			}
		});
		menu.add(menuItemCOA);

		menuItemCOW = new MenuItem("COW");
		menuItemCOW.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("cow").toString().equals("") || gridPengiriman.getSelectionModel().getSelectedItem().get("cow").toString().equals("n")) {
					MessageBox.alert("Info", "Belum Ada COW Dari Surveyor", null);
				} else {
//					showViewBLOB("BLOB_COWW", "BLOB_COWW", gridPengiriman.getSelectionModel().getSelectedItem().get("id_pengiriman").toString());
				}
			}
		});
		menu.add(menuItemCOW);

		return menu;
	}

	private Menu viewMenuBA() {
		menu = new Menu();

		menu.setAutoWidth(true);

		menuItemBABongkar = new MenuItem("BA Bongkar");
		menuItemBABongkar.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("no_ba_bongkar").toString().equals("")) {
					MessageBox.alert("Info", "Belum Ada BA Bongkar", null);
				} else {
//					showViewBirt("BAB");
				}
			}
		});
		menu.add(menuItemBABongkar);

		menuItemBAST = new MenuItem("BA Serah Terima");
		menuItemBAST.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("no_ba_penerimaan").toString().equals("")
						|| gridPengiriman.getSelectionModel().getSelectedItem().get("no_bongkar").toString().equals("")) {
					MessageBox.alert("Info", "Belum Ada BA Serah Terima", null);
				} else {
					showViewJasper("BAST", "");
				}
			}
		});
		menu.add(menuItemBAST);

		menuItemBAPH = new MenuItem("BA Perhitungan Harga");
		menuItemBAPH.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("no_perhitungan_harga").toString().equals("")) {
					MessageBox.alert("Info", "Belum Ada Perhitungan Harga", null);
				} else {
					showViewJasper("BAPH", "");
				}
			}
		});
		menu.add(menuItemBAPH);

		menuItemBAPenolakan = new MenuItem("BA Penolakan");
		menuItemBAPenolakan.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("no_ba_penolakan").toString().equals("")) {
					MessageBox.alert("Info", "Tidak Ada BA Penolakan", null);
				} else {
//					showViewBirt("BAP");
				}
			}
		});
		menu.add(menuItemBAPenolakan);

		menuItemBAKeterlambatan = new MenuItem("BA Keterlambatan");
		menuItemBAKeterlambatan.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("no_ba_keterlambatan").toString().equals("")) {
					MessageBox.alert("Info", "Tidak Ada BA Keterlambatan", null);
				} else {
//					showViewBirt("BAK");
				}
			}
		});
		menu.add(menuItemBAKeterlambatan);

		menuItemRincianDenda = new MenuItem("Rincian Denda Keterlambatan");
		menuItemRincianDenda.addSelectionListener(new SelectionListener<MenuEvent>() {

			@Override
			public void componentSelected(MenuEvent ce) {
				if (gridPengiriman.getSelectionModel().getSelectedItem().get("jml_denda").toString().equalsIgnoreCase("0")) {
					MessageBox.info("Informasi", "Maaf Tidak Ada Denda Keterlambatan", null);
					return;
				} else {
					cp.mask("Loading Data ..............", "x-mask-loading").show();

					Map mapParam = new FastMap();
//					serviceReport.getBirtPrintService("", mapParam, new AsyncCallback<List<Map>>() {
//
//						@Override
//						public void onSuccess(List<Map> result) {
//
//							String host = result.get(0).get("host").toString();
//							String output = result.get(0).get("output").toString();
//							String user = result.get(0).get("user").toString();
//							String password = result.get(0).get("password").toString();
//							System.out.println("jml denda: " + gridPengiriman.getSelectionModel().getSelectedItem().get("jml_denda"));
//							String url = null;
//
//							if (gridPengiriman.getSelectionModel().getSelectedItem().get("jml_denda").toString().equalsIgnoreCase("2")) {
//								url = host + "=rpt_dendaPasokanV2.rptdesign" + "&p_no_pengiriman=" + gridPengiriman.getSelectionModel().getSelectedItem().get("no_pengiriman").toString()
//										+ "&p_id_pltu=" + gridPengiriman.getSelectionModel().getSelectedItem().get("id_pltu").toString() + "&p_user=" + user + "&p_password=" + password + output;
//							} else {
//								url = host + "=rpt_dendaPasokanV1.rptdesign" + "&p_no_pengiriman=" + gridPengiriman.getSelectionModel().getSelectedItem().get("no_pengiriman").toString()
//										+ "&p_id_pltu=" + gridPengiriman.getSelectionModel().getSelectedItem().get("id_pltu").toString() + "&p_user=" + user + "&p_password=" + password + output;
//							}
//							System.out.println("url: " + url);
//							Window win = new Window();
//							win.setUrl(url);
//							win.setSize(cp.getWidth() / 2, cp.getHeight() / 2);
//							win.setModal(true);
//							win.show();
//
//							cp.unmask();
//						}
//
//						@Override
//						public void onFailure(Throwable caught) {
//							// TODO Auto-generated method stub
//							GWT.log(caught.getMessage());
//							cp.unmask();
//						}
//					});
				}
			}
		});
		menu.add(menuItemRincianDenda);

		return menu;
	}

	private void showViewJasper(String kode, String param) {
		mapParam = new FastMap();

		if (kode.equalsIgnoreCase("SIL")) {
			mapParam.put("no_sil", gridPengiriman.getSelectionModel().getSelectedItem().get("no_sil").toString());
			mapParam.put("path", "report/rpt_sil.jasper");
			param = "cetak_sil";
			System.out.println("NO_SIL = " + gridPengiriman.getSelectionModel().getSelectedItem().get("no_sil").toString());
		} else if (kode.equalsIgnoreCase("SIS")) {
			mapParam.put("no_sis", gridPengiriman.getSelectionModel().getSelectedItem().get("no_sis").toString());
			mapParam.put("path", "report/rpt_surat_ijin_sandar.jasper");
			param = "surat_ijin_sandar";
			System.out.println("NO_SIS = " + gridPengiriman.getSelectionModel().getSelectedItem().get("no_sis").toString());
		} else if (kode.equalsIgnoreCase("SIB")) {
			mapParam.put("id_pengiriman", gridPengiriman.getSelectionModel().getSelectedItem().get("id_pengiriman").toString());
			mapParam.put("path", "report/rpt_surat_ijin_bongkar.jasper" + "");
			param = "surat_ijin_bongkar";
			System.out.println("NO_SIB = " + gridPengiriman.getSelectionModel().getSelectedItem().get("no_sib").toString());
		} else if (kode.equalsIgnoreCase("BAST")) {
			mapParam.put("no_bongkar", gridPengiriman.getSelectionModel().getSelectedItem().get("no_bongkar").toString());
			mapParam.put("id_pltu", gridPengiriman.getSelectionModel().getSelectedItem().get("id_pltu").toString());
			mapParam.put("path", "report/rpt_ba_serah_terima_batubara_1.jasper");
			param = "ba_serah_terima_batubara";
			System.out.println("NO_BAST = " + gridPengiriman.getSelectionModel().getSelectedItem().get("no_ba_penerimaan").toString());
		} else if (kode.equalsIgnoreCase("BAPH")) {
			mapParam.put("id_pengiriman", gridPengiriman.getSelectionModel().getSelectedItem().get("id_penerimaan").toString());
			mapParam.put("no_bapnerimaan", gridPengiriman.getSelectionModel().getSelectedItem().get("no_ba_penerimaan").toString());
			mapParam.put("path", "report/rpt_ba_penyesuaian_harga.jasper");
			param = "ba_penyesuaian";
			System.out.println("NO_BAPH = " + gridPengiriman.getSelectionModel().getSelectedItem().get("no_perhitungan_harga").toString());
		}

		cp.mask("load File ....", "x-mask-loading").show();

//		serviceReport.getLaporanPrintService(param, mapParam, new AsyncCallback<List<Map>>() {
//			@Override
//			public void onSuccess(List<Map> result) {
//				WindowReport window = new WindowReport(result.get(0).get("pathResult").toString());
//				window.show();
//				cp.unmask();
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				GWT.log(caught.getMessage());
//				cp.unmask();
//			}
//		});
	}

//	private void showViewBLOB(String kode, String crud, String parameter) {
//
//		Map mapParam = new FastMap();
//
//		if (kode.equalsIgnoreCase("SKAB")) {
//			mapParam.put("id_pengiriman", parameter);
//		} else if (kode.equalsIgnoreCase("NPWP") || kode.equalsIgnoreCase("PKP") || kode.equalsIgnoreCase("NBR")) {
//			mapParam.put("id_pemasok", parameter);
//		} else {
//			mapParam.put("id_pengiriman", parameter);
//		}
//
//		cp.mask("load File ....", "x-mask-loading").show();
//
//		mapParam.put("crud", crud);
//		serviceDao.getUtilDao(crud, mapParam, new AsyncCallback<List<Map>>() {
//			public void onFailure(Throwable caught) {
//				GWT.log(caught.getMessage(), null);
//				cp.unmask();
//			}
//
//			public void onSuccess(List<Map> result) {
//				if (result.get(0).get("message").toString().equals("valid")) {
////					WindowReport window = new WindowReport(result.get(0).get("file_path").toString());
////					window.show();
//					cp.unmask();
//				} else {
//					MessageBox.alert("Information", "Failed, " + result.get(0).get("message").toString(), null);
//					cp.unmask();
//				}
//			}
//		});
//	}

//	private void showViewBirt(final String kode) {
//		Map mapParam = new FastMap();
//		cp.mask("load File ....", "x-mask-loading").show();
//		serviceReport.getBirtPrintService("", mapParam, new AsyncCallback<List<Map>>() {
//
//			@Override
//			public void onSuccess(List<Map> result) {
//
//				String host = result.get(0).get("host").toString();
//				String output = result.get(0).get("output").toString();
//				String user = result.get(0).get("user").toString();
//				String password = result.get(0).get("password").toString();
//
//				String url = "";
//
//				if (kode.equalsIgnoreCase("BAB")) {
//					url = host;
//					url += "=rpt_babongkar.rptdesign";
//					url += "&p_no_ba_bongkar=" + gridPengiriman.getSelectionModel().getSelectedItem().get("no_ba_bongkar").toString();
//					url += "&p_id_pltu=" + gridPengiriman.getSelectionModel().getSelectedItem().get("id_pltu").toString();
//					url += "&p_id_pengiriman=" + gridPengiriman.getSelectionModel().getSelectedItem().get("id_pengiriman").toString();
//					url += "&p_user=" + user;
//					url += "&p_password=" + password;
//					url += output;
//				} else if (kode.equalsIgnoreCase("BAP")) {
//					url = host;
//					url += "=rpt_baPenolakan.rptdesign";
//					url += "&p_id_penerimaan=" + gridPengiriman.getSelectionModel().getSelectedItem().get("id_penerimaan").toString();
//					url += "&p_no_pengiriman=" + gridPengiriman.getSelectionModel().getSelectedItem().get("no_pengiriman").toString();
//					url += "&p_user=" + user;
//					url += "&p_password=" + password;
//					url += output;
//				} else if (kode.equalsIgnoreCase("BAK")) {
//					url = host;
//					url += "=rpt_baketerlambatanV2.rptdesign";
//					url += "&p_no_ba_Keterlambatan=" + gridPengiriman.getSelectionModel().getSelectedItem().get("no_ba_keterlambatan").toString();
//					url += "&p_no_pengiriman=" + gridPengiriman.getSelectionModel().getSelectedItem().get("no_pengiriman").toString();
//					url += "&p_id_pltu=" + gridPengiriman.getSelectionModel().getSelectedItem().get("id_pltu").toString();
//					url += "&p_user=" + user;
//					url += "&p_password=" + password;
//					url += output;
//				}
//
//				System.out.println("url: " + url);
//
//				Window win = new Window();
//				win.setUrl(url);
//				win.setSize(cp.getWidth() / 2, cp.getHeight() / 2);
//				win.setModal(true);
//				win.show();
//
//				cp.unmask();
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				GWT.log(caught.getMessage());
//				cp.unmask();
//			}
//		});
//	}

//	private void showViewBASTTRANS() {
//		cp.mask("Loading Data ..............", "x-mask-loading").show();
//		Map mapParam = new FastMap();
//		serviceReport.getBirtPrintService("", mapParam, new AsyncCallback<List<Map>>() {
//
//			@Override
//			public void onSuccess(List<Map> result) {
//
//				String host = result.get(0).get("host").toString();
//				String output = result.get(0).get("output").toString();
//				String user = result.get(0).get("user").toString();
//				String password = result.get(0).get("password").toString();
//				String url = null;
//
//				url = host + "=rpt_ba_bongkar_unloading.rptdesign" + "&p_no_bongkar=" + gridPengiriman.getSelectionModel().getSelectedItem().get("no_bongkar").toString() + "&p_user=" + user
//						+ "&p_password=" + password + output;
//
//				System.out.println("url: " + url);
//				Window win = new Window();
//				win.setUrl(url);
//				win.setSize(cp.getWidth() / 2, cp.getHeight() / 2);
//				win.setModal(true);
//				win.show();
//
//				cp.unmask();
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				GWT.log(caught.getMessage());
//				cp.unmask();
//			}
//		});
//	}
//	@Override
//	protected void afterRender() {
//		// TODO Auto-generated method stub
//		super.afterRender();
//		loadDataKolom("G_TRACKING_SHIPMENT");
////		gridDinamis.reconfigure(storeDinamis, cm);
//	}
//	@Override
//	protected void assertAfterRender() {
//		// TODO Auto-generated method stub
//		super.assertAfterRender();
////		loadDataKolom("G_TRACKING_SHIPMENT");
//	}
////	on
//	@Override
//	protected void beforeRender() {
//		// TODO Auto-generated method stub
//		super.beforeRender();
////		loadDataKolom("G_TRACKING_SHIPMENT");
//	}
}
