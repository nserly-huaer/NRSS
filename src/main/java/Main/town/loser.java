package Main.town;


import Main.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class loser {
    public static void main(OutputStream out, InputStream in) throws InterruptedException, IOException {
        Logger logger = LogManager.getLogger(loser.class);
        out.write("                此软件会用到“四舍五入”算法，保留14位小数。\n".getBytes());
        logger.info("此软件会用到“四舍五入”算法，保留14位小数。");
        try {
            Da.demo(out, in);

        } catch (error e) {
            MainS.centel(e, true, out, in);
            Thread.sleep(500);
        } catch (ArithmeticException e) {
            MainS.centel(e, true, out, in);
            Thread.sleep(500);
        }

        Finally f = new Finally();
        f.finallyt(out, in);

    }
}
