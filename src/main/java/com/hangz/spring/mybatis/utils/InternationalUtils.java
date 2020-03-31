package com.hangz.spring.mybatis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author karl xie
 * Created on 2020-03-31 20:22
 */
@Component
public class InternationalUtils {

    public static final String LANG_ZH = "zh";

    public static Boolean isCN() {
        Locale locale = getLocaleOrDefault(new Locale("zh_CN"));
        return LANG_ZH.equals(locale.getLanguage());
    }

    private static Locale getLocaleOrDefault(Locale locale) {
        Locale loc = LocaleContextHolder.getLocale();
        return loc == null ? locale : loc;
    }

    private static final String TYPE_PREFIX = "_device_type_";

    public static String getTypeValue(String type) {
        return getMessage(TYPE_PREFIX + type);
    }

    private static MessageSource messageSource;

    public static String getMessage(String code) {
        return getMessage(code, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        InternationalUtils.messageSource = messageSource;
    }

    private static final String ITEM_PREFIX = "_item_";

    public static String getItem(String itemCode) {
        return getMessage(ITEM_PREFIX + itemCode);
    }

    public static String getItemOrDefault(String itemCode) {
        try {
            return getItem(itemCode);
        } catch (NoSuchMessageException e) {
            return itemCode;
        }
    }
}
