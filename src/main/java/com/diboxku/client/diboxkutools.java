package com.diboxku.client;

import java.util.List;
import java.util.Map;

import com.diboxku.client.app.service.DiboxkuToolsRpc;
import com.diboxku.client.app.service.DiboxkuToolsRpcAsync;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class diboxkutools implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
  private final DiboxkuToolsRpcAsync service = GWT.create(DiboxkuToolsRpc.class);
	public static final Boolean ISDEBUG = false; //Silahkan Untuk development mode true , false untuk deploy
	public final static String DEBUGDEV = (diboxkutools.ISDEBUG.equals(true)) ? "?gwt.codesvr=127.0.0.1:9997" : "";
	public final static String VERSION = "BETA"; //silahkan diganti untuk STABLE untuk production sedangkan untuk QA default nya BETA

//  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  
	    Map mapParam = new FastMap();    	
	    mapParam.put("code","");
	    mapParam.put("func_name", "FUNC_GETVERSION");
			    
	    service.getUtilDao("",mapParam, new AsyncCallback<List<Map>>()  {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				GWT.log(caught.getMessage());
			}
			@Override
			public void onSuccess(List<Map> result) {
				// TODO Auto-generated method stub
				String version = result.get(0).get("message").toString();							  
				Login l = new Login(version);					 
					 
				  Window window=new Window();
				  window.setSize(320,170);;
				  window.setStyleAttribute("backgroundColor", "white");
				  window.setHeaderVisible(false); 
				  window.setBorders(false);
				  window.setFrame(false);
				  window.setShadow(false);
				  window.setBodyBorder(false);		  
				  window.setLayout(new CenterLayout());
				  window.setPlain(true); 		  
				  window.add(l);
				  window.setFocusWidget(l);
			    
				RootPanel.get().add(window);
				window.show();
				
				
			}

		});
	    	 	
  }
}
