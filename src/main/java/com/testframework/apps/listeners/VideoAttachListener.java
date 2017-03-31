package com.testframework.apps.listeners;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.automation.remarks.video.recorder.VideoRecorder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VideoAttachListener extends VideoListener {

    private static final Logger logger = LogManager.getLogger(VideoAttachListener.class);

    @Attachment(value = "Video on failure", type = "video/mp4")
    private byte[] takeVideo() {
        try {
            File video = VideoRecorder.getLastRecording();
            return Files.readAllBytes(Paths.get(video.getAbsolutePath()));
        } catch (IOException e) {
            logger.error("Video attach listener exception" + e);
            return new byte[0];
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (shouldIntercept(result.getTestClass().getRealClass(), this.getClass())) {
            super.onTestFailure(result);
            Video video = result.getMethod().getConstructorOrMethod().getMethod().getDeclaredAnnotation(Video.class);
            if (VideoRecorder.conf().isVideoEnabled())
                takeVideo();
        }
    }

}
