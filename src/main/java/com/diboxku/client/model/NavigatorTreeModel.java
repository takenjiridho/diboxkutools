package com.diboxku.client.model;

import java.util.ArrayList;
import java.util.List;

import com.diboxku.client.view.application.PageApplicationRegister;
import com.diboxku.client.view.application.PagePortalGenerate;
import com.diboxku.client.view.server.PageServerRegister;
import com.diboxku.client.view.user.PageUserApproveGroup;
import com.diboxku.client.view.user.PageUserRegister;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.google.gwt.core.client.GWT;



public class NavigatorTreeModel extends BaseTreeModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<Entry> entries = new ArrayList<Entry>();

	public NavigatorTreeModel()  {
		GWT.log("NavigationTreeModel()", null);
		String[] mdl = Registry.get("module?").toString().split(",");

		for (int i = 0; i < mdl.length; i++) {
			Category getServer = new Category("Server");
			getServer.addEntry("Register", new PageServerRegister());
			add(getServer);
			Category getApplication = new Category("Application");
			getApplication.addEntry("Module Register", new PageApplicationRegister());
			getApplication.addEntry("Portal Generate",new PagePortalGenerate());
//			getServer.addEntry("Page Test",(LayoutContainer) GWT.create(Class.forName("PageServerRegister.class")));
			add(getApplication);
			Category getUser = new Category("User");
			getUser.addEntry("Account Register", new PageUserRegister());
			getUser.addEntry("Approve Group", new PageUserApproveGroup());
//			getServer.addEntry("Page Test",(LayoutContainer) GWT.create(Class.forName("PageServerRegister.class")));
			add(getUser);
		}	
		

		loadEntries(this);
	}

	public Entry findEntry(String name) {
		if (get(name) != null) {
			return (Entry) get(name);
		}
		for (Entry entry : getEntries()) {
			if (name.equals(entry.getId())) {
				return entry;
			}
		}
		return null;
	}

	public List<Entry> getEntries() {
		return entries;

	}

	private void loadEntries(TreeModel model) {
		for (ModelData child : model.getChildren()) {
			if (child instanceof Entry) {
				entries.add((Entry) child);
			} else if (child instanceof Category) {
				loadEntries((Category) child);
			}
		}
	}

}
