package com.diboxku.client;


import java.util.List;
import java.util.Map;

import com.diboxku.client.app.service.DiboxkuToolsRpc;
import com.diboxku.client.app.service.DiboxkuToolsRpcAsync;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Status;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Login extends Dialog{
	  private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	  private final DiboxkuToolsRpcAsync service = GWT.create(DiboxkuToolsRpc.class);
	  protected TextField<String> userName;
	  protected TextField<String> password;
	  protected Button reset;
	  protected Button login;
	  protected Status status;

	  public Login(String V) {
	    FormLayout layout = new FormLayout();	    
	    layout.setLabelWidth(90);
	    layout.setDefaultWidth(155);
	    setLayout(layout);
	    
	    setDraggable(false);
	    setClosable(false);
	    setButtonAlign(HorizontalAlignment.LEFT);
	    setButtons("");
	    setHeading("Login  ["+V+"]");
	    setModal(true);
	    setBodyBorder(true);
	    setBodyStyle("padding: 8px;background: none");
	    setWidth(300);
	    setSize(300,150);
	    setResizable(false);
	    

	    KeyListener keyListener = new KeyListener() {
		      public void componentKeyUp(ComponentEvent event) {
		    	  if (event.getKeyCode() == 13 && login.isEnabled()) {
						onSubmit();
					}
					validate();
		      }
	    };

	    userName = new TextField<String>();
	    userName.setMinLength(3);
	    userName.setName("user");
	    userName.setFieldLabel("Username");
	    userName.addKeyListener(keyListener);
	    add(userName);

	    password = new TextField<String>();
	    password.setMinLength(4);
	    password.setPassword(true);
	    password.setName("password");
	    password.setFieldLabel("Password");
	    password.addKeyListener(keyListener);
	    add(password);
	    setFocusWidget(userName);
	  }

	  @Override
	  protected void createButtons() {
	    super.createButtons();
	    status = new Status();
	    status.setBusy("please wait...");
	    status.hide();
	    status.setAutoWidth(true);
	    getButtonBar().add(status);
	    
	    getButtonBar().add(new FillToolItem());
	    
	    reset = new Button("Reset");
	    reset.addSelectionListener(new SelectionListener<ButtonEvent>() {
		      public void componentSelected(ButtonEvent ce) {
		        userName.reset();
		        password.reset();
		        validate();
		        userName.focus();
		      }
	    });

	    login = new Button("Login");
	    login.disable();
	    login.addSelectionListener(new SelectionListener<ButtonEvent>() {
	      public void componentSelected(ButtonEvent ce) {
	        onSubmit();
	      }
	    });
	    addButton(reset);
	    addButton(login);	    
	  }

	  protected void onSubmit() {
		GWT.log("load onSubmit", null);
	    status.show();
	    getButtonBar().disable();
	    
	    Timer t = new Timer() {
	      @Override
	      public void run() {
	    	  validasiLogins();
	      }

	    };
	    t.schedule(2000);
	  }

	  protected boolean hasValue(TextField<String> field) {
	    return field.getValue() != null && field.getValue().length() > 0;
	  }

	  protected void validate() {
	    login.setEnabled(hasValue(userName) && hasValue(password)
	        && password.getValue().length() > 3);
	  }
	  private void getVersion(){
		  
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
					String getVersion = "1.0.0";
					GWT.log("success : " + version);					  
				}

			});
	  }
	  private void validasiLogins(){
			String userField = userName.getValue().toUpperCase();
			String passField = password.getValue();
			Map mapParam = new FastMap();
			mapParam.put("login_name", userName.getValue());
			mapParam.put("password", password.getValue());
			mapParam.put("code","");
		    mapParam.put("func_name", "FUNC_GETLOGIN_ADMIN");
						
			service.getUtilDao("",mapParam, new AsyncCallback<List<Map>>()  {
			      		@Override
						public void onFailure(Throwable caught) {
							MessageBox.alert("Error", SERVER_ERROR, null);
						}
						@Override
						public void onSuccess(List<Map> result) {
							final String[] words = result.get(0).get("message").toString().split(";");
							for (int i=0; i < words.length; i++){
								GWT.log("num of str " + i +"= " +words[i],null);
							} 	
							Registry.unregister("page");
							GWT.log("hasil " + result, null);
							if (words[0].equals("SUKSES")){
//								Registry.register("who_is_login",words[2].toString());
//								Registry.register("what_id_user",words[1].toString());
								Login.this.hide();
				    		    GXT.hideLoadingPanel("loading");
								redirect(GWT.getHostPageBaseURL()+ "Main.html"+diboxkutools.DEBUGDEV);
								return;
							}else{								
									MessageBox.alert("Login Information", "Data Login Salah Press OK", 
										  new Listener<MessageBoxEvent>() {  
									       public void handleEvent(MessageBoxEvent ce) {  
									    	   			getButtonBar().enable();
												    status.hide();
												    GXT.hideLoadingPanel("loading");
									       	}										       
									 });  
							}						
						}						
					});
	  }
		
	  native void redirect(String url)
		/*-{
			$wnd.location.replace(url);
		}-*/;

}