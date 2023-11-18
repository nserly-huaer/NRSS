package command.txt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

/**
 * 此方法用于返回黑名单IP地址列表
 * Create()创建黑名单文件
 * Write()将黑名单写入至文件
 * Read()读取黑名单文件，然后返回String数组
 */
public class file {
    private static final Logger logger = LogManager.getLogger(file.class);
    private static final File PATH = new File("Data\\BlackList.json");
    private static final File Mark = new File("Data");

    public static void Create() {
        if (!Mark.exists())
            Mark.mkdir();
        if (!PATH.exists()) {
            try {
                PATH.createNewFile();
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    public static void Write(String[] IP) {
        FileOutputStream f = null;
        BufferedOutputStream bu = null;
        try {
            f = new FileOutputStream(PATH, true);
            bu = new BufferedOutputStream(f);
            for (String i : IP) {
                bu.write(i.getBytes());
                bu.write("\n".getBytes());
            }
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
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
    }

    public static void Write(String IP) {
        FileOutputStream f = null;
        BufferedOutputStream bu = null;
        try {
            f = new FileOutputStream(PATH, true);
            bu = new BufferedOutputStream(f);
            bu.write(IP.getBytes());
            bu.write("\n".getBytes());
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
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
    }

    public static String[] Read() {
        String[] result = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        ArrayList<String> array = new ArrayList<String>();
        try {
            fileReader = new FileReader(PATH);
            bufferedReader = new BufferedReader(fileReader);
            int lineCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                array.add(line);
                lineCount++;
            }
        } catch (IOException e) {
            logger.error(e);
        } finally {
            result = array.toArray(new String[array.size()]);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }


        return result;
    }
}
