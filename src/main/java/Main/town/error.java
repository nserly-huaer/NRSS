package Main.town;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class error extends Exception {
    private String ExceptionMessage;

    public error(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Da.class);
        logger.error("输入非有效值，请重试！");

    }

}
