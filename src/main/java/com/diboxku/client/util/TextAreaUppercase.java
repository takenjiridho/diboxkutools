package com.diboxku.client.util;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;

public class TextAreaUppercase extends TextArea {
	
	@Override
    protected void onKeyPress(FieldEvent fe) {
        super.onKeyPress(fe);
        if(!super.isReadOnly()){
        char key = (char)fe.getKeyCode();
        String keyStr = new String(new char[] { key });
        String value;
        if(getValue() == null) {
            value = "";
        } else {
            value = (String)getValue();
        }
        if(!keyStr.toUpperCase().equals(keyStr)) {
            fe.stopEvent();
            setValue(value + keyStr.toUpperCase());
        }
        }
    }
	@Override
	protected void onBlur(ComponentEvent be) {
		// TODO Auto-generated method stub
		super.onBlur(be);
		if(getValue() != null)
		setValue(getValue().toString().toUpperCase());
	}
	
}
