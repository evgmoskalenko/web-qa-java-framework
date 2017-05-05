package com.testframework;

import com.testframework.apps.wrappers.BaseTest;
import org.testng.annotations.Test;

public class Example extends BaseTest {

    /**
     * <span class="checkbox__box">
     */

    @Test(priority = 10)
    public void spanCheckboxXpath() {
        examplePage().openPage().getSpanXpath().click();
    }

    @Test(priority = 15)
    public void spanCheckboxXpath_2() {
        examplePage().openPage().getSpanXpath().setSelected(true);
    }

    @Test(priority = 16)
    public void spanCheckboxXpath_3() {
        String xpath = "/html/body/div[1]/div[4]/div[2]/div[2]/div[3]/div/div[4]/div[2]/div/div[1]/div[4]/span/span";

        examplePage().openPage().chooseFilterByCustomXpath(xpath).click();
    }

    @Test(priority = 17)
    public void spanCheckboxXpath_4() {
        String xpath = "/html/body/div[1]/div[4]/div[2]/div[2]/div[3]/div/div[4]/div[2]/div/div[1]/div[4]/span/span";

        examplePage().openPage().chooseFilterByCustomXpath(xpath).setSelected(true);
    }

    /**
     * <input class="checkbox__control" type="checkbox" id="glf-7893318-152809">
     */

    @Test(priority = 20)
    public void inputCheckboxXpath() {
        examplePage().openPage().getInputXpath().click();
    }

    @Test(priority = 25)
    public void inputCheckboxXpath_2() {
        examplePage().openPage().getInputXpath().setSelected(true);
    }

    /**
     * <label class="checkbox__label" for="glf-7893318-152898">Electrolux</label>
     */

    @Test(priority = 30)
    public void labelCheckboxXpath() {
        examplePage().openPage().getLabelXpath().click();
    }

    @Test(enabled = false, priority = 10)
    public void testSpanCheckboxXpath() {
        //examplePage().openPage().chooseFilter(spanXpath, "SPAN: checkbox__box");
        //examplePage().openPage().chooseFilter(inputXpath, "INPUT: checkbox__control");
        //examplePage().openPage().chooseFilter(labelXpath, "LABEL: checkbox__label");
    }

}
