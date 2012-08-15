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

	registerForm.initialize();
	registerDto.addressItems = prefectureMService.findAll();
	registerDto.jobItems = jobMService.findAll();

	return "index.jsp";
    }

    @Execute(validator = true, validate = "registeredValidate, passwordValidate, birthdayValidate", input = "index.jsp")
    public String confirm() {

	Beans.copy(registerForm, registerDto).excludes("birthday").execute();

	registerForm.strGender = registerDto.getStrGender();

	registerForm.prefecture = registerDto.getPrefecture();

	registerForm.job = registerDto.getJob();

	TokenProcessor.getInstance().saveToken(request);

	return "confirm.jsp";
    }

    @Execute(validator = false)
    public String reinput() {

	Beans.copy(registerDto, registerForm).execute();

	TokenProcessor.getInstance().saveToken(request);

	return "index.jsp";
    }

    @Execute(validator = false, validate = "tokenValidate", input = "/error/token.jsp")
    public String register() {

	Member member = Beans.createAndCopy(Member.class, registerDto)
		.execute();

	member.status = 0;

	Timestamp now = new Timestamp(System.currentTimeMillis());

	member.insertDate = now;

	member.updateDate = now;

	memberService.insert(member);

	member.memberId = memberService.getMemberId(member.loginId);

	memberDto.setData(member);

	return "finish.jsp";
    }

    public ActionMessages registeredValidate() {

	ActionMessages errors = new ActionMessages();

	if (memberService.getCount(registerForm.loginId) != 0) {
	    errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
		    "errors.registered", null));
	}

	return errors;
    }

    public ActionMessages passwordValidate() {

	FeedCommon feedCommon = FeedCommon.getInstance();
	ActionMessages errors = new ActionMessages();

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
