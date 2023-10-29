package Main.YF;


import Main.RunMainSoft.MainS;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    static void Finally(long Starttime, OutputStream out, InputStream in) throws IOException {
        SendForClient se = new SendForClient(out);
        long Endtime = System.currentTimeMillis();
        se.LogInfo("结束时间：" + Endtime);
        long Charter = Endtime - Starttime;
        se.LogInfo("计算毫秒值：" + Charter);
        se.Send(("\n" + "Done!                                      计算总耗时:" + Charter + "ms"));
        se.LogInfo("Done!计算总耗时:" + Charter + "ms");
        se.Send("\n仅限个人使用，请勿用于商业用途！！！！\n版权所有权、解释权：nserly(恩瑟莉)");
        se.LogInfo("仅限个人使用，请勿用于商业用途！！！！版权所有权、解释权：nserly(恩瑟莉)");
    }

    public void Run1(OutputStream out, InputStream in) throws IOException {

        try {
            Scan sc = new Scan();
            sc.scan(out, in);

        } catch (Exception e) {
            try {
                throw new error("Input Error");
            } catch (error e1) {
                MainS.centel(e1, true, out);
            }
        }
    }

    public void main(OutputStream out, InputStream in) throws IOException {
        try {
            Run1(out, in);
        } catch (Exception e) {
            MainS.centel(e, true, out);
            try {
                Thread.sleep(500);
            } catch (Exception e1) {
                MainS.centel(e, true, out);
            }
        }

    }
}
