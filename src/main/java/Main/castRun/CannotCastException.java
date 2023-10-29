package Main.castRun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.SendForClient;

import java.io.OutputStream;

public class CannotCastException extends Exception {
    private String ExceptionMessage;

    public CannotCastException(String ExceptionMessage, OutputStream out) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        SendForClient se = new SendForClient(out);
        se.LogError("转换失败，请重试");

    }
}
