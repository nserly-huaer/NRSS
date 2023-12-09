package useful;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Formation {
    Set<String> Name = null;//名称
    private String string;//修改的变量

    public Formation(String string) {
        this.string = string;
        Name = new HashSet<>();
        for (int i = 0; ; ) {
            if (string.indexOf("${", i) > -1) {
                int cache = string.indexOf("}", i);
                Name.add(string.substring(string.indexOf("${", i), cache + 1));
                i = cache + 1; // 更新 i 的值
            } else {
                break;
            }
        }
    }

    public String getResult() {
        return this.string;
    }

    public boolean Change(String revalued, String value) {//revalued文本,value改变值
        if (Name == null & Name.isEmpty()) return false;
        if (Name.contains("${" + revalued + "}")) {
            string = string.replaceAll("\\$\\{" + revalued + "\\}", value);
            return true;
        }
        return false;
    }

    public static void Revise(Class c, String variable, Object value) throws NoSuchFieldException, IllegalAccessException {//c为类，variable为被修改变量，value为修改的变量
        Field f = c.getDeclaredField(variable);//获取属性列表
        f.setAccessible(true);//设置为可修改
        f.set(variable, value);//将变量对应名称里面的值设置为指定值
    }

}
