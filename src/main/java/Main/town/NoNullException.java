package Main.town;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.SendForClient;

import java.io.OutputStream;

@SuppressWarnings("serial")
public class NoNullException extends Exception {
    private String ExceptionMessage;

    public NoNullException(String ExceptionMessage, OutputStream out) {
        super(ExceptionMessage);
        SendForClient se = new SendForClient(out);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(NoNullException.class);
        se.LogError("无未知量，请重试");

    }

}
