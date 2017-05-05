package com.testframework.apps.wrappers;

import com.testframework.apps.internal.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage<T> implements PageObjectsSupplier, HelperObjectSupplier, Pages, BrowserWindow, Cookies {

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    @SuppressWarnings("unchecked")
    private T get() {
        return (T) this;
    }

    protected abstract String getUrl();

    public T openPage() {
        open(getUrl());
        return get();
    }

    public T openPage(String customUrlPage) {
        open(customUrlPage);
        return get();
    }

    public T openPageWithTab(String navTab) {
        open(getUrl() + navTab);
        return get();
    }

    public T openPageWithTab(String customUrlPage, String navTab) {
        open(customUrlPage + navTab);
        return get();
    }

}
