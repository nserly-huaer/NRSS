package nserlyServer;

import Exception.NoListException;
import ReadFile.Write;
import accept.Acess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.Check;
import useful.PageOperating;
import useful.Scan;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public class Equal {
    private static final Logger logger = LogManager.getLogger(Equal.class);

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
        Check[] enumArray = Check.values();
        String[] stringArray = Arrays.stream(enumArray)
                .map(Enum::name)
                .toArray(String[]::new);
        for (int j = 0; j < stringArray.length; j++) {
            HashMap<String, String> map = Start.cast.getMap();
            if (map.containsKey(stringArray[j])) {
                try {
                    // 获取类对象
                    Class<?> pageOperatingClass = PageOperating.class;
                    Field languageField = null;
                    languageField = pageOperatingClass.getDeclaredField(stringArray[j]);
                    languageField.setAccessible(true);
                    languageField.set(null, map.get(stringArray[j]));
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }
        }


        Acess ac = new Acess();
        ac.access();


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
