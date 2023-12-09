package useful;

import Main.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;

public class SendForClient {
    OutputStream out;
    private static final Logger logger = LogManager.getLogger(SendForClient.class);

    public SendForClient(OutputStream out) {
        this.out = out;
    }

    public void SendLine(String message) {
        String cache = "--messageSender " + message + "\n";
        Sender(cache);
        logger.info(message);
    }

    public void Send(String message) {
        String cache = "--messageSender " + message;
        Sender(cache);
        logger.info(message);
    }

    public void OperatorSend(String message) {
        String cache = "information " + message;
        Sender(cache);
        logger.info("向客户端发送：" + message);
    }

    public void LogInfo(Object message) {
        String cache = "log info" + "-" + message;
        Sender(cache);
        logger.info(message);
    }

    public void LogError(Object message) {
        String cache = "log error" + "-" + message;
        Sender(cache);
        logger.error(message);
    }

    public void LogWarn(Object message) {
        String cache = "log warn" + "-" + message;
        Sender(cache);
        logger.warn(message);
    }

    public void LogDebug(Object message) {
        String cache = "log debug" + "-" + message;
        Send(cache);
        logger.debug(message);
    }

    public void sendDelay(long time) {
        String cache = "delay " + time;
        Sender(cache);
        logger.info("发送给客户端毫秒:" + time);
    }

    public void Sender(Object E) {
        try {
            Thread.sleep(3);
            out.write(E.toString().getBytes());
            out.flush();
        } catch (Exception e) {
            MainS.centel(e, true);
        }
    }

}
