package com.feed.dto;

import java.io.Serializable;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

import com.feed.entity.Member;
import com.feed.entity.MenuM;

/**
 * 会員情報をセッションに保存するクラスです。
 * 
 * @author ykitano
 */
@Component(instance = InstanceType.SESSION)
public class MemberDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 会員ID */
	public int memberId;

	/** 名前 */
	public String name;

	/** 会員ステータス */
	public short status;

	/** メニューリスト */
	public List<MenuM> menuItems;

	/**
	 * ログイン済みかどうか評価します。
	 * 
	 * @return
	 */
	public boolean isLogin() {
		return this.memberId != 0;
	}
	
	public void setData(Member member){
		memberId = member.memberId;
		name = member.name;
		status = member.status;
	}

}