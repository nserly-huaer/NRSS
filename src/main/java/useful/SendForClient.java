package useful;

import Main.RunMainSoft.MainS;

import java.io.IOException;
import java.io.OutputStream;

public class SendForClient {
    OutputStream out;

    public SendForClient(OutputStream out) {
        this.out = out;
    }

    public void SendLine(String message) throws IOException {
        try {
            String cache = message + "\n";
            out.write(cache.getBytes());
        } catch (IOException e) {
            MainS.centel(e, true, out);
        }
    }

    public void Send(String message) throws IOException {
        try {
            out.write(message.getBytes());
        } catch (IOException e) {
            MainS.centel(e, true, out);
        }
    }
}
