package com.diboxku.client;



import java.util.List;
import java.util.Map;

import com.diboxku.client.app.service.DiboxkuToolsService;
import com.diboxku.client.app.service.DiboxkuToolsServiceAsync;
import com.diboxku.client.controller.AppController;
import com.diboxku.client.controller.ContentController;
import com.diboxku.client.controller.NavigationController;
import com.diboxku.client.model.Entry;
import com.diboxku.client.model.NavigationModel;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Main implements EntryPoint {
	
	private final DiboxkuToolsServiceAsync service = GWT.create(DiboxkuToolsService.class);

	private Dispatcher dispatcher;
	public static final String MODEL = "model";
	private NavigationModel model;

	private String whoAmI, idPltu, namaUnit, levelUser, ver;

	@Override
	public void onModuleLoad() {

					Map mapParam = new FastMap();    	
				    mapParam.put("code","");
				    mapParam.put("id_user", Registry.get("what_id_user"));
				    mapParam.put("func_name", "FUNC_GETPROFILE");
						    
				    service.getUtilDao("",mapParam, new AsyncCallback<List<Map>>()  {
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							GWT.log(caught.getMessage());
							redirect(GWT.getHostPageBaseURL() + "diboxkutools.html" + diboxkutools.DEBUGDEV);
						}
						@Override
						public void onSuccess(List<Map> result) {
							// TODO Auto-generated method stub
						 if (result.size() > 0) {	
							String version = result.get(0).get("message").toString();
							final String[] words = result.get(0).get("message").toString().split(";");
							for (int i=0; i < words.length; i++){
								GWT.log("num of str " + i +"= " +words[i],null);
							}
							GWT.log("success : " + version);		
							//version = result.get(0).get("message").toString();
							Registry.register("who?", words[1]);
							Registry.register("module?",words[2]);
							Registry.register("userLevel", words[3]);														
							Registry.register("versi", words[4]);

							model = new NavigationModel();

							Registry.register(MODEL, model);

							dispatcher = Dispatcher.get();
							dispatcher.addController(new AppController());
							dispatcher.addController(new NavigationController());
							dispatcher.addController(new ContentController());
							dispatcher.dispatch(AppEvents.Init);
							GXT.hideLoadingPanel("loading");
						    
						} else {
								redirect(GWT.getHostPageBaseURL() + "diboxkutools.html" + diboxkutools.DEBUGDEV);
						}
					}

				});				
	}

	public static void showPage(Entry entry) {
		GWT.log("showPage() ", null);
		AppEvent appEvent = new AppEvent(AppEvents.ShowPage, entry);
		appEvent.setHistoryEvent(false);
		appEvent.setToken(entry.getId());
		Dispatcher.forwardEvent(appEvent);
	}

	native void redirect(String url)
	/*-{
		$wnd.location.replace(url);
	}-*/;
}
