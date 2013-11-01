package com.diboxku.client.view;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.diboxku.client.AppEvents;
import com.diboxku.client.Main;
import com.diboxku.client.app.service.DiboxkuToolsRpc;
import com.diboxku.client.app.service.DiboxkuToolsService;
import com.diboxku.client.app.service.DiboxkuToolsServiceAsync;
import com.diboxku.client.model.Category;
import com.diboxku.client.model.Entry;
import com.diboxku.client.model.NavigationModel;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionService;
import com.extjs.gxt.ui.client.event.SourceSelectionChangedListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabPanel.TabPosition;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;


public class NavigationView extends View{
	private final DiboxkuToolsServiceAsync service = GWT.create(DiboxkuToolsService.class);

	  private NavigationModel model;
	  private ContentPanel westPanel, centerPanel;
	  private ToolBar toolBar;
	  private TabPanel tabPanel;
	  private VerticalPanel Panel;
	  private TabItem  treeItem ,listItem;
	  private TreePanel<ModelData> tree;
		public String u;
		private String n;
		private String upj;
		private String npj;
		private Timer t;
	  
//	  private DataList dataList;
	  private TreeStore<ModelData> treeStore;
	  private StoreFilterField<ModelData> filter;

	public NavigationView(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
//	protected void handleEvent(AppEvent event) {
		// TODO Auto-generated method stub
		
//	}
	  protected void initialize() {
		  GWT.log("NavigationView() initialize()", null);  
//		  model = Registry.get(Main.MODEL);
//		
	    SelectionService.get().addListener(new SelectionChangedListener<TreeModel>() {
	      public void selectionChanged(SelectionChangedEvent<TreeModel> event) {
	        List<TreeModel> sel = event.getSelection();
	        GWT.log("tree nye di NavigationView: " + sel.get(0).getPropertyNames(), null);
//	        centerPanel.el().mask("Loading Data...");
	        if (sel.size() > 0) {
	        	
	          TreeModel m = (TreeModel) event.getSelection().get(0);
	          if (m != null && m instanceof Entry) {
	        	  Main.showPage((Entry) m);
//	        	  centerPanel.el().unmask();

	          }
	        }
	      }
	    });

	    


	    westPanel = (ContentPanel) Registry.get(AppView.WEST_PANEL);
	    westPanel.setHeading(Registry.get("versi").toString());
	    westPanel.setLayout(new FitLayout());
//	    westPanel.setExpanded(false);
	    westPanel.add(createPanel());


	    createTreeContent();
	    westPanel.syncSize();
	  }
	
	
	private VerticalPanel createPanel(){
		Panel = new VerticalPanel();
		return Panel;
	}
	private TabPanel createTabPanel() {
	    tabPanel = new TabPanel();
	    tabPanel.setMinTabWidth(70);
	    tabPanel.setBorderStyle(false);
	    tabPanel.setBodyBorder(false);
	    tabPanel.setTabPosition(TabPosition.BOTTOM);

	    treeItem = new TabItem();
	    treeItem.setText("Tree");
	    tabPanel.add(treeItem);

//	    listItem = new TabItem();
//	    listItem.setText("List");
//	    tabPanel.add(listItem);

	    return tabPanel;
	  }

	  private void createTreeContent() {
		model =  new NavigationModel(); // (NavigationModel) Registry.get(Main.MODEL); 
	  	GWT.log("NavigationView() createTreeContent() Begin", null); 
	    TreeLoader<ModelData> loader = new BaseTreeLoader<ModelData>(new TreeModelReader<List<ModelData>>()) {
	      @Override
	      public boolean hasChildren(ModelData parent) {
//	  	    GWT.log("NavigationView() TreeLoader()", null);
	        return parent instanceof Category;
	      }
	      
	    };
	    GWT.log("NavigationView() createTreeContent() TreeStore", null);
	    treeStore = new TreeStore<ModelData>(loader);

	    tree = new TreePanel<ModelData>(treeStore);

//	    tree.getStyle().setLeafIconStyle("icon-list");
	    tree.getStyle().setLeafIcon(IconHelper.createStyle("icon-list"));
	    tree.getStyle().setNodeOpenIcon(IconHelper.createStyle("icon-expand-all"));
	    tree.getStyle().setNodeCloseIcon(IconHelper.createStyle("icon-collapse-all"));
	    tree.setAutoLoad(true);
	    tree.setDisplayProperty("name");

	    SelectionService.get().addListener(new SourceSelectionChangedListener(tree.getSelectionModel()));
	    SelectionService.get().register(tree.getSelectionModel());

//	    filter.bind(treeStore);
	    loader.load(model);

//	    treeItem.setBorders(false);
//	    treeItem.setScrollMode(Scroll.AUTO);
//	    treeItem.add(tree);
	    
	    Panel.setBorders(false);
	    Panel.setScrollMode(Scroll.AUTO);
	    Panel.add(tree);

	    	    
	    GWT.log("NavigationView() createTreeContent()", null);
	  }

	  
	
//	private void createListContent() {
//		GWT.log("NavigationView() createListContent()", null);
//	    listItem.setLayout(new FitLayout());
//	    listItem.setBorders(false);
//
//	    dataList = new DataList();
//	    dataList.setScrollMode(Scroll.AUTO);
//	    dataList.setBorders(false);
//	    dataList.setFlatStyle(true);
//
//	    ListStore<Entry> store = new ListStore<Entry>();
//	    store.setStoreSorter(new StoreSorter(new Comparator<Entry>() {
//
//	      public int compare(Entry e1, Entry e2) {
//	        return e1.getName().compareTo(e2.getName());
//	      }
//
//	    }));
//	    store.add(model.getEntries());
//
//	    DataListBinder binder = new DataListBinder(dataList, store);
//	    binder.setDisplayProperty("name");
//	    binder.addSelectionChangedListener(new SelectionChangedListener<Entry>() {
//	      public void selectionChanged(SelectionChangedEvent<Entry> se) {
//	        Entry e = se.getSelection().get(0);
//	        if (e != null && e instanceof Entry) {
//	          MainLayout.showPage(e);
//	        }
//	      }
//	    });
//	    binder.init();
//	    filter.bind((Store) store);
//	    listItem.add(dataList);
//	  }

	  
	protected void handleEvent(AppEvent event) {
//	    tree.expandAll(); 
	    EventType type = event.getType();
	    if (type == AppEvents.HidePage) {
	      tree.getSelectionModel().setSelection(new ArrayList<ModelData>());
	    } else if (type == AppEvents.TabChange) {
	      if (((Entry) event.getData()).getName() == "Overview") {
	        tree.getSelectionModel().setSelection(new ArrayList<ModelData>());
//	        tree.expandAll();   
	      } else {  
	        tree.getSelectionModel().setSelection((List)Arrays.asList((Entry)event.getData()));
	      }
	    }
	  }

}
