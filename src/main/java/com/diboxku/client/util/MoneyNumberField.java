package com.diboxku.client.util;

import java.math.BigDecimal;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.i18n.client.NumberFormat;

public class MoneyNumberField extends NumberField {

	NumberFormat moneyFormat = NumberFormat.getCurrencyFormat();
	NumberFormat numberFormat = NumberFormat.getDecimalFormat();

	public MoneyNumberField() {
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
			bd.setScale(3, BigDecimal.ROUND_HALF_UP);
			try {
				rawvalue = numberFormat.parse(getRawValue().replaceAll(",", ""));
				bd = BigDecimal.valueOf(rawvalue);
				System.out.println(getRawValue().replaceAll(",", "") + "rawvalue try: " + rawvalue);
			}
			catch (NumberFormatException e) {
				try {
					rawvalue = numberFormat.parse(getRawValue().replaceAll(",", ""));
					bd = BigDecimal.valueOf(rawvalue);
					System.out.println("rawvalue catch try: " + rawvalue);
				}
				catch (NumberFormatException e2) {
					rawvalue = null;
				}
			}
			if (rawvalue != null) setRawValue(numberFormat.format(bd.doubleValue()));
			else throw new NumberFormatException();
		} else {
			String rawvalue = "0.0";
			setRawValue(rawvalue);
		}
		validate();
		super.onBlur(arg0);
	}
}