package Main.town;


import Main.RunMainSoft.MainS;
import useful.SendForClient;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class loser {
    public void main(OutputStream out, InputStream in) throws InterruptedException, IOException {
        SendForClient se = new SendForClient(out);
        out.flush();
        se.LogInfo("此软件会用到“四舍五入”算法，保留14位小数。");
        try {
            Da d = new Da();
            d.demo(out, in);

        } catch (error e) {
            MainS.centel(e, true, out);
            Thread.sleep(500);
        } catch (ArithmeticException e) {
            MainS.centel(e, true, out);
            Thread.sleep(500);
            se.LogError("除数不能为零，请重试！");
        }

        Finally f = new Finally();
        f.finallyt(out, in);

    }
}
