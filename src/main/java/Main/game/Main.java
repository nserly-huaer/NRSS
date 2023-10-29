package Main.game;

import Main.RunMainSoft.scan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class Main {// 声明类

    // 创建main()方法
    public void main(OutputStream out, InputStream in) throws IOException {
        // 用main()静态方法调用start()静态方法
        start(out, in);
    }

    public void start(OutputStream out, InputStream in) throws IOException {
        SendForClient se = new SendForClient(out);
        Logger logger = LogManager.getLogger(Main.class);
        // 获取开始前的时间值
        long beingtime = System.currentTimeMillis();
        logger.info("开始时间:" + beingtime);
        // 输出字
        se.Send("-----------------------------请任意输入0到1000的数字！-----------------------------");
        logger.info("请任意输入0到1000的数字！");
        // 创建Random类并实例化
        Random ran = new Random();
        // 创建最大值变量
        int max = 1000;
        // 创建最小值变量
        int min = 0;
        // 创建次数
        int i = 1;
        // 随机获取0到501-1的值
        int a = ran.nextInt(501);
        // 随机获取0到500-1的值
        int b = ran.nextInt(500);
        logger.info("正确数字为：" + (a + b));
        // 循环
        while (true) {
            // 输出文字
            se.Send(("提示：值在" + min + "~" + max + "之间\n"));
            logger.info("提示：值在" + min + "~" + max + "之间");
            // 把输入的文字转换成int型变量
            int think = Integer.parseInt(scan.str(out, in));
            logger.info("用户输入：" + think);
            // lambda表达式
            MyInterface MI = (x, y) -> (x + y);
            // 条件判断句
            if ((MI.add(a, b)) != think) {
                if (think > MI.add(a, b)) {
                    se.Send("你猜大了");
                    logger.info("你猜大了");
                    if (think < max) {
                        max = think;
                    }
                } else {
                    se.Send("你猜小了");
                    logger.info("你猜小了");
                    if (think > min) {
                        min = think;
                    }
                }
            } else {
                se.Send("回答正确！");
                logger.info("回答正确！");
                // 跳出循环
                break;
            }
            // 自增运算
            i++;
        }
        // 换行
        se.Send("\n");
        // 关闭扫描器
//        sc.close();
        // 总猜的次数
        se.Send(("你共猜了" + i + "次"));
        logger.info("你共猜了" + i + "次");
        // 计算总耗时
        long endtime = System.currentTimeMillis();
        logger.info("结束时间：" + endtime);
        long subtracttime = (endtime - beingtime) / 1000;
        long minutes = 0;
        long seconds = 0;
        if (subtracttime >= 60) {
            minutes = subtracttime / 60;
            seconds = subtracttime - minutes * 60;
        } else {
            seconds = subtracttime;
        }
        // 输出总耗时
        se.Send(("总耗时:" + minutes + "分" + seconds + "秒"));
        logger.info("总耗时:" + minutes + "分" + seconds + "秒");
    }
}