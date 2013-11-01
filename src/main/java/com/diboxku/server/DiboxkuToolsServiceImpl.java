package com.diboxku.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.diboxku.client.app.service.DiboxkuToolsService;
import com.diboxku.server.service.DinamisService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Repository("diboxkuService")
public class DiboxkuToolsServiceImpl extends RemoteServiceServlet implements DiboxkuToolsService{
	@Autowired 
	private DinamisService dinamisService;
	@Override
	public List<Map> getUtilDao(String kode, Map map) {
		// TODO Auto-generated method stub
		
		if (map.get("func_name").equals("FUNC_GETPROFILE")){	
			HashMap mp = new HashMap();			
			mp.put("id_user", RemoteServiceUtil.getThreadLocalRequest().getSession().getAttribute("user_id"));
			mp.put("func_name",map.get("func_name"));
			mp.put("code","");
			return dinamisService.getUtilDao(kode, mp);	
		}else if (map.get("func_name").equals("FUNC_GETLOGOUT")) {			
			RemoteServiceUtil.getThreadLocalRequest().getSession().removeAttribute("user_id");
			return dinamisService.getUtilDao(kode, map);
		}else{
			return  dinamisService.getUtilDao(kode, map);	
		}		
	}


}
