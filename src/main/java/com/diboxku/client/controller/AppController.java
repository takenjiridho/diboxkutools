package com.diboxku.client.controller;


import com.diboxku.client.AppEvents;
import com.diboxku.client.Main;
import com.diboxku.client.model.NavigationModel;
import com.diboxku.client.view.AppView;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.Status;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;

public class AppController extends Controller {
	 private AppView appView;
	  private static final String SERVER_ERROR = "An error occurred while "
		+ "attempting to contact the server. Please check your network "
		+ "connection and try again.";

//	  protected Button reset;
//	  protected Button login;
	  protected Status status;
	  private NavigationModel model;
	  
	  public AppController() {
		  GWT.log("AppController", null);
		   registerEventTypes(AppEvents.Init);
//		   registerEventTypes(AppEvents.Login);
		   registerEventTypes(AppEvents.Error);
		   registerEventTypes(AppEvents.NavApp);
		   registerEventTypes(AppEvents.ShowPage);
	  }

	@Override
	public void handleEvent(AppEvent event) {
	    EventType type = event.getType();
	    if (type == AppEvents.Init) {
	      onInit(event);
//	    } else if (type == AppEvents.Login) {
//	      onLogin(event);
	    } else if (type == AppEvents.Error) {
	      onError(event);
	    }
	}
	  public void initialize() {
		    appView = new AppView(this);
		  }

		  protected void onError(AppEvent ae) {
		    System.out.println("error: " + ae.<Object>getData());
		  }

		  private void onInit(AppEvent event) {
		    forwardToView(appView, event);
		    GWT.log("load onInit", null);
		    
		    Dispatcher.forwardEvent(AppEvents.NavApp,null);
		    
		    model = (NavigationModel) Registry.get(Main.MODEL);		   
		    //load page awal
		    
		    Main.showPage(model.findEntry("overview"));
		    
//		    Main.showPage(model.findEntry("dashboard"));
		    Viewport v = Registry.get(AppView.VIEWPORT);
	        v.layout(true);
		  }

//		  private void onLogin(AppEvent event) {
//		    forwardToView(appView, event);
//			GWT.log("load onLogin", null);
//		  }

}
