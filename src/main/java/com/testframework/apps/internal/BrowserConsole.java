package com.testframework.apps.internal;

import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static org.openqa.selenium.logging.LogType.BROWSER;

public interface BrowserConsole {

    /**
     * Returns string list with browser console log
     * @return List<String> without duplicates
     */
    default List<String> getListBrowserConsoleLog() {
        return getWebDriverLogs(BROWSER, Level.ALL)
                .parallelStream().distinct().collect(Collectors.toList());
    }

}
