package com.testframework.apps.internal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;

public interface Pages {

    Logger logger = LogManager.getLogger(Pages.class);

    /**
     * @return Returns the current url of the web page
     */
    default String getPageUrl() {
        logger.info("Current url: "+url()+" of the web page");
        return url();
    }

    /**
     * @return Returns the title of the web page
     */
    default String getPageTitle() {
        return title();
    }

    /**
     * @return Returns the source code of the current page
     */
    default String getPageSource() {
        return source();
    }

}
