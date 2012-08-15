package com.feed.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 都道府県マスタエンティティクラスです。
 * 
 * @author ykitano
 */
@Entity
@Table(name = "prefecture_m", schema = "webuser")
public class PrefectureM {

    /** 都道府県ID */
    @Id
    @GeneratedValue
    @Column(name = "prefecture_id")
    public Short prefectureId;

    /** 都道府県名 */
    public String prefecture;

    /** 登録日時 */
    @Column(name = "insert_date")
    public Timestamp insertDate;

    /** 更新日時 */
    @Column(name = "update_date")
    public Timestamp updateDate;

}
