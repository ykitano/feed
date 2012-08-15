package com.feed.form;

import org.apache.struts.upload.FormFile;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Required;

/**
 * フィード登録フォームクラスです。
 * 
 * @author ykitano
 */
public class RegisterFeedForm {

    @Required(arg0 = @Arg(key = "URLリスト", resource = false))
    @Binding(bindingType = BindingType.NONE)
    public FormFile formFile;

}
