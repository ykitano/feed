package com.feed.util;

import org.seasar.framework.util.URLUtil;

import com.feed.exception.RomeException;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;

/**
 * フィード情報を扱うクラスです。
 * 
 * @author ykitano
 */
public class RomeUtil {

    /**
     * URLからフィード情報を取得し、返します。
     * @param url
     * @return
     */
    public static SyndFeed getFeed(String url) {
	try{
	    return new HttpURLFeedFetcher().retrieveFeed(URLUtil.create(url));
	} catch(Exception e){
	    throw new RomeException(e.toString());
	}
    }
    
}