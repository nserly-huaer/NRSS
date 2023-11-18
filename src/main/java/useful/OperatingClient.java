package useful;

import java.net.Socket;
import java.util.*;

public class OperatingClient {
    private final Map<String, MostCollection> map;

    public OperatingClient() {
        map = new HashMap<>();
    }

    public int Add(String key, Socket value) {
        MostCollection collection = map.get(key);
        if (collection != null) {
            collection.Writer(value);
            return 1;
        } else {
            map.put(key, new MostCollection().Writer(value));
            return 0;
        }
    }

    public int GetSize() {
        return map.size();
    }

    public void Remove(String key) {
        map.remove(key);
    }

    public Socket[] RemoveAndReturn(String key) {
        MostCollection mc = map.remove(key);
        return mc != null ? mc.Reader() : new Socket[0];
    }

    public boolean IsOn(String key) {
        return map.containsKey(key);
    }

    public Socket[] GetAllSocket() {
        List<Socket> allSockets = new ArrayList<>();
        for (MostCollection socketList : map.values()) {
            allSockets.addAll(Arrays.asList(socketList.Reader()));
        }
        return allSockets.toArray(new Socket[0]);
    }

    public String GetAllIP() {
        return String.join("\n", map.keySet());
    }

    public Socket[] GetSocketOnSearch(String key) {
        MostCollection collection = map.get(key);
        return collection != null ? collection.Reader() : new Socket[0];
    }
}