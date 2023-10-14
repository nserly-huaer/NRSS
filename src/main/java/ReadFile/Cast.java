package ReadFile;

import java.util.ArrayList;

public class Cast {
    public static String[] Name;
    public static String[] Value;

    public Cast(String[] Input) {
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < Input.length; i++) {
            String[] cache = Input[i].replace(" ", "").split("=");
            for (int j = 0; j < cache.length; j++) {
                array.add(cache[j].replace(" ", ""));
            }
        }
        int size = array.size() / 2;
        Name = new String[size];
        Value = new String[size];
        int a = 0, b = 0;
        for (int i = 0; i < array.size(); i++) {
            if ((i % 2) == 0) {
                Name[a++] = array.get(i);
            } else {
                Value[b++] = array.get(i);
            }
        }
    }
}
