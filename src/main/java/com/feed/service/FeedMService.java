package com.feed.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;
import org.seasar.framework.log.Logger;
import org.seasar.framework.util.InputStreamReaderUtil;

import com.feed.common.FeedCommon;
import com.feed.entity.FeedM;
import com.feed.exception.RomeException;
import com.feed.util.RomeUtil;

/**
 * フィードマスタサービスクラスです。
 * 
 * @author ykitano
 */
public class FeedMService extends AbstractService<FeedM> {

    private static final Logger logger = Logger.getLogger(FeedMService.class);

    /**
     * 購読数の多い順で引数の数だけ取得します。
     * 
     * @param maxRow
     * @return
     */
    public List<FeedM> getRanking(String maxRow) {
	return select().maxRows(Integer.parseInt(maxRow)).orderBy(
		"subscription").getResultList();
    }

    /**
     * フィード情報を登録します。
     * 
     * @param file
     * @throws Exception
     */
    public void register(FormFile file) throws Exception {

	InputStream is = null;
	Reader reader = null;
	BufferedReader br = null;

	try {
	    is = file.getInputStream();
	    reader = InputStreamReaderUtil.create(is, FeedCommon.getInstance()
		    .getProperty("encoding"));
	    br = new BufferedReader(reader);
	    String str;
	    List<FeedM> feedMList = new ArrayList<FeedM>();
	    FeedM feedM = null;
	    Timestamp now = new Timestamp(System.currentTimeMillis());

	    while ((str = br.readLine()) != null) {
		feedM = getFeedM(str);
		if (feedM != null) {
		    feedM.url = str;
		    feedM.insertDate = now;
		    feedM.updateDate = now;
		    feedMList.add(feedM);
		}
	    }

	    for (FeedM entity : feedMList) {
		if (isNotRegistered(entity)) {
		    insert(entity);
		}
	    }

	} finally {
	    if (br != null) {
		br.close();
	    }
	    if (reader != null) {
		reader.close();
	    }
	    if (is != null) {
		is.close();
	    }
	}
    }

    /*
     * フィードマスタエンティティを取得します。
     */
    private FeedM getFeedM(String url) {
	try {
	    return (RomeUtil.getFeed(url).getEntries().size() != 0) ? new FeedM(
		    RomeUtil.getFeed(url))
		    : null;
	} catch (RomeException re) {
	    logger.error(url + " : " + re.toString());
	    return null;
	}
    }

    /*
     * DBに登録済みでないか評価します。
     */
    private boolean isNotRegistered(FeedM feedM) {
	return (selectCountByUrl(feedM.url) == 0);
    }

    /*
     * URLをキーにデータ数を取得します。
     */
    private long selectCountByUrl(String url) {
	return jdbcManager.getCountBySql(
		"SELECT * FROM webuser.feed_m WHERE url = ?", url);
    }

}