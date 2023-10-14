package Main.castRun;


import Main.RunMainSoft.MainS;
import Main.RunMainSoft.scan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class set {
    // 被除数
    public static double bcs;
    // 除数
    public static double cs;
    // 时间差，用来记录用时时长
    public static long chartertime;
    // 乘以个数，数字越大支持越大小数，同时计算速度将减少
    static long charter = 10000000000L;

    public void runfirst(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(set.class);
        set m = new set();
        boolean sc = m.scan(out, in);
        if (sc) {
            long begintime = System.currentTimeMillis();
            logger.info("获取开始时间:" + begintime);
            try {
                logger.info("运行-转换器");
                m.cast(set.bcs, set.cs, begintime, out, in);
            } catch (ZeroException e) {
                logger.error(e);
            }
        } else {
            try {
                throw new ZeroException(1, "Number has Zero!", out, in);
            } catch (ZeroException e) {
                logger.error(e);
            }
        }
    }

    public boolean scan(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(set.class);
        out.write("请输入被除数".getBytes());
        out.flush();
        logger.info("请输入被除数");
        double bcs = Double.parseDouble(scan.str(out, in));// 被除数
        logger.info("用户输入:" + bcs);
        out.write("请输入除数".getBytes());
        out.flush();
        logger.info("请输入除数");
        double cs = Double.parseDouble(scan.str(out, in));// 除数
        logger.info("用户输入:" + cs);
        set.bcs = bcs;
        set.cs = cs;
        if (cs != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void cast(double bcs, double cs, long begintime, OutputStream out, InputStream in) throws ZeroException, IOException {
        Logger logger = LogManager.getLogger(set.class);
        double bcs123 = bcs * set.charter;
        double cs123 = cs * set.charter;
        set m = new set();
        logger.info("运行-转最简比例器");
        if (!m.Calaurtor((long) bcs123, (long) cs123, begintime, out, in)) {
            throw new ZeroException(2, "Casted Number Error!", out, in);
        }
    }

    public boolean Calaurtor(long bcs123, long cs123, long begintime, OutputStream out, InputStream in) throws IOException {// 转换最简比例
        Logger logger = LogManager.getLogger(set.class);
        // 质数，越多准确性越大，但同时计算量也将越大
//        int think[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
//                97};
        try {
            a:
            for (int i = 2; i <= MAX.min(bcs123, cs123); i++) {
                b:
                for (; ; ) {
                    if (bcs123 == cs123) {
                        bcs123 = 1;
                        cs123 = 1;
                        break a;
                    } else if ((bcs123 % i == 0) && (cs123 % i == 0)) {
                        bcs123 = bcs123 / i;//
                        cs123 = cs123 / i;//
                    } else {
                        break b;
                    }
                }
            }
        } catch (Exception e) {
            MainS.centel(e, false, out, in);
            return false;
        }
        set.bcs = bcs123;
        set.cs = cs123;
        long endtime = System.currentTimeMillis();
        logger.info("结束时间:" + endtime);
        long chartertime = endtime - begintime;
        logger.info("毫秒值：" + chartertime);
        set.chartertime = chartertime;
        return true;
    }
}
