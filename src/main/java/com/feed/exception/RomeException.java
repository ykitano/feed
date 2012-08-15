package com.feed.exception;

/**
 * フィード関連の例外クラスです。
 * 
 * @author ykitano
 */
public class RomeException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタです。
     * 
     * @param message
     */
    public RomeException(String message) {
	super(message);
    }

}