package com.diboxku.client.util;

import java.math.BigDecimal;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.NumberFormat;

public class DecimalField extends NumberField {

	NumberFormat numberFormat = NumberFormat.getDecimalFormat();
	int precision = 0;
	boolean shows = false;
	

	public DecimalField(int decimalPrecision, boolean alwaysShow) {
		String format = "###,###";
		shows = alwaysShow;
		precision = decimalPrecision;
		if(decimalPrecision>0) format += ".";
		for(int i=0; i<decimalPrecision; i++){
			format += "0";
		}
		if(alwaysShow)numberFormat = NumberFormat.getFormat(format);
		setFormat(numberFormat);
		String formatchars = numberFormat.format(10000.0);
		String basechars = "1234567890";
		for (int i = 0; i < formatchars.length(); i++) {
			if (!Character.isDigit(formatchars.charAt(i))) {
				basechars += formatchars.charAt(i);
			}
		}
		setBaseChars(basechars);
	}
	
	@Override
	protected void onBlur(ComponentEvent arg0) {
		if (getRawValue() != null && !getRawValue().equals("") && !getRawValue().equals("0") && !getRawValue().equals("0.0")) {
			Double rawvalue = 0d;
			BigDecimal bd = new BigDecimal(rawvalue);
			bd.setScale(precision, BigDecimal.ROUND_DOWN);
			try {
				rawvalue = numberFormat.parse(getRawValue().replaceAll(",", ""));
				bd = BigDecimal.valueOf(rawvalue);
			}
			catch (NumberFormatException e) {
				try {
					rawvalue = numberFormat.parse(getRawValue().replaceAll(",", ""));
					bd = BigDecimal.valueOf(rawvalue);
				}
				catch (NumberFormatException e2) {
					rawvalue = null;
				}
			}
			if (rawvalue != null) setRawValue(numberFormat.format(bd.doubleValue()));
			else throw new NumberFormatException();
		} else {
			String rawvalue = "0";
			setRawValue(rawvalue);
		}
		validate();
		super.onBlur(arg0);
	}	
	
	@Override
	protected void onKeyUp(FieldEvent fe) {
		// TODO Auto-generated method stub
		boolean key = true;
		if(fe.getKeyCode()==110||fe.getKeyCode()==190||isReadOnly())key=false;
        if(key){
		int pos = getCursorPos();
		int beforeLength = getRawValue().length();
		int afterLength = 0;
		int valRaw = 0;
		String getRaw = "";
		if (getRawValue() != null && !getRawValue().equals("") && !getRawValue().equals("0") && !getRawValue().equals("0.0")) {
			Double rawvalue = 0d;
			BigDecimal bd = new BigDecimal(rawvalue);
			bd.setScale(precision, BigDecimal.ROUND_DOWN);
			try {
				rawvalue = numberFormat.parse(getRawValue().replaceAll(",", ""));
				bd = BigDecimal.valueOf(rawvalue);
				getRaw = getRawValue().replaceAll(",", "");
			}
			catch (NumberFormatException e) {
				try {
					rawvalue = numberFormat.parse(getRawValue().replaceAll(",", ""));
					bd = BigDecimal.valueOf(rawvalue);
				}
				catch (NumberFormatException e2) {
					rawvalue = null;
				}
			}
			if (rawvalue != null) {
				if(shows) {
					String rawVal = getRawValue().replaceAll(",", "");
					String val = NumberFormat.getDecimalFormat().format(bd.doubleValue());
					int diff = 0;
					if (rawVal.indexOf(".") >= 0) {
						rawVal = rawVal.substring(rawVal.indexOf("."));
						if(rawVal.length() > precision+1) {
							rawVal = rawVal.substring(0, precision+1);
						}
					} else {
						rawVal = "";
					}
					if (val.indexOf(".") >= 0) {
						if(val.substring(val.indexOf(".")).length() < rawVal.length()) {
							diff = rawVal.length() - val.substring(val.indexOf(".")).length();
							for(int i = 0; i<diff; i++) {
								val = val + "0";
							}
						}
//						val = val.substring(0, val.indexOf(".")) + rawVal;
					} else {
						val = val+rawVal;
					}
					setRawValue(val);
				} else {
					setRawValue(numberFormat.format(bd.doubleValue()));
				}
			}
			else throw new NumberFormatException();
		} else {
//			String rawvalue = "0";
//			setRawValue(rawvalue);
		}
		afterLength = getRawValue().length();
		if(beforeLength<afterLength) {
			pos += 1;
		} else if (beforeLength>afterLength) {
			pos -= 1;
		}
		setCursorPos(pos);
        }
		super.onKeyUp(fe);
	}
	
	
}