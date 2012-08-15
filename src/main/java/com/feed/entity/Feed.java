package com.feed.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * フィードエンティティクラスです。
 * 
 * @author ykitano
 */
@Entity
@Table(schema = "webuser")
public class Feed {

    /** 会員ID */
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    public Integer memberId;

    /** フィードID */
    @Id
    @GeneratedValue
    @Column(name = "feed_id")
    public Integer feedId;

    /** タブID */
    @Column(name = "tab_id")
    public Integer tabId;

    /** 列ID */
    @Column(name = "column_order")
    public Short columnOrder;

    /** 表示順 */
    public Short order;

    /** 登録日時 */
    @Column(name = "insert_date")
    public Timestamp insertDate;

    /** 更新日時 */
    @Column(name = "update_date")
    public Timestamp updateDate;

}
