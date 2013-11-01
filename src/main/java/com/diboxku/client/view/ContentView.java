package com.diboxku.client.view;


import com.diboxku.client.AppEvents;
import com.diboxku.client.Layout;
import com.diboxku.client.model.Entry;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;

public class ContentView extends View {

	  private TabPanel tabPanel;

	  public ContentView(Controller controller) {
	    super(controller);
	  }

	  public void initialize() {
	    tabPanel = new TabPanel();
	    tabPanel.setCloseContextMenu(true);
	    tabPanel.setBorderStyle(false);
	    tabPanel.setBodyBorder(false);
	    tabPanel.setTabScroll(true);
	    tabPanel.setAnimScroll(true);
	    tabPanel.setDeferredRender(false);
	    tabPanel.addListener(Events.Remove, new Listener<TabPanelEvent>() {

	      public void handleEvent(TabPanelEvent be) {
	        TabItem item = be.getItem();
	        Entry entry = (Entry) item.getData("entry");
	        Dispatcher.forwardEvent(AppEvents.HidePage, entry);
	      }

	    });
	    tabPanel.addListener(Events.Select, new Listener<TabPanelEvent>() {
	      public void handleEvent(TabPanelEvent be) {
	        String token = History.getToken();
	        Entry entry = (Entry) be.getItem().getData("entry");
	        if (token != null && (!token.equals(entry.getId()))) {
	          History.newItem(entry.getId(), false);
	        }
	        Dispatcher.forwardEvent(AppEvents.TabChange, entry);
	      }
	    });
	    ContentPanel center = (ContentPanel) Registry.get(Layout.CENTER_PANEL);
	    center.add(tabPanel);
	  }

	  public void onShowPage(Entry entry) {
		GWT.log("onShowPage()", null);
		Page page = entry.get("page");
	    if (page == null) {
	      page = new Page(entry);
	      entry.set("page", page);
	    	}

	    TabItem item = tabPanel.findItem("page__"+page.getId(),false);
	    if (item == null) {
	      item = new TabItem();	      
	      item.setData("entry", entry);
	      item.setClosable(entry.isClosable());
	      item.setId("page__"+page.getId());
	      item.setText(entry.getName());
	      item.setLayout(new FitLayout());
	      item.add(page);
	      tabPanel.add(item);
	    }

	    if (item != tabPanel.getSelectedItem()) {
	      tabPanel.setSelection(item);
	    }
	  }

	  protected void handleEvent(AppEvent event) {
		
	    EventType type = event.getType();
	    if (type == AppEvents.ShowPage) {
	      Entry entry = event.getData();
	      GWT.log("onShowPage() handleEvent() " + entry, null);
	      onShowPage(entry);
	    }
	  }

}
