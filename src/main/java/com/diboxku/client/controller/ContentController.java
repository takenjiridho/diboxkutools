package com.diboxku.client.controller;


import com.diboxku.client.AppEvents;
import com.diboxku.client.view.ContentView;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;


public class ContentController extends Controller {

	  private ContentView view;

	  public ContentController() {
	    registerEventTypes(AppEvents.Init, AppEvents.ShowPage);
//	    registerEventTypes(AppEvents.Logout);
	  }

	  public void initialize() {
	    view = new ContentView(this);
	  }

	  public void handleEvent(AppEvent event) {
	    forwardToView(view, event);
	  }
}