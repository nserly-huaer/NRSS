package Main.RunMainSoft;

import command.Command;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class scan {
    public static String str(OutputStream out, InputStream in) throws IOException {
        String st = null;
        for (; ; ) {
            byte[] buffer = new byte[1024];
            int length = in.read(buffer);
            if (length == -1) {
                break;
            }
            Command c = new Command();
            st = new String(buffer, 0, length);
            if (st.equalsIgnoreCase("cache")) {
                continue;
            } else if (st.toLowerCase().startsWith("getdelay")) {
                String[] cache = st.split(" ", 2);
                c.reDelay(Long.parseLong(cache[1]), out, in);
                continue;
            } else if (st.toLowerCase().startsWith("redelay")) {
                c.reDelay(System.currentTimeMillis(), out, in);
                continue;
            } else if (st.toLowerCase().startsWith("messagesender")) {
                String[] str = st.split(" ", 2);
                st = str[1];
                if (str[1].trim().isEmpty()) continue;
                break;
            }

            if (!st.trim().isEmpty()) {
                break;
            }

        }

        return st;
    }

}
