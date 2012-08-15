package com.feed.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Validator;

/**
 * 使用許可文字アノテーションです。まだ使えません。
 * 
 * @author ykitano
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Validator("permitCharacter")
public @interface PermitCharacter {

    /**
     * メッセージです。
     * 
     */
    Msg msg() default @Msg(key = "errors.character");

    /**
     * メッセージの最初の引数です。
     * 
     */
    Arg arg0() default @Arg(key = "");

    /**
     * 検証の対象となるメソッド名を指定します。 複数ある場合はカンマで区切ります。
     * 
     */
    String target() default "";

}