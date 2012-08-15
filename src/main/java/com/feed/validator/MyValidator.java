package com.feed.validator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.validator.S2FieldChecks;

/**
 * 使用許可文字バリデータークラスです。
 * 
 * @author ykitano
 */
public class MyValidator extends S2FieldChecks {

    private static final long serialVersionUID = 1L;

    /**
     * 使用許可文字かどうかチェックします。
     * 
     * @param bean
     * @param validatorAction
     * @param field
     * @param errors
     * @param validator
     * @param request
     * @return
     */
    public static boolean validatePermitCharacter(Object bean,
	    ValidatorAction validatorAction, Field field,
	    ActionMessages errors, Validator validator,
	    HttpServletRequest request) {

	String value = getValueAsString(bean, field);
	if (!GenericValidator.isBlankOrNull(value)) {
	    try {
		for (byte b : value.getBytes("UTF-8")) {//Shift_JIS
		    // 第一水準：0x889F ～ 0x9872
		    // 第二水準：0x989F ～ 0xFC4B
		    if (b < (byte) 0x889F || (byte) 0x9872 < b
			    || b < (byte) 0x989F || (byte) 0xFC4B < b) {
			addError(errors, field, validator, validatorAction,
				request);
			return false;
		    }
		}
	    } catch (Exception e) {
		addError(errors, field, validator, validatorAction, request);
		return false;
	    }
	}
	return true;
    }

}