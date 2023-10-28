package Main.RunMainSoft;

import Main.RunMainSoft.CannotFindException;
import Main.usetwoyinshu_api.ExampleClass;
import Main.usetwoyinshu_api.OnlyOneNumberException;
import Main.usetwoyinshu_api.ZeroNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import FileStart.Run;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;

public class MainS {

    private OutputStream out;


    public boolean usetwoyinshu(OutputStream out, InputStream in) throws IOException {
        this.out = out;
        Logger logger = LogManager.getLogger(MainS.class);
        logger.info("用户控制：运行-多数公因数求解器");
//        out.write("-------------------声明：此程序处于测试阶段，有误差（误差不大），预计于2023/10/2正式发布-------------------");
        try {
            ExampleClass e = new ExampleClass();
            e.Example(in, out);

        } catch (ZeroNumberException | OnlyOneNumberException e) {
            centel(e, true, out);
            return false;
        }

        return true;
    }

    public boolean Maths_C(OutputStream out, InputStream in) throws IOException {
        this.out = out;
        Logger logger = LogManager.getLogger(MainS.class);
        boolean result = false;
        try {
            Run r = new Run();
            r.setGotoMath(true);
            logger.info("用户控制：运行-数学工具");
            result = MathsC.Main(out, in);
        } catch (Exception e) {
            centel(e, true, out);
            return false;
        }
        return result;
    }

    public boolean townd(final OutputStream out, final InputStream in) throws IOException {
        this.out = out;
        Logger logger = LogManager.getLogger(MainS.class);
        try {
            logger.info("用户控制：运行-比例求比器");
            Main.town.loser m = new Main.town.loser();
            m.main(out, in);
        } catch (Exception e) {
            centel(e, true, out);
            return false;
        }
        return true;
    }

    public boolean YFd(OutputStream out, InputStream in) throws IOException {
        this.out = out;
        Logger logger = LogManager.getLogger(MainS.class);
        try {
            logger.info("用户控制：运行-查看是否成比例");
            Main.YF.Main m = new Main.YF.Main();
            m.main(out, in);
        } catch (Exception e) {
            centel(e, true, out);

            return false;
        }
        return true;
    }

    public boolean gamed(OutputStream out, InputStream in) throws IOException {
        this.out = out;
        Logger logger = LogManager.getLogger(MainS.class);
        try {
            logger.info("用户控制：运行-猜数字”");
            Main.game.Main ma = new Main.game.Main();
            ma.main(out, in);
        } catch (Exception e) {
            centel(e, true, out);
            return false;
        }
        return true;
    }

    public boolean castRund(OutputStream out, InputStream in) throws IOException {
        this.out = out;
        Logger logger = LogManager.getLogger(MainS.class);
        try {
            logger.info("用户控制：运行-简化器");
            Main.castRun.set cm = new Main.castRun.set();
//            out.write("-------------------免费声明：此程序处于测试阶段，有误差（误差不大），预计于2023/8/1正式发布-------------------");
            cm.runfirst(out, in);
            String end = "------------------------------结果： " + (long) Main.castRun.set.bcs + ":" + (long) Main.castRun.set.cs + "------------------------------";
            String end1 = end.replace('-', '\s');
            end1 = end1.trim();
            out.write(end.getBytes());
            out.flush();
            logger.info(end1);
            out.write(("\n\n" + "Done!                                            运行总耗时:" + Main.castRun.set.chartertime + "ms").getBytes());
            out.flush();
            logger.info("Done!运行总耗时:" + Main.castRun.set.chartertime + "ms");
            out.write("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)".getBytes());
            out.flush();
            logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
        } catch (Exception e) {
            centel(e, true, out);
            return false;
        }
        return true;

    }

    public static void error(OutputStream out, InputStream in) throws IOException {
        try {
            throw new CannotFindException("It's not right list!");
        } catch (Exception e) {
            centel(e, true, out);
        }
    }

    public static void centel(Exception e, boolean isInputIntoConsole, OutputStream out) throws IOException {
        StringBuilder sbException = new StringBuilder();
        for (StackTraceElement ele : e.getStackTrace()) {
            sbException.append(MessageFormat.format("\tat {0}.{1}({2}:{3})\n", ele.getClassName(), ele.getMethodName(), ele.getFileName(), ele.getLineNumber()));
        }


        Main.Log4j2Pro.Main l = new Main.Log4j2Pro.Main();
        l.Wrin(e.getClass().getName() + ": " + e.getMessage(), sbException, out);
        if (isInputIntoConsole) {
            out.write((e.getClass().getName() + ": " + e.getMessage()).getBytes());
            out.write(sbException.toString().getBytes());
            out.flush();
        }
    }

    public boolean yin_shu(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(MainS.class);
        try {
//            out.write("-------------------声明：此程序处于测试阶段，可能出现问题，预计于2023/9/5正式发布-------------------");
            logger.info("用户控制：运行-因数求解器”");
            Main.yinshu.Main m = new Main.yinshu.Main();
            m.run_Main(out, in);
        } catch (Exception e) {
            centel(e, true, out);
            return false;
        }
        return true;
    }
}
