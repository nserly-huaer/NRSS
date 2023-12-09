package nserlyServer;

import Exception.NoListException;
import ReadFile.Cast;
import ReadFile.Read;
import ReadFile.Write;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.Collections;
import useful.Scan;

public class Start {
    public static Collections co = new Collections();
    static Logger logger = LogManager.getLogger(Read.class);

    public static void main(String[] args) throws IllegalAccessException {

        Do();
    }

    public static void Do() throws IllegalAccessException {
        System.out.println("----------------------软件七合一（服务端beta-8.26）by nserly----------------------");
        logger.info("软件七合一（服务端beta-1.13）by nserly");
        int resize = Read.Check();
        if (resize == 2) {
            Write.DefaultSetting();
        } else if (resize == 1) {
            logger.error("创建文件失败~");
        }
        System.out.println("请输入执行代码（1.恢复默认设置 2.启动服务器）------$Exit退出");
        logger.info("请输入执行代码（1.恢复默认设置 2.启动服务器）------$Exit退出");
        String str = Scan.scan();
        logger.info("管理员输入：" + str);
        if (str.equalsIgnoreCase("$exit")) {
            logger.info("管理员控制：关闭服务器");
            System.out.println("服务器已关闭");
            logger.info("Server Closed");
            System.exit(1);
        }
        Cast cast = new Cast(Read.Loading());
        co.Add(cast);
        try {
            Equal.Sem(Integer.parseInt(str));
        } catch (NoListException e) {
            logger.error(e);
        }
    }
}
