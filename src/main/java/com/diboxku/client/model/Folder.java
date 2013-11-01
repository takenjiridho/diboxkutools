package com.diboxku.client.model;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.google.gwt.core.client.GWT;

public class Folder extends BaseTreeModel implements Serializable {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int ID = 0;
	  
	  public Folder() {
	    set("id", ID++);
	  }

	  public Folder(String name) {
	    set("id", ID++);
	    set("name", name);
	  }

	  public Folder(String name, BaseTreeModel[] children) {
		  
	    this(name);
	    GWT.log(children.length + "test", null);
	    for (int i = 0; i < children.length; i++) {
	      add(children[i]);
	    }
	    
	  }

	  public Integer getId() {
	    return (Integer) get("id");
	  }

	  public String getName() {
	    return (String) get("name");
	  }

	  public String toString() {
	    return getName();
	  }

}
