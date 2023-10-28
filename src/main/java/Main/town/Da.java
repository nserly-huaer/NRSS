package Main.town;

import Main.RunMainSoft.scan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;

public class Da {

    public void demo(final OutputStream out,final InputStream in) throws error {
        Logger logger = LogManager.getLogger(Da.class);
        try {
            out.write("-------------------如果是未知量，请写0（零）！！！-------------------\n".getBytes());
            logger.info("如果是未知量，请写0（零）！！！");
            out.write("示例：q : w = e : r".getBytes());
            logger.info("示例：q : w = e : r");
            out.write("\n".getBytes());
            out.flush();

            out.write("请输入上述所示的q:\n".getBytes());
            logger.info("请输入上述所示的q:");
            out.flush();
            String str1 = scan.str(out, in);
            double u = Double.parseDouble(str1);
            logger.info("用户输入:" + u);

            out.write("请输入上述所示的w:\n".getBytes());
            logger.info("请输入上述所示的w:");
            out.flush();
            String str2 = scan.str(out, in);
            double i = Double.parseDouble(str2);
            logger.info("用户输入:" + i);

            out.write("请输入上述所示的e:\n".getBytes());
            logger.info("请输入上述所示的e:");
            out.flush();
            String str3 = scan.str(out, in);
            double o = Double.parseDouble(str3);
            logger.info("用户输入:" + o);

            out.write("请输入上述所示的r:\n".getBytes());
            logger.info("请输入上述所示的r:");
            out.flush();
            String str4 = scan.str(out, in);
            double p = Double.parseDouble(str4);
            logger.info("用户输入:" + p);

            There t = new There();
            try {
                t.cheack(u, i, o, p,out, in);
            } catch (NoNullException e) {
                logger.error(e);
            }

//            a.close();
//            b.close();
//            c.close();
//            d.close();
        } catch (InputMismatchException e) {
            throw new error("Accessing Value has Error!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
