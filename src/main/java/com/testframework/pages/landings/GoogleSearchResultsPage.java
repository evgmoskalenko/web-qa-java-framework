package com.testframework.pages.landings;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.testframework.apps.wrappers.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchResultsPage extends BasePage<GoogleSearchResultsPage> {

    @Override
    public String getUrl() {
        return null;
    }

    @Step("Get results")
    public ElementsCollection getResults() {
        return $$("#ires .g");
    }

    @Step("Get result by index '{0}'")
    public SelenideElement getResult(int index) {
        return $("#ires .g", index);
    }

}
