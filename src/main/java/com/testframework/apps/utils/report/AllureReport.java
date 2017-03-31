package com.testframework.apps.utils.report;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class AllureReport {

    private static final Logger logger = LogManager.getLogger(AllureReport.class);

    @Attachment(value = "HTML log in table", type = "text/html")
    public static String htmlLogInTableToAllureReport(String text) {
        return text;
    }

    @Attachment(value = "HTML attachments", type = "text/html")
    public static String htmlToAllureReport(String html) {
        return html;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String htmlToAllureReport(String name, String html) {
        return html;
    }

    @Attachment(value = "Text attachments", type = "text/txt")
    public static String textToAllureReport(String text) {
        return text;
    }

    @Attachment(value = "{0}", type = "text/txt")
    public static String textToAllureReport(String name, String text) {
        return text;
    }

    @Step("{0}: {1}")
    public static String textToAllureAsStep(String result, String text) {
        return text;
    }

}
