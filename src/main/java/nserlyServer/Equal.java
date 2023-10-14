package nserlyServer;

import Exception.NoListException;
import ReadFile.Cast;
import ReadFile.Write;
import accept.Acess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.Scan;

public class Equal {
    private static Logger logger = LogManager.getLogger(Equal.class);

    public static boolean Sem(int index) throws NoListException {
        boolean result = true;
        switch (index) {
            case 1 -> result = SetDefault();
            case 2 -> result = StartServer();
            default -> throw new NoListException("Can't access List");
        }

        return true;
    }

    private static boolean StartServer() {

        int PORT = 25565;
        int MaxConnect = 10;

        for (int i = 0; i < Cast.Value.length; i++) {
            if (Cast.Name[i].equals("ServerPort")) {
                PORT = Integer.parseInt(Cast.Value[i]);
            }  else if (Cast.Name[i].equals("MaxConnect")) {
                MaxConnect = Integer.parseInt(Cast.Value[i]);
            }
        }
        Acess ac = new Acess();
        ac.access(PORT, MaxConnect);

        return true;
    }

    private static boolean SetDefault() {
        System.out.println("确定恢复[将其恢复将清除所有内容，是否继续？(是：true;否：false)]");
        boolean isClean = Boolean.parseBoolean(Scan.scan());
        if (isClean) {
            Write.DefaultSetting();
            System.out.println("恢复默认设置-成功\n");
            logger.info("恢复默认设置-成功");
        } else {
            System.out.println("已取消");
            logger.info("管理员控制：取消");
        }

        return true;
    }
}
