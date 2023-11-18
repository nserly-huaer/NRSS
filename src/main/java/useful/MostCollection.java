package useful;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MostCollection {
    private List<Socket> list;

    public MostCollection() {
        list = new ArrayList<>();
    }

    public int GetSize() {
        return list.size();
    }

    public Socket[] Reader() {
        Socket[] so = new Socket[list.size()];
        Iterator<Socket> it = list.iterator();
        for (int i = 0; it.hasNext(); i++) {
            so[i] = it.next();
        }
        return so;
    }


    public MostCollection Writer(Socket clentSocket) {
        list.add(clentSocket);
        return this;
    }

}
