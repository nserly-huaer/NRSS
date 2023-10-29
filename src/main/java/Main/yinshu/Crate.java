package Main.yinshu;

import useful.SendForClient;

import java.io.OutputStream;

public class Crate {
    public static long endtime;

    static String run(long l, long begintime, OutputStream out) {
        SendForClient se = new SendForClient(out);
        boolean r = false;
        StringBuffer result = new StringBuffer();
        int i1 = 0;
        for (int i = 1; i <= l; i++) {
            if (i <= 0) {
                se.LogWarn("此运算可能出现问题！");
                break;
            }
            r = (l % i == 0);
            if (r) {
                i1++;
                result = result.append(i + "、");
            }
        }
        int len = result.length() - 1;
        result = result.deleteCharAt(len);
        long endtime = System.currentTimeMillis();
        se.LogInfo("结束时间：" + endtime);
        Crate.endtime = endtime;
        String sa = "";
        sa += l + "的因数为(" + i1 + "个)：" + result.toString();
        return sa;
    }


}
