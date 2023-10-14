package Main.usetwoyinshu_api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZeroNumberException extends Exception {
    private String ExceptionMessage;

    public ZeroNumberException(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(TwoThread.class);
    }
}
