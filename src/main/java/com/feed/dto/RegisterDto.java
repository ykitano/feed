package com.feed.dto;

import java.io.Serializable;

import java.util.List;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

import com.feed.common.FeedCommon;
import com.feed.entity.JobM;
import com.feed.entity.PrefectureM;

@Component(instance = InstanceType.SESSION)
public class RegisterDto implements Serializable {

    private static final long serialVersionUID = 1L;

    protected FeedCommon feedCommon = FeedCommon.getInstance();

    public String loginId;

    public String password;

    public String passwordConfirm;

    public String name;

    public String mailaddress;

    public String year;

    public String month;

    public String day;

    public String birthday;

    public Short gender;

    public Short prefectureId;

    public List<PrefectureM> addressItems;

    public Short jobId;

    public List<JobM> jobItems;

    public String getStrGender() {
	return (gender == 0) ? feedCommon.getProperty("gender.male")
		: feedCommon.getProperty("gender.famale");
    }

    public String getPrefecture() {
	for (PrefectureM instance : addressItems) {
	    if (instance.prefectureId.equals(prefectureId)) {
		return instance.prefecture;
	    }
	}
	return feedCommon.getProperty("prefectureId.not.select");
    }

    public String getJob() {
	for (JobM instance : jobItems) {
	    if (instance.jobId.equals(jobId)) {
		return instance.job;
	    }
	}
	return feedCommon.getProperty("jobId.not.select");
    }

}
