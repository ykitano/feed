package com.feed.exception;

/**
 * 未ログイン状態を知らせる例外クラスです。
 * 
 * @author ykitano
 */
public class NoLoginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタです。
     * 
     * @param message
     */
    public NoLoginException(String message) {
	super(message);
    }

}