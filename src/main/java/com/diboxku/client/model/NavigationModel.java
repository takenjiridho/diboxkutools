package com.diboxku.client.model;


import com.google.gwt.core.client.GWT;

public class NavigationModel extends NavigatorTreeModel{ 
	public NavigationModel() {
		GWT.log("Load NavigationModel()",null);		
		set("overview", new Entry("Overview", new PageOverview(), true, false));		
	  }
}	