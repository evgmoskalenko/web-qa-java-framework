package com.testframework.pages.landings;

import com.testframework.apps.wrappers.BasePage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.testframework.apps.utils.properties.SystemProperty.BASE_URL;

public class GoogleHomePage extends BasePage<GoogleHomePage> {

    @Override
    protected String getUrl() {
        return BASE_URL.getValue();
    }

    @Step("Search '{0}'")
    public GoogleSearchResultsPage searchFor(String text) {
        $(By.name("q")).val(text).pressEnter();
        return googleSearchResultsPage();
    }

}
