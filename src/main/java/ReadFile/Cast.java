package ReadFile;

import java.util.ArrayList;

public class Cast {
    public String[] Name;
    public String[] Value;

    public Cast(String[] Input) {
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < Input.length; i++) {
            String[] cache = Input[i].replace(" ", "").split("=");
            for (int j = 0; j < cache.length; j++) {
                array.add(cache[j].replace(" ", ""));
            }
        }
        int size = array.size();
        Name = new String[size];
        Value = new String[size];
        for (int i = 0; i < array.size(); i++) {
            if (i % 2 == 0) {
                Name[i] = array.get(i);
            } else {
                Value[i / 2] = array.get(i);
            }
        }
    }
}
