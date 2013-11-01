package com.diboxku.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.i18n.client.DateTimeFormat;

public class ClientModule {
	private static DateTimeFormat df = DateTimeFormat.getFormat("dd/mm/yyyy");

	public static List<BaseModel> setListBaseModelFromListMap(List<Map> l) {
		List<BaseModel> lBM = new ArrayList<BaseModel>();
		if (l.size() > 0) {
			for (Map map : l) {
				BaseModel bm = new BaseModel(map);
				lBM.add(bm);
			}
		}
		return lBM;
	}

}
