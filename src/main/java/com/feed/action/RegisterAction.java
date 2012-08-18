package com.feed.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.feed.common.FeedCommon;
import com.feed.dto.RegisterDto;
import com.feed.entity.Member;
import com.feed.form.RegisterForm;
import com.feed.service.JobMService;
import com.feed.service.MemberService;
import com.feed.service.PrefectureMService;

/**
 * 会員登録アクションクラスです。
 * 
 * @author Yoshi
 * 
 */
public class RegisterAction extends AbstractAction {

    @ActionForm
    @Resource
    protected RegisterForm registerForm;

    @Resource
    protected PrefectureMService prefectureMService;

    @Resource
    protected JobMService jobMService;

    @Resource
    public RegisterDto registerDto;

    @Resource
    protected MemberService memberService;

    @Execute(validator = false)
    public String index() {

	// フォームを初期化
	registerForm.initialize();
	// 住所一覧を取得
	registerDto.addressItems = prefectureMService.findAll();
	// 職業一覧を取得
	registerDto.jobItems = jobMService.findAll();

	return "index.jsp";
    }

    @Execute(validator = true, validate = "registeredValidate, passwordValidate, birthdayValidate", input = "index.jsp")
    public String confirm() {

	// フォームをDTOにコピー
	Beans.copy(registerForm, registerDto).excludes("birthday").execute();

	// 性別表示用文字列の取得
	registerForm.strGender = registerDto.getStrGender();

	// 都道府県表示用文字列の取得
	registerForm.prefecture = registerDto.getPrefecture();

	// 職業表示用文字列の取得
	registerForm.job = registerDto.getJob();

	// トークンの取得
	TokenProcessor.getInstance().saveToken(request);

	return "confirm.jsp";
    }

    @Execute(validator = false)
    public String reinput() {

	// DTOをフォームにコピー
	Beans.copy(registerDto, registerForm).execute();

	// トークンを取得
	TokenProcessor.getInstance().saveToken(request);

	return "index.jsp";
    }

    @Execute(validator = false, validate = "tokenValidate", input = "/error/token.jsp")
    public String register() {

	// 会員情報エンティティをDTOから作成
	Member member = Beans.createAndCopy(Member.class, registerDto)
		.execute();

	// 会員ステータスを一般(0)に設定
	member.status = 0;

	// 現在日時の取得
	Timestamp now = new Timestamp(System.currentTimeMillis());

	member.insertDate = now;

	member.updateDate = now;

	// 会員情報テーブルに登録
	memberService.insert(member);

	// 会員IDの取得
	member.memberId = memberService.getMemberId(member.loginId);

	// DTOに会員情報を保存
	memberDto.setData(member);

	return "finish.jsp";
    }

    public ActionMessages registeredValidate() {

	ActionMessages errors = new ActionMessages();

	// 会員情報テーブルにログインIDが登録されていた場合
	if (memberService.getCount(registerForm.loginId) != 0) {
	    errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
		    "errors.registered", null));
	}

	return errors;
    }

    public ActionMessages passwordValidate() {

	FeedCommon feedCommon = FeedCommon.getInstance();
	ActionMessages errors = new ActionMessages();

	// パスワードとパスワード（確認）が一致しない場合
	if (!registerForm.password.equals(registerForm.passwordConfirm)) {
	    errors.add(ActionMessages.GLOBAL_MESSAGE,
		    new ActionMessage("errors.nomatch", new String[] {
			    feedCommon.getProperty("passwordValidate.args1"),
			    feedCommon.getProperty("passwordValidate.args1") }));
	    // パスワードの初期化
	    registerForm.clearPassword();
	}

	return errors;
    }

    public ActionMessages birthdayValidate() {

	ActionMessages errors = new ActionMessages();

	// プロパティファイルの取得
	FeedCommon feedCommon = FeedCommon.getInstance();

	if (!registerForm.isBirthdayNoInput()) {

	    SimpleDateFormat sdf = new SimpleDateFormat(
		    feedCommon.getProperty("birthdayValidate.pattern"));

	    // フォーマットを厳密に行う
	    sdf.setLenient(false);

	    try {
		sdf.parse(registerForm.makeBirthday());

		registerForm.birthday = registerForm.makeBirthday();

	    } catch (ParseException e) {
		errors.add(
			ActionMessages.GLOBAL_MESSAGE,
			new ActionMessage(
				"errors.invalid",
				new String[] {
					feedCommon
						.getProperty("birthdayValidate.args1"),
					feedCommon
						.getProperty("birthdayValidate.args2") }));
	    }
	} else {
	    registerForm.birthday = feedCommon.getProperty("no.input.birthday");
	}

	return errors;
    }
}
