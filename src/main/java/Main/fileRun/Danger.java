package Main.fileRun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class Danger extends Exception {
    private String ExceptionMessage;

    public Danger(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Read.class);
        logger.error("执行失败，可能此文件为只读、无权写入文件，请重试！");

    }
}