package Main.town;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class First implements Test {
    long starttime;

    // 未知量为u
    public void Run(double u, double i, double o, double p, OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(First.class);
        double zz = i * o;
        BigDecimal q = new BigDecimal(zz);
        BigDecimal weer = new BigDecimal(p);
        double qwe = q.divide(weer, 14, RoundingMode.HALF_UP).doubleValue();
        out.write(("结果：值为: \n" + qwe).getBytes());
        logger.info(qwe);

    }

    // 未知量为i
    public void Run2(double u, double i, double o, double p,OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(First.class);
        double zz = u * p;// 这是未知量外的总数
        BigDecimal q = new BigDecimal(zz);// 转换为Big...
        BigDecimal weer = new BigDecimal(o);// 未知量隔壁的数
        double qwe = q.divide(weer, 14, RoundingMode.HALF_UP).doubleValue();
        out.write(("结果：值为: \n" + qwe).getBytes());
        logger.info(qwe);
    }

    // 未知量为o
    public void Run3(double u, double i, double o, double p,OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(First.class);
        double zz = u * p;// 这是未知量外的总数
        BigDecimal q = new BigDecimal(zz);// 转换为Big...
        BigDecimal weer = new BigDecimal(i);// 未知量隔壁的数

        double qwe = q.divide(weer, 14, RoundingMode.HALF_UP).doubleValue();
        out.write(("结果：值为: \n" + qwe).getBytes());
        logger.info(qwe);
    }

    // 未知量为p
    public void Run4(double u, double i, double o, double p,OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(First.class);
        double zz = i * o;// 这是未知量外的总数
        BigDecimal q = new BigDecimal(zz);// 转换为Big...
        BigDecimal weer = new BigDecimal(u);// 未知量隔壁的数

        double qwe = q.divide(weer, 14, RoundingMode.HALF_UP).doubleValue();
        out.write(("结果：值为: \n" + qwe).getBytes());
        logger.info(qwe);
    }

}
