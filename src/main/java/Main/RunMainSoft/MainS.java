package Main.RunMainSoft;

import Main.fileRun.CannotFindException;
import Main.fileRun.Read;
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
    public static boolean isGoing;
    public static boolean GotoMath;
    public static boolean GotoFileWatch;

    public static boolean usetwoyinshu(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(MainS.class);
        logger.info("用户控制：运行-多数公因数求解器");
//        out.write("-------------------声明：此程序处于测试阶段，有误差（误差不大），预计于2023/10/2正式发布-------------------");
        try {
            ExampleClass.Example(in, out);

        } catch (ZeroNumberException | OnlyOneNumberException e) {
            centel(e, true, out, in);
            return false;
        }

        return true;
    }

    public static boolean Maths_C(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(MainS.class);
        boolean result = false;
        try {
            GotoMath = true;
            GotoFileWatch = false;
            logger.info("用户控制：运行-数学工具");
            result = MathsC.Main(out, in);
        } catch (Exception e) {
            centel(e, true, out, in);
            return false;
        }
        return result;
    }

    public static boolean townd(final OutputStream out, final InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(MainS.class);
        try {
            logger.info("用户控制：运行-比例求比器");
            Main.town.loser.main(out, in);
        } catch (Exception e) {
            centel(e, true, out, in);
            return false;
        }
        return true;
    }

    public static boolean YFd(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(MainS.class);
        try {
            logger.info("用户控制：运行-查看是否成比例");
            Main.YF.Main.main(out, in);
        } catch (Exception e) {
            centel(e, true, out, in);

            return false;
        }
        return true;
    }

    public static boolean gamed(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(MainS.class);
        try {
            logger.info("用户控制：运行-猜数字”");
            Main.game.Main.main(out, in);
        } catch (Exception e) {
            centel(e, true, out, in);
            return false;
        }
        return true;
    }

    public static boolean fileRund(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(MainS.class);
        Read r = new Read();
        int SP = 0;
        try {
            logger.info("用户控制：运行-文件管理");
            out.write("请继续输入;1.读取文件内容;2.写入文件内容;3.查看文件属性 =-=输入back返回=-=".getBytes());
            out.flush();
            logger.info("软件：1.读取文件内容;2.写入文件内容;3.查看文件属性");
            GotoMath = false;
            GotoFileWatch = true;
            String ST1 = scan.str(out, in);
            logger.info("用户输入：" + ST1);
            ST1 = ST1.toLowerCase();
            if (ST1.equals("back")) {
                GotoFileWatch = false;
                isGoing = true;
                logger.info("用户控制：返回上一步");

                out.write("\n".getBytes());
                out.flush();
                Run r1 = new Run();
                r1.d(out, in);
                return true;
            } else if (ST1.equals("$exit")) {
                out.write("已退出".getBytes());
                out.flush();
                logger.info("用户控制：关闭程序");
                logger.info("已退出");
                Run.end = true;
                return false;
            }
            @SuppressWarnings("removal") Integer it = new Integer(ST1);
            int ST = it.intValue();
            out.write("请输入文件路径".getBytes());
            out.flush();
            logger.info("控制台提示：请输入文件路径");
            String str = scan.str(out, in);
            String str2 = str.trim();
            logger.info("文件路径为：" + str2);
            if (!(str2.endsWith("\"") && str2.startsWith("\""))) {
                logger.warn("未在路径首尾加\"，可能出现异常!");
            }
            String str1 = str2.replace("\"", "");
            r.Start(ST, str1, 1, out, in);
        } catch (Exception e) {
            centel(e, true, out, in);
            return false;
        }
//        s1.close();
        return true;
    }

    public static boolean castRund(OutputStream out, InputStream in) throws IOException {
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
            centel(e, true, out, in);
            return false;
        }
        return true;

    }

    public static void error(OutputStream out, InputStream in) throws IOException {
        try {
            throw new CannotFindException(1, "It's not right list!");
        } catch (Exception e) {
            centel(e, true, out, in);
        }
    }

    public static void centel(Exception e, boolean isInputIntoConsole, OutputStream out, InputStream in) throws IOException {
        StringBuilder sbException = new StringBuilder();
        for (StackTraceElement ele : e.getStackTrace()) {
            sbException.append(MessageFormat.format("\tat {0}.{1}({2}:{3})\n", ele.getClassName(), ele.getMethodName(), ele.getFileName(), ele.getLineNumber()));
        }


        Main.Log4j2Pro.Main l = new Main.Log4j2Pro.Main();
        l.Wrin(e.getClass().getName() + ": " + e.getMessage(), sbException, out, in);
        if (isInputIntoConsole) {
            out.write((e.getClass().getName() + ": " + e.getMessage()).getBytes());
            out.write(sbException.toString().getBytes());
            out.flush();
        }
    }

    public static boolean yin_shu(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(MainS.class);
        try {
//            out.write("-------------------声明：此程序处于测试阶段，可能出现问题，预计于2023/9/5正式发布-------------------");
            logger.info("用户控制：运行-因数求解器”");
            Main.yinshu.Main m = new Main.yinshu.Main();
            m.run_Main(out, in);
        } catch (Exception e) {
            centel(e, true, out, in);
            return false;
        }
        return true;
    }
}
