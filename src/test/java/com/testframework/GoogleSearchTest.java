package com.testframework;

import com.testframework.apps.wrappers.BaseTest;
import com.testframework.pages.landings.GoogleSearchResultsPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Condition.text;

@Features("Searching")
@Stories("Search in google")
public class GoogleSearchTest extends BaseTest {

    @Title("Success test: search in google text 'qa automation framework'")
    @Test(groups = "google_search", priority = 10)
    public void successTest() {
        // --------------------- Test Data ----------------------//
        String searchQuery = "qa automation framework";

        // --------------------- Test Case ----------------------//
        GoogleSearchResultsPage results =
                googleHomePage().openPage().searchFor(searchQuery);

        results.getResults().find(text("Test automation - Wikipedia"));
    }

    @Title("Failure test: search in google text 'qa automation framework'")
    @Test(groups = "google_search", priority = 20)
    public void failureTest() {
        // --------------------- Test Data ----------------------//
        String searchQuery = "qa automation framework";

        // --------------------- Test Case ----------------------//
        GoogleSearchResultsPage results =
                googleHomePage().openPage().searchFor(searchQuery);

        results.getResult(0).shouldHave(text("Test automation - Wikipedia"));
    }

}
