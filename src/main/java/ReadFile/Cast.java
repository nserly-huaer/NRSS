package ReadFile;

import java.util.ArrayList;

public class Cast {
    public static String[] Name;
    public static String[] Value;

    public Cast(String[] Input) {
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
}