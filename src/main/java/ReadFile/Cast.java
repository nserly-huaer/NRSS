package ReadFile;

import useful.Formation;
import useful.Information;

import java.util.ArrayList;
import java.util.HashMap;

public class Cast {
    private final HashMap<String, String> map = new HashMap<>();
    public Formation f;

    public HashMap<String, String> getMap() {
        return (HashMap<String, String>) map.clone();
    }

    public Formation getFormation() {
        return f;
    }

    public Cast(String[] Input) throws IllegalAccessException {
        ArrayList<String> array = new ArrayList<>();
        for (String inputString : Input) {
            String[] cache = inputString.split("=");
            array.add(cache[0].trim());
            array.add(cache[1].trim().replaceAll("\\s", " "));
        }
        int size = array.size() / 2;
        for (int i = 0; i < size; i++) {
            map.put(array.get(i * 2), array.get(i * 2 + 1));
        }
    }

    public String Change(Information in, String check) throws IllegalAccessException {
        return map.get(check);
    }


}