package com.feed.action;

import javax.annotation.Resource;

import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.log.Logger;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.UploadUtil;

import com.feed.annotation.Auth;
import com.feed.form.RegisterFeedForm;
import com.feed.service.FeedMService;

/**
 * フィード登録アクションクラスです。<br>
 * フィードリストから読み込んだURLを使用し、<br>
 * フィード情報を取得してDBに登録します。
 * 
 * @author ykitano
 */
@Auth
public class RegisterFeedAction extends AbstractAction {

    private static final Logger logger = Logger
	    .getLogger(RegisterFeedAction.class);

    @Resource
    @ActionForm
    protected RegisterFeedForm registerFeedForm;

    @Resource
    protected FeedMService feedMService;

    @Execute(validator = false)
    public String index() {
	
	// トークンの取得
	TokenProcessor.getInstance().saveToken(request);
	
	// アップロード上限値チェック
	UploadUtil.checkSizeLimit(request);
	
	return "index.jsp";
    }

    @Execute(validator = true, validate = "tokenValidate", input = "index.jsp")
    public String register() {

	try {
	    feedMService.register(registerFeedForm.formFile);
	    addMessages("messages.register.feed.success");
	} catch (Exception e) {
	    addErrors("errors.register.feed.error");
	    logger.error(e.toString());
	}

	return "index";
    }

}