package com.testframework.pages.landings;

import com.codeborne.selenide.SelenideElement;
import com.testframework.apps.wrappers.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ExamplePage extends BasePage<ExamplePage> {

    private static final Logger logger = LogManager.getLogger(ExamplePage.class);

    @Override
    protected String getUrl() {
        return "https://market.yandex.ru/catalog/54913/list?hid=90566&lr=213&local-offers-first=0&deliveryincluded=0&onstock=1";
    }

    //<span class="checkbox__box">
    public SelenideElement getSpanXpath() {
     return $(byXpath("//div[@class='n-filter-panel-aside__content']/div[4]//span[@class='checkbox__box']"));
    }

    //<input class="checkbox__control" type="checkbox" id="glf-7893318-152809">
    public SelenideElement getInputXpath() {
        return $(byXpath("//div[@class='n-filter-panel-aside__content']/div[4]//span[@class='checkbox__box']/input"));
    }

    //<label class="checkbox__label" for="glf-7893318-152898">Electrolux</label>
    public SelenideElement getLabelXpath() {
        return $(byXpath("//div[@class='n-filter-panel-aside__content']/div[4]//label[@class='checkbox__label']"));
    }

    public SelenideElement chooseFilterByCustomXpath(String xpathValue) {
        return $(byXpath(xpathValue));
    }

}
