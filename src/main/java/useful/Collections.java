package useful;

import java.util.HashMap;
import java.util.Map;

public class Collections {
    private Map<Thread, Object> map;
    private final Thread t1;

    public Collections() {
        map = new HashMap<>();
        t1 = Thread.currentThread();
    }

    public void Add(Object object) {
        map.put(t1, object);
    }

    public Object Get() {
        return map.get(t1);
    }

    public void Remove() {
        map.remove(t1);
    }
}
