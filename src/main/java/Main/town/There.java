package Main.town;

import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class There {
    static long starttime;

    public void cheack(double u, double i, double o, double p, OutputStream out, InputStream in) throws NoNullException, IOException {

        SendForClient se = new SendForClient(out);
        First f = new First();
        long starttime = System.currentTimeMillis();
        se.LogInfo("开始时间" + starttime);
        There.starttime = starttime;
        if (u == 0)
            f.Run(u, i, o, p, out, in);
        else if (i == 0)
            f.Run2(u, i, o, p, out, in);
        else if (o == 0)
            f.Run3(u, i, o, p, out, in);
        else if (p == 0)
            f.Run4(u, i, o, p, out, in);
        else
            throw new NoNullException("No \"x\"(0) Number", out);
    }
}
