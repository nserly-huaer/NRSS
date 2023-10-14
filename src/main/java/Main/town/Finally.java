package Main.town;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Finally {
    void finallyt(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(Finally.class);
        long starttime = There.starttime;
        logger.info("开始时间" + starttime);
        long endtime = System.currentTimeMillis();
        logger.info("结束时间" + endtime);
        long charter = endtime - starttime;
        logger.info("计算毫秒值：" + charter);
        if (charter > 999) {
            charter = 999;
            out.write(("\n" + "Done!                          计算总耗时:" + charter + "ms（已超标，可能存在异常！）").getBytes());
            logger.info("Done!计算总耗时:" + charter + "ms（已超标，可能存在异常！）");
        } else {
            out.write(("\n" + "Done!                                            计算总耗时:" + charter + "ms").getBytes());
            logger.info("Done!计算总耗时:" + charter + "ms");
        }

        out.write("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)".getBytes());
        logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
    }
}
