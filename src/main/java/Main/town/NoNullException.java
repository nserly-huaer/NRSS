package Main.town;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class NoNullException extends Exception {
    private String ExceptionMessage;

    public NoNullException(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(NoNullException.class);
        logger.error("无未知量，请重试");

    }

}
