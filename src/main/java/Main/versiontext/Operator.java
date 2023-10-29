package Main.versiontext;

import Main.RunMainSoft.MainS;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Operator {
    private final String version = "9.1.83";

    public String[] version(OutputStream out, InputStream in) throws IOException {
        SendForClient se = new SendForClient(out);
        se.LogInfo("检查版本号...");
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            MainS.centel(e, true, out);
        }
        String list = "软件版本:" + version;
        se.LogInfo(list);
        String log4jVersion = "Log4j版本:" + org.apache.logging.log4j.util.PropertiesUtil.class.getPackage().getImplementationVersion();
        se.LogInfo(log4jVersion);
        String[] str = {list, log4jVersion};
        return str;


    }

}
