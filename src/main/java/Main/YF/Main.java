package Main.YF;


import Main.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    static void Finally(long Starttime,OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(Main.class);
        long Endtime = System.currentTimeMillis();
        logger.info("结束时间：" + Endtime);
        long Charter = Endtime - Starttime;
        logger.info("计算毫秒值：" + Charter);
        out.write(("\n" + "Done!                                      计算总耗时:" + Charter + "ms").getBytes());
        out.flush();
        logger.info("Done!计算总耗时:" + Charter + "ms");
        out.write("\n仅限个人使用，请勿用于商业用途！！！！\n版权所有权、解释权：nserly(恩瑟莉)".getBytes());
        out.flush();
        logger.info("仅限个人使用，请勿用于商业用途！！！！版权所有权、解释权：nserly(恩瑟莉)");
    }

    public static void Run1(OutputStream out, InputStream in) throws IOException {

        try {
            Scan sc = new Scan();
            sc.scan(out, in);

        } catch (Exception e) {
            try {
                throw new error("Input Error");
            } catch (error e1) {
                MainS.centel(e1, true,out, in);
            }
        }
    }

    public static void main(OutputStream out, InputStream in) throws IOException {
        try {
            Run1(out, in);
        } catch (Exception e) {
            MainS.centel(e, true,out, in);
            try {
                Thread.sleep(500);
            } catch (Exception e1) {
                MainS.centel(e, true,out, in);
            }
        }

    }
}
