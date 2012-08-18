package com.feed.form;

import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
import org.seasar.struts.annotation.Required;

/**
 * ログインフォームクラスです。
 * 
 * @author Yoshi
 *
 */
public class LoginForm {

    @Required
    @Maxlength(maxlength = 50)
    @Minlength(minlength = 6)
    public String id;

    @Required
    @Maxlength(maxlength = 50)
    @Minlength(minlength = 6)
    public String password;

}
