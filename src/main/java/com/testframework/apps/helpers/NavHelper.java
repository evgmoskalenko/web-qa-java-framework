package com.testframework.apps.helpers;

import com.testframework.apps.wrappers.BaseHelper;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.WebDriverRunner.url;
import static com.testframework.apps.wrappers.BaseTest.getDriver;

public class NavHelper extends BaseHelper<NavHelper> {

    public String getCurrentUrl() {
        return url();
    }

    @Step("Add parameter for current url \"{0}\" and reload page")
    public void addParametrToCurrentUrl(String text) {
        getDriver().get(getCurrentUrl() + text);
    }

}
