package com.testframework.apps.internal;

import com.testframework.apps.wrappers.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.testframework.apps.utils.report.AllureReport.htmlToAllureReport;
import static com.testframework.apps.utils.report.AllureReport.textToAllureAsStep;
import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public interface Validator {

    Logger logger = LogManager.getLogger(BaseTest.class);

    @Step("Verify characters count in string")
    default void verifyThatStringHasCount(String s, int expectedLength) {
        int actualLength = s.length();
        if (actualLength <= expectedLength) {
            logger.info(format("Current characters: %d, and expected length: %d", actualLength, expectedLength));
        } else {
            throw new ExceptionInInitializerError(
                    format("Current characters: %d, and expected length: %d", actualLength, expectedLength));
        }
    }

    @Step("Verify browser console log entry")
    default void verifyBrowserConsoleLogEntry(List<String> listBrowserConsoleLog) {
        boolean condition = listBrowserConsoleLog.isEmpty();
        if (!condition) {
            htmlToAllureReport("Browser console log entry", String.join("<br><br>", listBrowserConsoleLog));
        }
        assertTrue(condition);
    }

    @Step("Verify that \"{1}\" = \"{0}\"")
    default void verifyTextEquals(final String actual, final String expected, final String message) {
        textToAllureAsStep("Actual", actual);
        textToAllureAsStep("Expected", expected);
        textToAllureAsStep("Message", message);
        assertEquals(actual, expected, message);
    }

    @Step("Verify that \"{1}\" = \"{0}\"")
    default void verifyTextEquals(final String actual, final String expected) {
        textToAllureAsStep("Actual", actual);
        textToAllureAsStep("Expected", expected);
        assertEquals(actual, expected);
    }

    @Step("Verify that \"{0}\" contains \"{1}\"")
    default void verifyTextContains(final String actual, final String containsString) {
        htmlToAllureReport("Actual: "+actual+"<br><br>Contains string: "+containsString);
        assertTrue(actual.contains(containsString));
    }

    @Step("Verify that url \"{0}\" contains \"{1}\"")
    default void verifyUrlContains(final String actual, final String containsString) {
        textToAllureAsStep("Actual", actual);
        textToAllureAsStep("Expected", containsString);
        assertTrue(actual.contains(containsString));
    }

}

