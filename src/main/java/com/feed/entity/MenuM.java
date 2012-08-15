package com.feed.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * メニューマスタエンティティクラスです。
 * 
 * @author ykitano
 */
@Entity
@Table(name = "menu_m", schema = "webuser")
public class MenuM{
    
    /** ステータス */
    @Id
    public Short status;

    /** 表示順 */
    @Id
    public Short order;

    /** タイトル */
    public String title;

    /** URL */
    public String url;

    /** 登録日時 */
    @Column(name = "insert_date")
    public Timestamp insertDate;

    /** 更新日時 */
    @Column(name = "update_date")
    public Timestamp updateDate;

}
