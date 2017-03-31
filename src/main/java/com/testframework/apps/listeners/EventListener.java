package com.testframework.apps.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventListener implements WebDriverEventListener {

    private static final Logger logger = LogManager.getLogger(EventListener.class);

    @Override
    //@Step("Click on element: {0}")
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("clicked element with " + getLocatorFromElement(element));
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("change value of element with " + getLocatorFromElement(webElement));
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("changed value of element with " + getLocatorFromElement(webElement));
    }

    @Override
    public void afterFindBy(By by, WebElement arg1, WebDriver arg2) {
        logger.info("found element " + by);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        logger.info("after back");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        logger.info("after forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.info("before navigation refresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.info("after navigation refresh");
    }

    @Override
    @Step("Navigate to: {0}")
    public void afterNavigateTo(String url, WebDriver driver) {
        //AllureReport.browserConsoleLogEntryToReport();
        logger.info("navigated to " + url);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        //logger.info("execute script " + script);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("click element with " + getLocatorFromElement(element));
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver arg2) {
        logger.info("find element " + by);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        logger.info("before back");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        logger.info("before forward");
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        logger.info("before alert accept");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        logger.info("after alert accept");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        logger.info("after alert dismiss");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.info("before alert dismiss");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info("navigate to " + url);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        //logger.info("running script " + script);
    }

    @Override
    public void onException(Throwable thrw, WebDriver driver) {
        logger.info(thrw.getMessage());
    }

    private String getLocatorFromElement(WebElement element) {
        String str = element.toString();
        Pattern p = Pattern.compile("->\\s(.*)(?=\\])");
        Matcher m = p.matcher(str);
        return m.find() && m.groupCount() > 0 ? m.group(1) : str;
    }
}

