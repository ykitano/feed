package com.feed.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.syndication.feed.synd.SyndFeed;

/**
 * フィードマスタエンティティクラスです。
 * 
 * @author ykitano
 */
@Entity
@Table(name = "feed_m", schema = "webuser")
public class FeedM {

    /** フィードID */
    @Id
    @GeneratedValue
    @Column(name = "feed_id")
    public Integer feedId;

    /** タイトル */
    public String title;

    /** 説明 */
    public String description;

    /** URL */
    public String url;

    /** 購読数 */
    public Integer subscription;

    /** 登録日時 */
    @Column(name = "insert_date")
    public Timestamp insertDate;

    /** 更新日時 */
    @Column(name = "update_date")
    public Timestamp updateDate;
    
    public FeedM(){
	
    }

    /**
     * コンストラクタです。<br>
     * フィード情報からインスタンスを作成します。
     * 
     * @param syndFeed
     */
    public FeedM(SyndFeed syndFeed) {
	this.title = syndFeed.getTitle();
	this.description = syndFeed.getDescription();
	this.subscription = 0;
    }

}
