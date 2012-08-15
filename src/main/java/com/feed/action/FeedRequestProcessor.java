package com.feed.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.struts.action.S2RequestProcessor;
import org.seasar.struts.config.S2ExecuteConfig;
import org.seasar.struts.util.S2ExecuteConfigUtil;

import com.feed.annotation.Auth;
import com.feed.dto.MemberDto;
import com.feed.exception.NoLoginException;
import com.feed.service.MenuMService;

/**
 * メニューの読み込みとログイン認証を行うリクエストプロセッサです。
 * 
 * @author ykitano
 */
public class FeedRequestProcessor extends S2RequestProcessor {

	/**
	 * メニューの読み込みを行います。
	 */
	@Override
	protected ActionForm processActionForm(HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {

		MemberDto memberDto = SingletonS2Container
				.getComponent(MemberDto.class);

		// メニューを読み込みます
		loadMenu(memberDto);

		return super.processActionForm(request, response, mapping);
	}

	/**
	 * ログイン認証を行います。
	 */
	@Override
	protected boolean processRoles(HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws IOException, ServletException {

		MemberDto memberDto = SingletonS2Container
				.getComponent(MemberDto.class);

		// ログイン認証を行います
		authLogin(memberDto);

		return super.processRoles(request, response, mapping);
	}

	/*
	 * メニューが読み込まれていなければ、メニューを読み込みます。
	 */
	private void loadMenu(MemberDto memberDto) {
		if (memberDto.menuItems == null) {
			MenuMService menuMService = SingletonS2Container
					.getComponent(MenuMService.class);
			memberDto.menuItems = menuMService.selectByStatus(0);
		}
	}

	/*
	 * 未ログイン状態でAuthアノテーションが設定されているクラスにアクセスした場合、 NoLoginExceptionを投げます。
	 */
	private void authLogin(MemberDto memberDto) {
		S2ExecuteConfig executeConfig = S2ExecuteConfigUtil.getExecuteConfig();
		Auth auth = executeConfig.getMethod().getDeclaringClass()
				.getAnnotation(Auth.class);

		if (auth != null && !memberDto.isLogin()) {
			throw new NoLoginException("ログインしていません。");
		}
	}

}