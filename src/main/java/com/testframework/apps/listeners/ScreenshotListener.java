package com.testframework.apps.listeners;

import com.testframework.apps.Constants;
import com.testframework.apps.utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.testframework.apps.wrappers.BaseTest.getDriver;

public class ScreenshotListener extends TestListenerAdapter {

    private static final Logger logger = LogManager.getLogger(ScreenshotListener.class);

    private boolean createFile(File screenshot) {
        boolean fileCreated = false;

        if (screenshot.exists()) {
            fileCreated = true;
        } else {
            File parentDirectory = new File(screenshot.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdirs()) {
                try {
                    fileCreated = screenshot.createNewFile();
                } catch (IOException errorCreatingScreenshot) {
                    errorCreatingScreenshot.printStackTrace();
                }
            }
        }

        return fileCreated;
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    private byte[] writeScreenshotToFile(WebDriver driver, File screenshot) {
        try {
            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
            byte[] bytes = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            screenshotStream.write(bytes);
            screenshotStream.close();
            return bytes;
        } catch (IOException unableToWriteScreenshot) {
            logger.error("Unable to write " + screenshot.getAbsolutePath());
            unableToWriteScreenshot.printStackTrace();
        }
        return null;
    }

    private void takeScreenshot(String testName) throws Exception {
        WebDriver driver = getDriver();
        String screenshotDirectory = Constants.SCREENSHOT_DIRECTORY;
        String screenshotAbsolutePath = screenshotDirectory + File.separator
                + DateUtils.getDate("dd-MM-yyyy_HH-mm-sss") + "_" + testName + ".png";
        File screenshot = new File(screenshotAbsolutePath);
        if (createFile(screenshot)) {
            try {
                writeScreenshotToFile(getDriver(), screenshot);
            } catch (ClassCastException weNeedToAugmentOurDriverObject) {
                writeScreenshotToFile(new Augmenter().augment(driver),
                        screenshot);
            }
            logger.info("Written screenshot to " + screenshotAbsolutePath);
        } else {
            logger.error("Unable to create " + screenshotAbsolutePath);
        }
    }

    @Override
    public void onTestFailure(ITestResult failingTest) {
        try {
            takeScreenshot(failingTest.getName());
        } catch (Exception e) {
            logger.error("Unable to take screenshot - " + e.getMessage());
        }
    }

}
