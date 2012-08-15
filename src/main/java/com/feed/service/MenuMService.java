package com.feed.service;

import java.util.List;

import org.seasar.extension.jdbc.service.S2AbstractService;

import com.feed.entity.MenuM;

/**
 * メニューマスタサービスクラスです。
 * 
 * @author ykitano
 */
public class MenuMService extends S2AbstractService<MenuM> {

	/**
	 * ステータスをキーにメニューを取得します。
	 * 
	 * @param status
	 * @return
	 */
	public List<MenuM> selectByStatus(int status) {
		return select().where("status = ?", status).orderBy("order")
				.getResultList();
	}

}