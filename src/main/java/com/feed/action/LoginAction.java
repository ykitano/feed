package com.feed.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.feed.form.LoginForm;

/**
 * ログインアクションクラスです。
 * 
 * @author Yoshi
 * 
 */
public class LoginAction {

    @ActionForm
    @Resource
    protected LoginForm loginForm;

    @Execute(validator = false)
    public String index() {
	return "index.jsp";
    }

    @Execute(validator = true, input = "index.jsp")
    public String login() {
	// 会員トップページへ遷移
	return "/home?redirect=true";
    }

}
