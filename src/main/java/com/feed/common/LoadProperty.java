package com.feed.common;

import java.io.InputStream;
import java.util.Properties;

import org.seasar.framework.util.InputStreamUtil;
import org.seasar.framework.util.PropertiesUtil;
import org.seasar.framework.util.ResourceUtil;

/**
 * プロパティファイルを読み込むクラスです。
 * 
 * @author ykitano
 */
public class LoadProperty {

    /** デフォルト拡張子 */
    public static final String DEFAULT_EXTENSION = ".properties";

    /** デフォルトパス */
    public static final String DEFAULT_PATH = "/";

    /**
     * プロパティファイルを読み込みます。
     * 
     * @param obj
     * @return
     */
    public Properties loadPropertyFile(final Class<?> obj) {

	Properties props = new Properties();
	InputStream is = null;

	try {
	    // クラス名.propertiesを読み込む
	    is = ResourceUtil.getResourceAsStream(DEFAULT_PATH
		    + obj.getSimpleName() + DEFAULT_EXTENSION);

	    PropertiesUtil.load(props, is);

	} finally {
	    InputStreamUtil.close(is);
	}

	return props;
    }

}