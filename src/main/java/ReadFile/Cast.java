package ReadFile;

import useful.Formation;
import useful.Information;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Cast {
    public static String[] Name;
    public static String[] Value;
    public Formation f;
    public static String Welcome;

    public Cast(String[] Input) throws IllegalAccessException {
        ArrayList<String> array = new ArrayList<>();
        for (String inputString : Input) {
            String[] cache = inputString.split("=");
            array.add(cache[0].trim());
            array.add(cache[1].trim().replaceAll("\\s", " "));
        }
        int size = array.size() / 2;
        Name = new String[size];
        Value = new String[size];
        for (int i = 0; i < size; i++) {
            Name[i] = array.get(i * 2);
            Value[i] = array.get(i * 2 + 1);
        }
    }

    public Cast() {

    }

    public void Welcome(Information in) throws IllegalAccessException {
        int count = 0;
        for (String i : Name) {
            if (i.equals("Welcome")) {
                for (; ; ) {
                    if (count == Value.length) {
                        break;
                    }
                    f = new Formation(Value[count]);
                    count++;
                }

            }
        }
        Class<?> pageOperatingClass = Information.class;
        Field[] languageField = pageOperatingClass.getDeclaredFields();
        for (Field fie : languageField) {
            if (fie.get(in) == null) continue;
            f.Change(fie.getName(), fie.get(in).toString());
        }
    }

}