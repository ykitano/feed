package com.feed.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * タブマスタエンティティクラスです。
 * 
 * @author ykitano
 */
@Entity
@Table(name = "tab_m", schema = "webuser")
public class TabM {

    /** タブID */
    @Id
    @GeneratedValue
    @Column(name = "tab_id")
    public Integer tabId;

    /** タブ名 */
    @Column(name = "tab_name")
    public String tabName;

    /** 表示順 */
    public Short order;

    /** 登録日時 */
    @Column(name = "insert_date")
    public Timestamp insertDate;

    /** 更新日時 */
    @Column(name = "update_date")
    public Timestamp updateDate;

}
