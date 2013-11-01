package com.diboxku.client;


import com.diboxku.client.model.NavigationModel;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;


public class Layout extends LayoutContainer {

	  public static final String CENTER_PANEL = "centerPanel";
	  public static final String WEST_PANEL = "westPanel";
	  public static final String NORTH_PANEL = "northPanel";
	  public static final String VIEWPORT = "viewPort";

	  private Viewport viewport;
	  private ContentPanel centerPanel;
	  private HtmlContainer northPanel;
	  private ContentPanel westPanel;
	  private NavigationModel model;

	public Layout() {
//		super(controller);
		// TODO Auto-generated constructor stub
	      initUI();
//	      new NavigationView();
	}

//	  @Override
//	  protected void handleEvent(AppEvent event) {
////		    if (event.getType() == AppEvents.Init) {
//		      initUI();
////		    }
//		  }

//	  protected void initialize() {
////		    LoginDialog dialog = new LoginDialog();
//		    dialog.setClosable(false);
//		    dialog.addListener(Events.Hide, new Listener<WindowEvent>() {
//		      public void handleEvent(WindowEvent be) {
////		        Dispatcher.forwardEvent(AppEvents.Init);
//		      }
//		    });
//		    dialog.show();
//		  }
	  
	  private void initUI(){
//			model = new NavigationModel();
		  	
		    viewport = new Viewport();
		    viewport.setLayout(new BorderLayout());
		    Registry.register(VIEWPORT, viewport);
		    
		    createNorth();
		    createWest();
		    createCenter();
		    
		    viewport.syncSize();
		    RootPanel.get().add(viewport);
	  }
	  
	  private void createCenter() {
		    centerPanel = new ContentPanel();
		    centerPanel.setBorders(false);
		    centerPanel.setHeaderVisible(false);
		    centerPanel.setLayout(new FitLayout());

		    BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		    data.setMargins(new Margins(5, 5, 5, 0));
		    viewport.add(centerPanel, data);
		    Registry.register(CENTER_PANEL, centerPanel);
		  }

		  private void createWest() {
			
		    BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 220, 150, 320);
		    data.setMargins(new Margins(5, 5, 5, 5));
		    data.setCollapsible(true);
		    westPanel = new ContentPanel();

		    ToolBar toolBar = new ToolBar();
		    westPanel.setTopComponent(toolBar);
		    
		    viewport.add(westPanel, data);
		    Registry.register(WEST_PANEL, westPanel);
		  }

		  private void createNorth() {
		    StringBuffer sb = new StringBuffer();
		    sb.append("<div id='demo-theme'></div><div id='demo-title'>Dashboard Management System</div>");

		    northPanel = new HtmlContainer(sb.toString());
		    northPanel.setEnabled(false);
		    northPanel.setId("demo-header");
		    northPanel.addStyleName("x-small-editor");
		    
	    
		    Hyperlink lg = new Hyperlink("Logout","");
		    lg.setTitle("Logout");
		    northPanel.add(lg,"#demo-theme");
		    
		    BorderLayoutData data = new BorderLayoutData(LayoutRegion.NORTH, 33);
		    data.setMargins(new Margins());
		    viewport.add(northPanel, data);
		    Registry.register(NORTH_PANEL, northPanel);
		  }


}
