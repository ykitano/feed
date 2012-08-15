package com.feed.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 職業マスタエンティティクラスです。
 * 
 * @author ykitano
 */
@Entity
@Table(name = "job_m", schema = "webuser")
public class JobM {

    /** 職業ID */
    @Id
    @GeneratedValue
    @Column(name = "job_id")
    public Short jobId;

    /** 職業 */
    public String job;

    /** 登録日時 */
    @Column(name = "insert_date")
    public Timestamp insertDate;

    /** 更新日時 */
    @Column(name = "update_date")
    public Timestamp updateDate;

}
