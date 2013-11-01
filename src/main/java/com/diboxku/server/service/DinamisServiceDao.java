package com.diboxku.server.service;


import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import org.springframework.stereotype.Service;	
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class DinamisServiceDao implements DinamisService{
	@Autowired	private SessionFactory sessionFactory;
	@Override
	public List<Map> getUtilDao(String kode, Map map) {
		// TODO Auto-generated method stub
		List<Map> lMap = new ArrayList<Map>();
		List<Map> lMapa = new ArrayList<Map>();
		Session session = sessionFactory.getCurrentSession();
        Connection con = session.connection();
        Connection cona = session.connection(); 
        try{
        	String sql = null;
            CallableStatement call;
            CallableStatement calla;
            System.out.println("FUNC NAME : " + map.get("func_name").toString());
            System.out.println("CODE NAME : " + map.get("code").toString());
            
        	sql = "{? = call FUNC_GETUTILDAO(?)}";
            calla = cona.prepareCall(sql);
            calla.registerOutParameter(1, OracleTypes.CURSOR);
            calla.setString(2, map.get("func_name").toString());
            calla.execute();

            ResultSet rset = (ResultSet) calla.getObject(1);            
            
            while (rset.next()){
            //	System.out.println("crud for "  + rset.getString("PROCEDURE_NAME").substring(0,3).toString());
            	
             if(rset.getString("TYPE_DATA").equals("STRING")){	
            	System.out.println(rset.getString("PROCEDURE_NAME") + " param : " + rset.getString("MAPPING_NAME") + " 	value " +  map.get(rset.getString("MAPPING_NAME").toString()));
            	sql = rset.getString("PROCEDURE_NAME");
                call = con.prepareCall(sql);
	            call.setString(1, (String) map.get(rset.getString("MAPPING_NAME")));
                call.execute();	 
             }else if (rset.getString("TYPE_DATA").equals("NUMBER")){
            	 System.out.println(rset.getString("PROCEDURE_NAME") + " param : " + rset.getString("MAPPING_NAME") + " 	value " +  map.get(rset.getString("MAPPING_NAME").toString()));
            	 sql = rset.getString("PROCEDURE_NAME");
                 call = con.prepareCall(sql);
                 call.setDouble(1, Integer.parseInt((String) map.get(rset.getString("MAPPING_NAME"))));
                 call.execute();	 	
            
             }else if (rset.getString("TYPE_DATA").equals("DATE")){
            	 System.out.println(rset.getString("PROCEDURE_NAME") + " param : " + rset.getString("MAPPING_NAME") + " 	value " +  map.get(rset.getString("MAPPING_NAME").toString()));
            	 sql = rset.getString("PROCEDURE_NAME");
                 call = con.prepareCall(sql);
                 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                 Date tgl = df.parse((String) map.get(rset.getString("MAPPING_NAME").toString()));
                 call.setDate(1, new java.sql.Date(tgl.getTime()));
                 call.execute();	 	
             }else if (rset.getString("TYPE_DATA").equals("DATETIME")){
            	 System.out.println(rset.getString("PROCEDURE_NAME") + " param : " + rset.getString("MAPPING_NAME") + " 	value " +  map.get(rset.getString("MAPPING_NAME").toString()));
            	    DateFormat formatter2 ; 
	                Date datet ; 	                
	                formatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
	                datet = (Date)formatter2.parse((String) map.get(rset.getString("MAPPING_NAME")));
	                
	                sql = rset.getString("PROCEDURE_NAME");
	                call = con.prepareCall(sql);
	                call.setTimestamp(1, new java.sql.Timestamp(datet.getTime()));
	                call.execute();	 
             }else if (rset.getString("TYPE_DATA").equals("BLOB")){
            	 System.out.println(rset.getString("PROCEDURE_NAME") + " param : " + rset.getString("MAPPING_NAME") + " 	value " +  map.get(rset.getString("MAPPING_NAME").toString()));
            	 sql = rset.getString("PROCEDURE_NAME");
                 String path = (String) map.get(rset.getString("MAPPING_NAME"));
                 if(path != null) {
                 call = con.prepareCall(sql);
                     File filePenagihan = new File((String) map.get(rset.getString("MAPPING_NAME")));
      				 byte[] bufferPenagihan = new byte[(int) filePenagihan.length()];
      				 FileInputStream fisPenagihan = new FileInputStream(filePenagihan);
                     call.setBinaryStream(1, fisPenagihan, (int) filePenagihan.length());
                     call.execute();    
                 }           
                 
             }else if(rset.getString("TYPE_DATA").equals("CURSOR")){
            	 if(rset.getString("PROCEDURE_CALL").substring(0,3).equals("SET")){
            		 	             	 
	                 System.out.println(rset.getString("PROCEDURE_NAME") + " insert : " + rset.getString("PROCEDURE_CALL") + " CODE : " +  map.get("code").toString());
	            	 sql = rset.getString("PROCEDURE_NAME");
	                 call = con.prepareCall(sql);
	                 call.registerOutParameter(1, OracleTypes.CURSOR);
	                 call.setString(2, map.get("code").toString());
//	                 call.setString(3, rset.getString("CRUD_NAME"));            
	                 call.execute();
	                 
	                 ResultSet rseta = (ResultSet) call.getObject(1);	     
	                 lMapa  = new ArrayList<Map>();
	                 lMapa = CommonModule.convertResultsetToListLower(rseta);	  
	                 
//             	 } else if (rset.getString("CODECTRL_NAME").substring(0,4).equals("BLOB")) {
//                   	 
//             		 System.out.println(rset.getString("PROCEDURE_NAME") +  " Get BLOB : " + rset.getString("CODECTRL_NAME"));
//	            	 sql = rset.getString("PROCEDURE_NAME");
//	                 call = con.prepareCall(sql);
//	                 call.registerOutParameter(1, OracleTypes.CURSOR);
//	                 call.setString(2, rset.getString("CODECTRL_NAME"));    
//	                 call.execute();
//
//	                 ResultSet rseta = (ResultSet) call.getObject(1);
//	                 try {
//	 					while (rseta.next()) {
//	 						System.out.println("Dokumen : " + rseta.getString(1) + ".pdf");
//	 						String file_path = "upload/" + rseta.getString(1) + ".pdf";
//		 					File file = new File(CommonModule.getWebInfPath() + file_path);
//	 						InputStream is = rseta.getBinaryStream(2);
//	 		                lMapa  = new ArrayList<Map>();
//	 		                Map maps = new HashMap();
//	 		                maps.put("file_path", file_path);
//	 		                if (is != null) {
//		 		                maps.put("message", "valid");
//			 					if (!file.exists()) {
//			 						file.createNewFile();
//			 					}
//		 						FileOutputStream fos = new FileOutputStream(file);
//		 						byte[] buf = new byte[300000];
//		 						int read = 0;
//		 						while ((read = is.read(buf)) != -1) {
//		 							fos.write(buf, 0, read);
//		 						}
//		 						fos.close();
//		 						is.close();
//	 						
//	 		                } else {
//	 		                	maps.put("message", "Maaf file tidak tersedia / belum di upload");
//	 		                }
//	 		                lMapa.add(maps);
//	 					}
//
//					 } catch (Exception e) {
//						e.printStackTrace();
//					 	map.put("message", e.getMessage());
//					 }

             	 } else {
            		 System.out.println(rset.getString("PROCEDURE_NAME") +  " getlist : " + rset.getString("PROCEDURE_CALL"));
	            	 
            		 sql = rset.getString("PROCEDURE_NAME");
	                 call = con.prepareCall(sql);
	                 call.registerOutParameter(1, OracleTypes.CURSOR);
	                 call.setString(2, rset.getString("PROCEDURE_CALL"));    
	                 call.execute();

	                 ResultSet rseta = (ResultSet) call.getObject(1);	     
	                 lMapa  = new ArrayList<Map>();
	                 lMapa = CommonModule.convertResultsetToListLower(rseta);	                 

             	 }
               }            	
            }            
        }catch (Exception e) {
        	map.put("message", e.getMessage());  
        	e.printStackTrace();
		}
        return lMapa;
	}	

}
