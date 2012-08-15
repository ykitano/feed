package com.feed.common;

import java.util.Properties;

/**
 * 読み込んだプロパティファイルから値を取得するシングルトンクラスです。
 * 
 * @author ykitano
 */
public final class FeedCommon {

    /** このクラス唯一のインスタンス */
    private static FeedCommon instance = null;

    /** プロパティファイル読み込みクラス */
    private LoadProperty loadProperty = null;

    /** プロパティ */
    private Properties props = null;

    /*
     * コンストラクタ
     */
    private FeedCommon() {
	initialize();
    }

    /*
     * 初期化
     */
    private void initialize() {
	loadProperty = new LoadProperty();
	loadPropertyFile();
    }

    /*
     * プロパティファイルを読み込みます。
     */
    private void loadPropertyFile() {
	// クラス名からプロパティファイルを生成します。
	props = loadProperty.loadPropertyFile(super.getClass());
    }

    /**
     * インスタンスを返します。
     * 
     * @return このクラスのインスタンス
     */
    public static synchronized FeedCommon getInstance() {

	if (FeedCommon.instance == null) {
	    FeedCommon.instance = new FeedCommon();
	}

	return instance;
    }

    /**
     * プロパティファイルから読み込んだ値を返します。
     * 
     * @param propertyName
     *            プロパティ名
     * @return プロパティの値
     * @throws SystemException
     */
    public String getProperty(final String key) {

	String property = props.getProperty(key);

	if (property == null) {
	    throw new IllegalArgumentException("指定されたプロパティ値が設定されていません。[" + key
		    + "]");
	}

	return property;
    }

}