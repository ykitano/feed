package com.feed.action;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.Execute;

/**
 * ログアウトアクションクラスです。<br>
 * セッションからmemberDtoを削除します。
 * 
 * @author ykitano
 */
public class LogoutAction {

    @Execute(validator = false)
    @RemoveSession(name = "memberDto")
    public String index() {
	return "/";
    }

}