package com.testframework.apps.internal;

import com.testframework.apps.wrappers.BasePage;
import com.testframework.pages.landings.ExamplePage;
import com.testframework.pages.landings.GoogleHomePage;
import com.testframework.pages.landings.GoogleSearchResultsPage;

import static com.testframework.apps.internal.GenericPage.getPageObject;
import static com.testframework.apps.internal.PageObjectsSupplier.PageObject.*;

public interface PageObjectsSupplier<T extends PageObjectsSupplier<T>> {

//    @Step("Navigate to URL: {0}")
//    default T loadUrl(final String url) {
//        open(url);
//        //navigateTo(url);
//        return (T) this;
//    }

    enum PageObject implements GenericPage {

        EXAMPLE_PAGE {
            public BasePage create() {
                return new ExamplePage();
            }
        },

        GOOGLE_HOME_PAGE {
            public BasePage create() {
                return new GoogleHomePage();
            }
        },
        GOOGLE_SEARCH_RESULTS_PAGE {
            public BasePage create() {
                return new GoogleSearchResultsPage();
            }
        };

    }

    default ExamplePage examplePage() {
        return (ExamplePage) getPageObject(EXAMPLE_PAGE);
    }

    default GoogleHomePage googleHomePage() {
        return (GoogleHomePage) getPageObject(GOOGLE_HOME_PAGE);
    }

    default GoogleSearchResultsPage googleSearchResultsPage() {
        return (GoogleSearchResultsPage) getPageObject(GOOGLE_SEARCH_RESULTS_PAGE);
    }

}
