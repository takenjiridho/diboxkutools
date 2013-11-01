package com.diboxku.client.controller;


import com.diboxku.client.AppEvents;
import com.diboxku.client.view.NavigationView;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.google.gwt.core.client.GWT;

public class NavigationController extends Controller {

	private NavigationView view;
	public NavigationController() {
		   registerEventTypes(AppEvents.Init);
		   registerEventTypes(AppEvents.Error);
		   registerEventTypes(AppEvents.NavApp);
		   registerEventTypes(AppEvents.ShowPage);

	}

	public void initialize() {
	    view = new NavigationView(this);
	    GWT.log("NavigationController() initialize()", null);
}

	@Override
	public void handleEvent(AppEvent event) {
	    EventType t = event.getType();	
	    if (t == AppEvents.NavApp || t == AppEvents.Init || t == AppEvents.HidePage || t == AppEvents.TabChange) {
//	    if (t == AppEvents.Init) {// || t == AppEvents.HidePage || t == AppEvents.TabChange) {   	
	      forwardToView(view, event);
	    }

	}

	
}
