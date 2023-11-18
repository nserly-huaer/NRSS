package Main.RunMainSoft;

import FileStart.Run;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MathsC {

    public static boolean Main(final OutputStream out, final InputStream in) throws IOException {
        SendForClient se = new SendForClient(out);
        boolean dd = false;
        out.write("请继续输入(1.比例求比器;2.查看是否成比例;3.化简器;4.因数求解器;5.多数公因数求解器[beta])--输入back返回--".getBytes());
        se.LogInfo("1.比例求比器;2.查看是否成比例;3.化简器;4.因数求解器;5.多数公因数求解器[beta]");
        String str = scan.str(out, in);
        se.LogInfo("用户输入：" + str);
        str = str.toLowerCase();
        if (str.equals("back")) {
            Run r = new Run();
            r.setGotoMath(false);
            dd = true;
            se.LogInfo("用户控制：返回上一步");
            out.write("\n".getBytes());
            r.d(out, in);
            return true;
        } else if (str.equals("$exit")) {
            out.write("已退出".getBytes());
            se.LogInfo("用户控制：关闭程序");
            se.LogInfo("已退出");
            Run.end = true;
            return false;

        }
        int index = Integer.parseInt(str);
        MainS m = new MainS();
        switch (index) {
            case 1 -> dd = m.townd(out, in);//比例求比器
            case 2 -> dd = m.YFd(out, in);//查看是否成比例
            case 3 -> dd = m.castRund(out, in);//化简器
            case 4 -> dd = m.yin_shu(out, in);//因数求解器
            case 5 -> dd = m.usetwoyinshu(out, in);//多数公因数求解器[beta]
            default -> MainS.error(out, in);
        }


        return dd;
    }
}
