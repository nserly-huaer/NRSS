package Main.castRun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CannotCastException extends Exception {
    private String ExceptionMessage;

    public CannotCastException(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(set.class);
        logger.error("转换失败，请重试");

    }
}
