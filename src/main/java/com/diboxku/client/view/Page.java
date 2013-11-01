package com.diboxku.client.view;




import com.diboxku.client.model.Entry;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;


public class Page extends LayoutContainer {

	  protected Entry entry;

	  public LayoutContainer getContent() {
	    return entry.getExample();
	  }

	  public Page(final Entry entry) {
	    this.entry = entry;

//	    setTabPosition(TabPosition.BOTTOM);
//	    setBorderStyle(false);
//	    setBodyBorder(false);
	    setLayout(new FitLayout());

	    addListener(Events.Adopt, new Listener<ComponentEvent>() {
	      public void handleEvent(ComponentEvent be) {
	        if(getParent() != null && getParent() instanceof TabItem) {
	          TabItem t = (TabItem) getParent();
	          t.setHideMode(entry.getHideMode());
	        }
	      }
	    });
	   
//	    if (entry.getName() == "Overview") {
//		    TabItem d = new TabItem();
//		    d.setScrollMode(Scroll.AUTO);
//		    if (entry.isFill()) {
//		      d.setLayout(new FitLayout());
//		      d.setScrollMode(Scroll.NONE);
//		    }
//		    setPlain(true);		   
////		    d.setText("");
//		    d.add(entry.getExample());
//		    add(d);
//	    	
//	    }else{    
//	    TabItem demo = new TabItem();
//  	demo.setScrollMode(Scroll.AUTO);	   
////	    if (entry.isFill()) {
////	      demo.setLayout(new FitLayout());
//	      demo.setText("Form Entry");
////	      demo.setScrollMode(Scroll.NONE);
//		  demo.add(entry.getExample());
//		  add(demo);
//
////	    }
//	    
////	    demo.setHideMode(entry.getHideMode());
////	    if (entry.getName() == "Overview") {
//	//	    demo.setText("Demo");
////		    demo.setText(entry.getName());
////	    	demo.setLayout(new FitLayout());
////
////	    	demo.setText("Form Entry");
////		    demo.add(entry.getExample());
////		    add(demo);
////	    }else{
////		    demo.setText("Demo");
////		    demo.setText(entry.getName());
////		    demo.add(entry.getExample());
////		    add(demo);
//
////	    }
//	    
//	    if (entry.isClosable()) {
//	      TabItem source = new TabItem();
//	      source.setText("Monitoring");
//	      source.setUrl(entry.getSourceUrl());
//	      add(source);
//	    }
//	  }
//	    TabItem demo = new TabItem();
//	    demo.setScrollMode(Scroll.AUTO);
//	      demo.setLayout(new FitLayout());
////	    if (entry.isFill()) {
//
//////	      demo.setScrollMode(Scroll.NONE);
////	    }
//	    
//	    demo.setHideMode(entry.getHideMode());
//
//	    demo.setText("Entry");
//	    demo.add(entry.getExample());
//	    add(demo);
	    add(entry.getExample());
	    
//	    if (entry.isClosable()) {
//	      TabItem source = new TabItem();
//	      source.setText("Monitoring");
//	      source.setUrl(entry.getSourceUrl());
//	      add(source);
//	    }  
	}    
}
