package com.feed.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * フィード設定エンティティクラスです。
 * 
 * @author ykitano
 */
@Entity
@Table(name = "feed_setting", schema = "webuser")
public class FeedSetting {

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

    /** 表示件数 */
    @Column(name = "items_per_page")
    public Short itemsPerPage;

    /** 更新間隔 */
    @Column(name = "update_interval")
    public Short updateInterval;

    /** 説明文表示フラグ */
    @Column(name = "body_flg")
    public Short bodyFlg;

    /** 更新日時表示フラグ */
    @Column(name = "date_flg")
    public Short dateFlg;

    /** 登録日時 */
    @Column(name = "insert_date")
    public Timestamp insertDate;

    /** 更新日時 */
    @Column(name = "update_date")
    public Timestamp updateDate;

}
