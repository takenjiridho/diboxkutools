package com.diboxku.server.service;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommonModule {
	private static final String WEBINF = "WEB-INF";
	public static List<Map> convertResultsetToListLower(ResultSet rs) throws SQLException{
    	List<Map> lst = new ArrayList<Map>();
    	ResultSetMetaData rsmd = rs.getMetaData();
	    int colCount = rsmd.getColumnCount();
	
	    while (rs.next()) {
	        HashMap map = new HashMap();
	        for (int i = 1; i <= colCount; i++) {
	        	try{	        		
	        		map.put(rsmd.getColumnName(i).toLowerCase(), rs.getObject(i).toString());
	        	}catch (Exception e) {
	        		map.put(rsmd.getColumnName(i).toLowerCase(), "");
				}	            
	        }
	        lst.add(map);
	    }
	    return lst;
    }
	 
	    
	 public static String getWebInfPath(){
	   
	      String filePath = "";
	   
	      URL url = CommonModule.class.getResource("CommonModule.class");
	      String className = url.getFile();
	   
	      filePath = className.substring(0,className.indexOf(WEBINF) ).replace("%20"," ") ;
	      return filePath;
	    }	
}
