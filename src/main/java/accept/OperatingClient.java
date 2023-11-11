package accept;

import java.net.Socket;
import java.util.*;

public class OperatingClient {
    private Map<String, List<Socket>> map; // 将map字段改为实例字段

    public OperatingClient() {
        map = new HashMap<>();
    }

    // 如果返回1则存在键值，已将其覆盖；如果不存在则返回0
    public int Add(String key, Socket value) {
        if (map.containsKey(key)) { // 存在键值
            map.get(key).add(value);
            return 1;
        } else { // 不存在键值
            List<Socket> socketList = new ArrayList<>();
            socketList.add(value);
            map.put(key, socketList);
            return 0;
        }
    }

    public int GetSize() {
        return map.size();
    }

    // 返回socket并移除此键
    public Socket Remove(String key) {
        List<Socket> socketList = map.remove(key);
        if (socketList != null && !socketList.isEmpty()) {
            return socketList.get(0); // 返回移除的第一个socket
        } else {
            return null; // 如果没有对应的socket，则返回null
        }
    }

    // 是否存在此键
    public boolean IsOn(String key) {
        return map.containsKey(key);
    }

    // 获取容器中所有socket对象
    public Socket[] GetAllSocket() {
        List<Socket> allSockets = new ArrayList<>();
        for (List<Socket> socketList : map.values()) {
            allSockets.addAll(socketList);
        }
        return allSockets.toArray(new Socket[allSockets.size()]);
    }

    // 遍历所有结果IP地址
    public String GetAllIP() {
        StringBuilder bu = new StringBuilder(); // 使用StringBuilder来构建字符串
        for (String key : map.keySet()) { // 遍历所有键
            bu.append(key).append("\n"); // 添加键并换行
        }
        return bu.toString();
    }

    // 搜索指定IP地址的socket，返回所有匹配的socket数组
    public Socket[] GetSocketOnSearch(String key) {
        List<Socket> matchingSockets = map.get(key);
        if (matchingSockets != null) {
            return matchingSockets.toArray(new Socket[matchingSockets.size()]);
        } else {
            return new Socket[0]; // 返回空数组表示未找到匹配的socket
        }
    }
}