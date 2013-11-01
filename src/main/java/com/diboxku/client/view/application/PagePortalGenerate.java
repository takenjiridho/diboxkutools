package com.diboxku.client.view.application;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

public class PagePortalGenerate extends LayoutContainer {
	  @Override  
	  protected void onRender(Element parent, int index) {  
	    super.onRender(parent, index);  
	    setLayout(new FitLayout());  
	  
	    ContentPanel panel = new ContentPanel();  
	    panel.setBodyStyle("padding: 6px");  
	    panel.setFrame(true);  
	    panel.setHeaderVisible(false);
	    panel.addText("<b>UNDER CONSTRUCTION");
	    panel.setWidth(200);  
	  
	    add(panel);  
	  }  
}
