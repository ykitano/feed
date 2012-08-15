package com.feed.entity;

import java.sql.Date;
import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 会員情報エンティティクラスです。
 * 
 * @author ykitano
 */
@Entity
@Table(schema = "webuser")
public class Member {

    /** 会員ID */
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    public Integer memberId;

    /** ログインID */
    @Column(name = "login_id")
    public String loginId;

    /** パスワード */
    public String password;

    /** メールアドレス */
    public String mailaddress;

    /** 名前 */
    public String name;

    /** 生年月日 */
    public Date birthday;

    /** 性別 */
    public Short gender;

    /** 都道府県ID */
    @Column(name = "prefecture_id")
    public Short prefectureId;

    /** 職業ID */
    @Column(name = "job_id")
    public Short jobId;

    /** ステータス */
    public Short status;

    /** 登録日時 */
    @Column(name = "insert_date")
    public Timestamp insertDate;

    /** 更新日時 */
    @Column(name = "update_date")
    public Timestamp updateDate;

}
