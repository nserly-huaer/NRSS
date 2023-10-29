package Main.yinshu;

import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public void run_Main(OutputStream out, InputStream in) throws IOException {
        SendForClient se = new SendForClient(out);
        Scan s = new Scan();
        se.LogInfo("运行-扫描器");
        long l = s._Scan(out, in);
        long begintime = System.currentTimeMillis();
        se.LogInfo("开始时间：" + begintime);
        String cfd = Crate.run(l, begintime,out);
        se.Send(("结果：" + cfd));
        se.LogInfo("结果:" + cfd);
        long endtime = Crate.endtime;
        long charter = endtime - begintime;
        se.LogInfo("计算毫秒值：" + charter);
        se.Send(("\n" + "Done!                                            运行总耗时:" + charter + "ms"));
        se.LogInfo("Done!运行总耗时:" + charter + "ms");

        se.Send("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
        se.LogInfo("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
    }
}
