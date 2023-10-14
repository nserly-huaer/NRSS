package Main.YF;

import Main.RunMainSoft.scan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Scan {
    void scan(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(Scan.class);
        out.write("示例：第一行的1、2，第二行的3、4".getBytes());
        logger.info("示例：第一行的1、2，第二行的3、4");

        Scanner a = new Scanner(System.in);
        out.write("请输入第一行第一个值(1)：".getBytes());
        logger.info("请输入第一行第一个值(1)：");
        String str1 = scan.str(out, in);
        double q = Double.parseDouble(str1);
        logger.info("用户输入:" + q);

        Scanner b = new Scanner(System.in);
        out.write("请输入第一行第二个值(2)：".getBytes());
        logger.info("请输入第一行第二个值(2)：");
        String str2 = scan.str(out, in);
        double w = Double.parseDouble(str2);
        logger.info("用户输入:" + w);

        Scanner c = new Scanner(System.in);
        out.write("请输入第二行第一个值(3)：".getBytes());
        logger.info("请输入第二行第一个值(3)：");
        String str3 = scan.str(out, in);
        double e = Double.parseDouble(str3);
        logger.info("用户输入:" + e);

        Scanner d = new Scanner(System.in);
        out.write("请输入第二行第二个值(4)：".getBytes());
        logger.info("请输入第二行第二个值(4)：");
        String str4 = scan.str(out, in);
        double r = Double.parseDouble(str4);
        logger.info("用户输入:" + r);

        Scan s = new Scan();
        long Starttime = System.currentTimeMillis();
        logger.info("开始时间：" + Starttime);
        s.Try(q, w, e, r, Starttime, out, in);
//        a.close();
//        b.close();
//        c.close();
//        d.close();
    }

    void Try(double q, double w, double e, double r, long Starttime, OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(Scan.class);
        if (Starttime == 0) {
            logger.error("时间获取失败，请与系统管理员联系");
        }
        double qq1 = q * r;
        double qq2 = w * e;
        double er = q * w;
        double err = e * r;

        boolean b1 = er == err;//反比例
        boolean b2 = qq1 == qq2;//正比例
        boolean bv = (qq1 == qq2) && (er == err);//反比例、正比例

        if (bv) {
            out.write("结果：成正比例、反比例！".getBytes());
            logger.info("结果：成正比例、反比例！");
        } else if (b2) {
            out.write("结果：成正比例！".getBytes());
            logger.info("结果：成正比例！");

        } else if (b1) {
            out.write("结果：成反比例！".getBytes());
            logger.info("结果：成反比例！");
        } else {
            out.write("结果：不成比例！".getBytes());
            logger.info("结果：不成比例！");
        }
        Main.Finally(Starttime, out, in);
    }
}
