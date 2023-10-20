package Main.RunMainSoft;

import command.Command;
import accept.Acess;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class scan {
    public static String str(OutputStream out, InputStream in) throws IOException {
        String st = null;
        for (; ; ) {
            byte[] buffer = new byte[1024];
            int length = in.read(buffer);
            if (length == -1) {
                break;
            }
            st = new String(buffer, 0, length);
            if (st.toLowerCase().equals("cache")) {
                continue;
            } else if (st.toLowerCase().startsWith("getdelay")) {
                Command.reDelay(System.currentTimeMillis(), out, in);
                continue;
            } else if (st.toLowerCase().startsWith("messagesender")) {
                String[] str = st.split(" ", 2);
                st = str[1];
                break;
            }

            if (!st.trim().isEmpty()) {
                break;
            }

        }

        return st;
    }

}
