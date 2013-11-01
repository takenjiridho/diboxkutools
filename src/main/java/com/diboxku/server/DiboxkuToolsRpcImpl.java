package com.diboxku.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diboxku.client.app.service.DiboxkuToolsRpc;
import com.diboxku.server.service.DinamisService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Repository("dinamisService")
public class DiboxkuToolsRpcImpl  extends RemoteServiceServlet implements DiboxkuToolsRpc{
	@Autowired 
	private DinamisService dinamisService;
	@Override
	public List<Map> getUtilDao(String kode, Map map) {
		// TODO Auto-generated method stub	
		
		if (map.get("func_name").equals("FUNC_GETLOGIN_ADMIN")){
		List<Map> lMapReturn = new ArrayList<Map>();			
		lMapReturn = dinamisService.getUtilDao(kode, map);				
		
		final String[] words = lMapReturn.get(0).get("message").toString().split(";");
		for (int i=0; i < words.length; i++){
			System.out.println("num of str " + i +"= " +words[i]);
		}		
			if (words[0].equals("SUKSES")) {
					RemoteServiceUtil.getThreadLocalRequest().getSession().setAttribute("user_name", words[2]);
					RemoteServiceUtil.getThreadLocalRequest().getSession().setAttribute("user_id", words[1]);
			}			
		}
		return dinamisService.getUtilDao(kode, map);
	}

}
