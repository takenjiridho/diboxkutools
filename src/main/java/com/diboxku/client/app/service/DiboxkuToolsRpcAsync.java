package com.diboxku.client.app.service;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DiboxkuToolsRpcAsync {
	void getUtilDao(String kode, Map map, AsyncCallback<List<Map>> callback);
}
