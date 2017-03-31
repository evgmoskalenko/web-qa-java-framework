package com.testframework.apps;

public class Constants {

    /*****
     * Global config
     *****/
    public static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    public static final String DS = System.getProperty("file.separator");
    public static final String MAIN_RESOURCES = CURRENT_DIRECTORY+DS+"src"+DS+"main"+DS+"resources";
    public static final String TEST_RESOURCES = CURRENT_DIRECTORY+DS+"src"+DS+"test"+DS+"resources";
    public static final String DIRECTORY_TEST_FILE = TEST_RESOURCES+DS+"files"+DS;
    public static final String LOGS_DIRECTORY = CURRENT_DIRECTORY+DS+"logs"+DS;
    public static final String SCREENSHOT_DIRECTORY = CURRENT_DIRECTORY+DS+"target"+DS+"screenshots";

    public static final String TEST_MAIL_SERVICE = "@mailinator.com";

}
