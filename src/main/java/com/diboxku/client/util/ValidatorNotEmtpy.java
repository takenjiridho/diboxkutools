package com.diboxku.client.util;

import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;

public class ValidatorNotEmtpy implements Validator {
	public ValidatorNotEmtpy() {
    }

    public String validate(Field<?> field, String value) {
            if(value!=null)
                if(value.trim().isEmpty())
                    return "Require!";
            return null;
   }
}
