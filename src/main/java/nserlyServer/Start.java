package nserlyServer;

import Exception.NoListException;
import ReadFile.Cast;
import ReadFile.Read;
import ReadFile.Write;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.Scan;

public class Start {
    static Logger logger = LogManager.getLogger(Read.class);

    public static void main(String[] args) {
        System.out.println("----------------------软件七合一（服务端beta-1.83）by nserly----------------------");
        logger.info("软件七合一（服务端beta-1.13）by nserly");
        int resize = Read.Check();
        if (resize == 2) {
            Write.DefaultSetting();
        } else if (resize == 1) {
            logger.error("创建文件失败~");
        }
        for (; ; ) {
            System.out.println("请输入执行代码（1.恢复默认设置 2.启动服务器）------$Exit退出");
            logger.info("请输入执行代码（1.恢复默认设置 2.启动服务器）------$Exit退出");
            String str = Scan.scan();
            logger.info("管理员输入：" + str);
            if (str.toLowerCase().equals("$exit")) {
                logger.info("管理员控制：关闭服务器");
                System.out.println("服务器已关闭");
                logger.info("Server Closed");
                System.exit(1);
            }
            Cast cast = new Cast(Read.Loading());
            try {
                Equal.Sem(Integer.parseInt(str));
            } catch (NoListException e) {
                logger.error(e);
            }


        }

    }
}
