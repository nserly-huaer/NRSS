package command.txt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class FileOperator {
    private static final File PATH = new File("BlackList.properties");
    private static final Logger logger = LogManager.getLogger(FileOperator.class);

    public FileOperator() {
        if (!PATH.exists()) {
            try {
                PATH.createNewFile();
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    public void Write(String IP) {
        IP += "\n";
        FileOutputStream f = null;
        BufferedOutputStream bu = null;
        try {
            f = new FileOutputStream(PATH, true);
            bu = new BufferedOutputStream(f);
            bu.write(IP.getBytes());
            bu.flush();
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public String[] Read() {
        String[] result = null;
        FileReader f = null;
        BufferedReader bu = null;
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            f = new FileReader(PATH);
            bu = new BufferedReader(f);
            String str = null;
            for (int i = 0; (str = bu.readLine()) != null; i++) {
                arrayList.add(str);
            }
        } catch (IOException e) {
            logger.error(e);
        } finally {
            result = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                result[i] = arrayList.get(i);
            }
        }
        return result;
    }
}
