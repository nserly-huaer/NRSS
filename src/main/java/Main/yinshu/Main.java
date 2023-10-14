package Main.yinshu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public void run_Main(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(Main.class);
        Main.yinshu.Scan s = new Main.yinshu.Scan();
        logger.info("运行-扫描器");
        long l = s._Scan(out, in);
        long begintime = System.currentTimeMillis();
        logger.info("开始时间：" + begintime);
        String cfd = Crate.run(l, begintime);
        System.out.println("结果：" + cfd);
        logger.info("结果:" + cfd);
        long endtime = Crate.endtime;
        long charter = endtime - begintime;
        logger.info("计算毫秒值：" + charter);
        System.err.println("\n" + "Done!                                            运行总耗时:" + charter + "ms");
        logger.info("Done!运行总耗时:" + charter + "ms");

        System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
        logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
    }
}
