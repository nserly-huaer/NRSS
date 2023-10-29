package Main.yinshu;

import Main.RunMainSoft.scan;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Scan {
    public long _Scan(OutputStream out, InputStream in) throws IOException {
        String str = str(out, in);
        return stringToLong(str);

    }

    String str(OutputStream out, InputStream in) throws IOException {
        SendForClient se = new SendForClient(out);
        String str = null;
        se.Send("请输入某个因数");
        str = new String(scan.str(out, in));
        se.LogInfo("请输入某个因数:" + str);
        return str;
    }

    long stringToLong(String str) {
        long l = Long.parseLong(str);
        return l;
    }
}
