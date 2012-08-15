package com.feed.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.struts.util.ActionMessagesUtil;

import com.feed.dto.MemberDto;

/**
 * アクションの共通親クラスです。
 * 
 * @author ykitano
 */
public abstract class AbstractAction {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    @Resource
    protected HttpSession session;

    @Resource
    protected ServletContext application;

    @Resource
    public MemberDto memberDto;

    /**
     * 引数なしでエラーメッセージを追加します。
     * 
     * @param key
     */
    protected void addErrors(String key) {
	addErrors(key, null);
    }

    /**
     * 引数ありでエラーメッセージを追加します。
     * 
     * @param key
     * @param values
     */
    protected void addErrors(String key, Object[] values) {
	ActionMessagesUtil.addErrors(request, getMessages(key, values));
    }

    /**
     * 共通メッセージ追加メソッドです。 アクションメッセージにメッセージを追加します。
     * 
     * @param key
     * @param values
     * @return
     */
    private ActionMessages getMessages(String key, Object[] values) {
	ActionMessages messages = new ActionMessages();
	messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key,
		values));
	return messages;
    }

    /**
     * 引数なしでメッセージを追加します。
     * 
     * @param key
     */
    protected void addMessages(String key) {
	addMessages(key, null);
    }

    /**
     * 引数ありでメッセージを追加します。
     * 
     * @param key
     * @param values
     */
    protected void addMessages(String key, Object[] values) {
	ActionMessagesUtil.addMessages(request, getMessages(key, values));
    }

    /**
     * トークンバリデートです。
     * 
     * @return
     */
    public ActionMessages tokenValidate() {
	ActionMessages errors = new ActionMessages();
	if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
	    errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
		    "errors.invalid", "トークン"));
	    ActionMessagesUtil.saveErrors(request, errors);
	    throw new IllegalStateException("トークンが不正です。");
	}
	return errors;
    }

}