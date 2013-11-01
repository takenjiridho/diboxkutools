package com.diboxku.client.view;


import java.util.List;
import java.util.Map;

import com.diboxku.client.AppEvents;
import com.diboxku.client.diboxkutools;
import com.diboxku.client.app.service.DiboxkuToolsRpc;
import com.diboxku.client.app.service.DiboxkuToolsService;
import com.diboxku.client.app.service.DiboxkuToolsServiceAsync;
import com.diboxku.client.model.NavigationModel;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;


public class AppView extends View {

	private final DiboxkuToolsServiceAsync service = GWT.create(DiboxkuToolsService.class);
	
	public static final String CENTER_PANEL = "centerPanel";
	public static final String WEST_PANEL = "westPanel";
	public static final String NORTH_PANEL = "northPanel";
	public static final String VIEWPORT = "viewPort";
	private Viewport viewport;
	private ContentPanel centerPanel;
	private HtmlContainer northPanel;
	private ContentPanel westPanel;
	private NavigationModel model;
	
	public AppView(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleEvent(AppEvent event) {
		if (event.getType() == AppEvents.Init) {
			initUI();
		}
	}

	private void initUI() {
		model = new NavigationModel();

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

		viewport.add(westPanel, data);
		Registry.register(WEST_PANEL, westPanel);
	}

	private void createNorth() {
		StringBuffer sb = new StringBuffer();

		sb.append("<div id='demo-theme' style='color:white;'></div><div id='demo-title' style='color:white;'>Welcome " + Registry.get("who?") + " - ("+Registry.get("module?")+")</div>");
		northPanel = new HtmlContainer(sb.toString());
		// northPanel.setEnableState(false);
		northPanel.setId("demo-header");
		northPanel.addStyleName("x-small-editor");

//		final Button notif = new Button();
//		notif.setIcon(IconHelper.createStyle("icon-world"));
//		notif.addSelectionListener(new SelectionListener<ButtonEvent>() {
//
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				// TODO Auto-generated method stub
//				NotifDialog dialog = new NotifDialog(centerPanel.getWidth() / 2, centerPanel.getHeight() / 2, notif.getPosition(true).x + (centerPanel.getWidth() / 2 + westPanel.getWidth()), notif
//						.getPosition(true).y + 25);
//				dialog.show();
//			}
//		});

		Button logout = new Button("Logout");
		logout.setIcon(IconHelper.createStyle("icon-logout"));

		logout.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("Logout", "Service Logout", new Listener<MessageBoxEvent>() {
					public void handleEvent(MessageBoxEvent ce) {

						Button btn = ce.getButtonClicked();//

						GWT.log(btn.getText(), null);
						if (btn.getText().equals("Yes")) {
							Map mapParam = new FastMap();
							mapParam.put("id_user",Registry.get("what_id_user"));
							mapParam.put("code", "");
							mapParam.put("func_name", "FUNC_GETLOGOUT");	
							
							service.getUtilDao("",mapParam, new AsyncCallback<List<Map>>()  {
								@Override
								public void onFailure(Throwable caught) {
									GWT.log("error", null);
								}
								@Override
								public void onSuccess(List<Map> result) {
									// TODO Auto-generated method stub
									redirect(GWT.getHostPageBaseURL() + "diboxkutools.html" + diboxkutools.DEBUGDEV);
									return;
								}
							});
						} else {
							return;
						}
					}
//
				});
			}
		});

		ToolBar toolBar = new ToolBar();
		toolBar.setStyleName("#demo-theme");
//		toolBar.add(notif);
		toolBar.add(logout);

		northPanel.add(toolBar, "#demo-theme");

		BorderLayoutData data = new BorderLayoutData(LayoutRegion.NORTH, 33);
		data.setMargins(new Margins());
		viewport.add(northPanel, data);
		Registry.register(NORTH_PANEL, northPanel);
	}

	native void redirect(String url)
	/*-{
		$wnd.location.replace(url);
	}-*/;

}
