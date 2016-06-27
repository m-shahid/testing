package logger;

import java.util.Properties;


public class Log4JProperties {
    public Log4JProperties() {
    }

    public static Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("log4j.rootLogger", "DEBUG, FRAMEWORKLOG, file");
        props.setProperty("log4j.appender.FRAMEWORKLOG", "org.apache.log4j.ConsoleAppender");
        props.setProperty("log4j.appender.FRAMEWORKLOG.layout", "org.apache.log4j.PatternLayout");
        props.setProperty("log4j.appender.FRAMEWORKLOG.Threshold", "DEBUG");
        props.setProperty("log4j.appender.FRAMEWORKLOG.layout.ConversionPattern", "%d{dd MMM, yyyy HH:mm:ss z} - %-5p - Test Infinity® LOG : %m%n");
        props.setProperty("log4j.appender.file", "org.apache.log4j.RollingFileAppender");
        props.setProperty("log4j.appender.file.File", "./logs/${logfilename}");
        props.setProperty("log4j.appender.file.MaxFileSize", "10MB");
        props.setProperty("log4j.appender.file.MaxBackupIndex", "10");
        props.setProperty("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
        props.setProperty("log4j.appender.file.layout.ConversionPattern", "%d{dd MMM, yyyy HH:mm:ss z} - %-5p - LOG : %m%n");
        props.setProperty("log4j.appender.file.Threshold", "DEBUG");
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
        return props;
    }
}
