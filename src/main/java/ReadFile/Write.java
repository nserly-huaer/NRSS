package ReadFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Write {
    private final static File PATH = new File("configure.properties");
    static Logger logger = LogManager.getLogger(Read.class);
    private static final String txt = "--MaxConnect=5\n--ServerPort=24824\n";

    public static void DefaultSetting() {
        FileOutputStream f1 = null;
        BufferedOutputStream bu = null;
        try {
            f1 = new FileOutputStream(PATH);
            bu = new BufferedOutputStream(f1);
            bu.write(txt.getBytes());
            bu.flush();
        } catch (IOException e) {
            logger.error(e);
        } finally {
            if (bu != null) {
                try {
                    bu.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
    }
}
