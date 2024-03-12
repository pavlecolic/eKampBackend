package org.unibl.etf.ekamp.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingUtil {

    public static void logException(Throwable e, Log log) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append(System.lineSeparator());
        for(StackTraceElement element : e.getStackTrace()) {
            stringBuilder.append(element);
            stringBuilder.append(System.lineSeparator());
        }
        log.error(stringBuilder);
    }

    public static <T> void logException(Throwable e, Class<T> clazz) {logException(e, LogFactory.getLog(clazz));}
}
