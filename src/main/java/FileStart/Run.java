package FileStart;

import Main.RunMainSoft.MainS;
import Main.RunMainSoft.scan;
import Main.versiontext.Operator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Run {
    public static boolean end;

    public void run(OutputStream out, InputStream in) throws IOException {
        out.write("                                  <输入$Exit退出>\n".getBytes());
        out.flush();
        // org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Default.class);
        while (true) {
            boolean ad = d(out, in);
        }
    }

    public boolean d(final OutputStream out,final InputStream in) throws IOException {
        boolean dd = false;
        Logger logger = LogManager.getLogger(Run.class);
        String SP1;
        out.write("\n-----------软件七合一(软件所有权归nserly所有，未经允许，禁止复制、摘用!)-----------\n".getBytes());
        logger.info("-----------软件七合一(软件所有权：nserly;未经允许，禁止复制!)-----------");
        out.flush();
//        System.out.println("-----------------------------输入$Exit退出-----------------------------");
//        logger.info("输入$Exit退出");
        if (MainS.GotoMath) {
            dd = MainS.Maths_C(out, in);
            return true;
        } else if (MainS.GotoFileWatch) {
            dd = MainS.fileRund(out, in);
            return true;
        }
        out.write("请输入你要运行的软件(1.数学工具;2.文件管理;3.猜数字（游戏）)\n".getBytes());
        logger.info("软件：1.数学工具;2.文件管理;3.猜数字");
        out.flush();
        SP1 = scan.str(out, in);
        int SP = 0;
        Integer SP2 = null;
        SP1 = SP1.toLowerCase();
        logger.info("用户输入：" + SP1);
        if (SP1.equals("$exit")) {
            logger.info("用户控制：关闭程序");
            out.write("已退出".getBytes());
            logger.info("已退出");
            return false;
        } else if (SP1.equals("version")) {
            logger.info("用户控制：读取版本号");
            Operator op = new Operator();
            String[] version = op.version(out, in);
//            System.out.println(version);
            for (String s : version) {
                out.write(s.getBytes());
            }
            out.flush();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                MainS.centel(e, true, out, in);
            }
            return true;
        } else {
            try {
                MainS.isGoing = false;
                SP2 = Integer.valueOf(SP1);
                SP = SP2.intValue();
            } catch (Exception e) {
                MainS.centel(e, true, out, in);
                return true;
            }

            //switch表达式
            switch (SP) {
                case 1 -> dd = MainS.Maths_C(out, in);
                case 2 -> dd = MainS.fileRund(out, in);
                case 3 -> dd = MainS.gamed(out, in);
                default -> MainS.error(out, in);

            }

        }
        if (!dd) {
            out.write("运行中触发异常，请与开发者联系！\n".getBytes());
            out.flush();
            return true;
        }
        return true;
    }
}
