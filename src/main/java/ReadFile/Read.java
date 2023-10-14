package ReadFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class Read {
    private final static File PATH = new File("configure.properties");
    static Logger logger = LogManager.getLogger(Read.class);

    public static int Check() {//如果是0则为正常退出，如果为1则出现错误，如果为2则创建文件成功
        if (!PATH.exists()) {
            try {
                PATH.createNewFile();
                Write.DefaultSetting();
            } catch (IOException e) {
                logger.error(e);
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public static String[] Loading() {
        String[] may = null;
        String str = read();
        String[] result = null;
        may = str.split("--");
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < may.length; i++) {
            may[i] = may[i].trim();
            if (!may[i].isEmpty()) {
                array.add(may[i]);
            }
        }
        result = array.toArray(new String[array.size()]);
        return result;
    }

    private static String read() {
        FileInputStream f1 = null;
        BufferedInputStream bu = null;
        String result = null;
        try {
            f1 = new FileInputStream(PATH);
            bu = new BufferedInputStream(f1);
            byte[] b = new byte[1024000];
            int index = bu.read(b);
            result = new String(b, 0, index);
        } catch (IOException e) {
            logger.error(e);
        }
        return result;
    }
}
