package logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FrameworkLogger {

	public static void log(Object message, FrameworkLogger.LEVEL level, Class<?> cls) {
        Logger logger = Logger.getLogger(cls.getName());
        
        System.setProperty("logfilename", "Test Infinity®-Logs.log");
        PropertyConfigurator.configure(Log4JProperties.getProperties());
        
        
        if(level.toString().equals("trace")) {
            logger.trace(message);
        } else if(level.toString().equals("debug")) {
            logger.debug(message);
        } else if(level.toString().equals("info")) {
            logger.info(message);
        } else if(level.toString().equals("warn")) {
            logger.warn(message);
        } else if(level.toString().equals("error")) {
            logger.error(message);
        } else if(level.toString().equals("fatal")) {
            logger.fatal(message);
        }

    }
	
	 public static enum LEVEL {
	        trace("trace"),
	        debug("debug"),
	        info("info"),
	        warn("warn"),
	        error("error"),
	        fatal("fatal");

	        private final String name;

	        private LEVEL(String str) {
	            this.name = str;
	        }

	        public boolean equalsName(String otherName) {
	            return otherName == null?false:this.name.equals(otherName);
	        }

	        public String toString() {
	            return this.name;
	        }
	    }
}
