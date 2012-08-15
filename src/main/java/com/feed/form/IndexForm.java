package com.feed.form;

import java.util.ArrayList;
import java.util.List;

import com.feed.entity.FeedM;
import com.feed.entity.MenuM;
import com.feed.util.RomeUtil;
import com.sun.syndication.feed.synd.SyndFeed;

/**
 * トップページフォームクラスです。
 * 
 * @author ykitano
 */
public class IndexForm {

	public List<MenuM> menuList;
	
    public List<FeedM> rankingList;

    public List<SyndFeed> feedList;

    /**
     * URLからフィード情報を生成し、リストに追加します。
     */
    public void setFeedList() {
	feedList = new ArrayList<SyndFeed>(rankingList.size());
	for (FeedM f : rankingList) {
	    feedList.add(RomeUtil.getFeed(f.url));
	}
    }

}
