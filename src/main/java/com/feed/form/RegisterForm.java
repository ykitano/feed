package com.feed.form;

import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.EmailType;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
import org.seasar.struts.annotation.Required;

import com.feed.common.FeedCommon;

public class RegisterForm {

    protected FeedCommon feedCommon = FeedCommon.getInstance();

    @Required
    @Maxlength(maxlength = 50)
    @Minlength(minlength = 6)
    public String loginId;

    @Required
    @Maxlength(maxlength = 50)
    @Minlength(minlength = 6)
    public String password;

    @Required
    @Maxlength(maxlength = 50)
    @Minlength(minlength = 6)
    public String passwordConfirm;

    @Required
    @Maxlength(maxlength = 20)
    public String name;

    @Required
    @Maxlength(maxlength = 100)
    @EmailType
    public String mailaddress;

    @Maxlength(maxlength = 4)
    public String year;

    @Maxlength(maxlength = 2)
    public String month;

    @Maxlength(maxlength = 2)
    public String day;

    public String birthday;

    @Required
    public Short gender;

    public String strGender;

    public Short prefectureId;

    public String prefecture;

    public Short jobId;

    public String job;

    public void initialize() {
	gender = 0;
    }

    public void clearPassword() {
	password = "";
	passwordConfirm = "";
    }

    public boolean isBirthdayNoInput() {
	return (StringUtil.isEmpty(year) && StringUtil.isEmpty(month) && StringUtil
		.isEmpty(day));
    }

    public String makeBirthday() {
	return year + "/" + month + "/" + day;
    }

}
