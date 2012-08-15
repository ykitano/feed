package com.feed.service;

import org.seasar.extension.jdbc.AutoSelect;

import com.feed.entity.Member;

public class MemberService extends AbstractService<Member> {

	public long getCount(String loginId) {
		return selectByLoginId(loginId).getCount();
	}
	
	public int getMemberId(String loginId){
		Member member = selectByLoginId(loginId).getSingleResult();
		return member.memberId;
	}

	public AutoSelect<Member> selectByLoginId(String loginId) {
		return select().where("login_id = ?", loginId);
	}

}
