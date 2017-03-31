package com.testframework.apps.wrappers;

import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.codeborne.selenide.WebDriverRunner;
import com.testframework.apps.internal.GenericHelper;
import com.testframework.apps.internal.GenericPage;
import com.testframework.apps.internal.TestCase;
import com.testframework.apps.listeners.*;
import com.testframework.apps.utils.report.AllurePropertiesUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static java.lang.String.format;
import static org.apache.commons.collections.MapUtils.isEmpty;

@Listeners({ScreenshotListener.class, TestListener.class})
public abstract class BaseTest implements TestCase {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    private static AtomicInteger testsCounter = new AtomicInteger(0);

    public static String userAgent;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        addListener(new EventListener());
        addListener(new Highlighter());
//        configureVideoRecorder(false);
    }

    /**
     * The method which configure video recorder for failure tests
     * Listeners: VideoAttachListener.class
     * @param recorderCondition - Switch status recorder: ON (true) / OFF (false)
     */
    private void configureVideoRecorder(boolean recorderCondition) {
        VideoRecorder.conf().withVideoFolder("target/video")
                .videoEnabled(recorderCondition)
                .withRecordMode(RecordingMode.ANNOTATED)
                .withVideoSaveMode(VideoSaveMode.FAILED_ONLY)
                .withFrameRate(1);
    }

    /**
     * The methods which configure the browser once a test runs
     *  - Maximises browser based on the driver type
     *  - Initialises screenshot capture if needed
     *  - Clears the session if another test ran prior
     *  - Sets the user agent of the browser
     *
     * @param testMethod - The test method name of the test
     */
    @BeforeMethod(alwaysRun = true)
    public static void configureBrowserBeforeTest(Method testMethod) {
        try {
            configureDriverBasedOnParams();
            logExecutionOrder(testMethod);
            setUserAgent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ran as part of the initialiseDriver, configures parts of the driver
     */
    private static void configureDriverBasedOnParams() {
        getDriver().manage().window().maximize();
    }

    /**
     * Method which adds for log sequence test number and test method name
     * @param method - The test method name of the test
     */
    private static void logExecutionOrder(final Method method) {
        logger.info(format("Executing test #%d: {%s.%s}", testsCounter.incrementAndGet(),
                           method.getDeclaringClass().getSimpleName(), method.getName()));
    }

    /**
     * Sets the user agent of the browser for the test run
     */
    private static void setUserAgent() {
        userAgent = getUserAgent();
    }

    /**
     * Retrieves the user agent from the browser
     * @return - String of the user agent
     */
    private static String getUserAgent() {
        String ua;
        try {
            ua = executeJavaScript("return navigator.userAgent;");
        } catch (Exception e) {
            ua = "Unable to fetch UserAgent";
        }
        logger.debug("User agent is: '" + ua + "'");
        return ua;
    }

    /**
     * Returns the webdriver object for that given thread
     * @return - WebDriver object
     */
    public static WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }

    /**
     * Thread-safe container in which are stored values as page instances
     */
    private static final ThreadLocal<Map<GenericPage, BasePage>> PAGES =
            new ThreadLocal<Map<GenericPage, BasePage>>() {
                public Map<GenericPage, BasePage> initialValue() {
                    return new HashMap<>();
                }
            };

    public static Map<GenericPage, BasePage> getPages() {
        return PAGES.get();
    }

    /**
     * Thread-safe container in which are stored values as helper instances
     */
    private static final ThreadLocal<Map<GenericHelper, BaseHelper>> HELPERS =
            new ThreadLocal<Map<GenericHelper, BaseHelper>>() {
                public Map<GenericHelper, BaseHelper> initialValue() {
                    return new HashMap<>();
                }
            };

    public static Map<GenericHelper, BaseHelper> getHelpers() {
        return HELPERS.get();
    }

    /**
     * Cleaning collection Pages
     */
    private void cleanUpPages() {
        if (!isEmpty(getPages())) {
            PAGES.remove();
        }
    }

    /**
     * Cleaning collection Helpers
     */
    private void cleanUpHelpers() {
        if (!isEmpty(getHelpers())) {
            HELPERS.remove();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        cleanUpPages();
        cleanUpHelpers();
    }

    /**
     * Creates the allure properties for the report, after the test run
     */
    @AfterSuite(alwaysRun = true)
    public static void createAllureProperties() {
        AllurePropertiesUtil.create();
    }

}



