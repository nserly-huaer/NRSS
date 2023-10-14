package Main.castRun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings("serial")
public class ZeroException extends Exception {
    private String ExceptionMessage;

    public ZeroException(int i, String ExceptionMessage, OutputStream out, InputStream in) throws IOException {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Main.class);
        if (i == 1) {
            out.write("输入的除数带有0，请重试！".getBytes());
        } else if (i == 2) {
            out.write("将数转换最简直时错误，请与开发者联系".getBytes());
        } else {
            out.write("错误代码无效".getBytes());
        }
    }
}
