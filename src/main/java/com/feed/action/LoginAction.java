package com.feed.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.feed.form.LoginForm;

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
	return "/home?redirect=true";
    }

}
