package Main.castRun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings("serial")
public class ZeroException extends Exception {
    private String ExceptionMessage;

    public ZeroException(int i, String ExceptionMessage, OutputStream out, InputStream in) throws IOException {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        SendForClient se = new SendForClient(out);
        if (i == 1) {
            se.LogError("输入的除数带有0，请重试！");
        } else if (i == 2) {
            se.LogError("将数转换最简直时错误，请与开发者联系");
        } else {
            se.LogError("错误代码无效");
        }
    }
}
