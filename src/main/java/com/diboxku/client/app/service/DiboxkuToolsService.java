package com.diboxku.client.app.service;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("admintools")
public interface DiboxkuToolsService extends RemoteService {
	List<Map> getUtilDao(String kode, Map map);

}
