package Main.yinshu;

import Main.RunMainSoft.scan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Scan {
    public long _Scan(OutputStream out, InputStream in) throws IOException {
        Logger logger = LogManager.getLogger(Scan.class);
        String str = str(out, in);
        return stringToLong(str);

    }

    String str(OutputStream out, InputStream in) throws IOException {
        String str = null;
        Logger logger = LogManager.getLogger(Scan.class);
        out.write("请输入某个因数".getBytes());
        str = new String(scan.str(out, in));
        logger.info("请输入某个因数:" + str);
        return str;
    }

    long stringToLong(String str) {
        long l = Long.parseLong(str);
        return l;
    }
}
