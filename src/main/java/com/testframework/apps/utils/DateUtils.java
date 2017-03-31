package com.testframework.apps.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final Logger logger = LogManager.getLogger(DateUtils.class);

    /**
     * DateUtils and Time Pattern:
     * "yyyy.MM.dd G 'at' HH:mm:ss z"  | 2001.07.04 AD at 12:08:56 PDT
     * "EEE, MMM d, ''yy"              | Wed, Jul 4, '01
     * "h:mm a"	                       | 12:08 PM
     * "hh 'o''clock' a, zzzz"	       | 12 o'clock PM, Pacific Daylight Time
     * "K:mm a, z"	                   | 0:08 PM, PDT
     * "yyyyy.MMMMM.dd GGG hh:mm aaa"  | 02001.July.04 AD 12:08 PM
     * "EEE, d MMM yyyy HH:mm:ss Z"    | Wed, 4 Jul 2001 12:08:56 -0700
     * "yyMMddHHmmssZ"                 | 010704120856-0700
     * "yyyy-MM-dd'T'HH:mm:ss.SSSZ"    | 2001-07-04T12:08:56.235-0700
     * "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"  | 2001-07-04T12:08:56.235-07:00
     * "YYYY-'W'ww-u"                  | 2001-W27-3
     *
     * @param format: default format - "MMM dd, yyyy - hh:mm:ss a"
     * @return
     */
    public static String getDate(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDate() {
        return getDate("MMM dd, yyyy - hh:mm:ss a");
    }

}
