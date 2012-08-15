package com.feed.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.feed.common.FeedCommon;
import com.feed.form.IndexForm;
import com.feed.service.FeedMService;

/**
 * トップページアクションクラスです。
 * 
 * @author ykitano
 */
public class IndexAction extends AbstractAction {

	@ActionForm
	@Resource
	protected IndexForm indexForm;

	@Resource
	protected FeedMService feedMService;

	@Execute(validator = false)
	public String index() {

		// ランキング読み込み
		indexForm.rankingList = feedMService.getRanking(FeedCommon
				.getInstance().getProperty("raning.max.row"));

		// フィード情報設定
		indexForm.setFeedList();

		return "index.jsp";
	}

}