package Main.usetwoyinshu_api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.SendForClient;

import java.io.OutputStream;

public class OnlyOneNumberException extends Exception {
    //异常信息
    private final String ExceptionMessage;

    public OnlyOneNumberException(String ExceptionMessage) {
        super(ExceptionMessage);
        Logger logger = LogManager.getLogger(ExampleClass.class);
        this.ExceptionMessage = ExceptionMessage;
        logger.error("输入异常：子因数为1，请重试！");
    }
}
