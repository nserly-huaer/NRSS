package Main.town;


import useful.SendForClient;

import java.io.OutputStream;

@SuppressWarnings("serial")
public class error extends Exception {
    private final String ExceptionMessage;

    public error(String ExceptionMessage, OutputStream out) {
        super(ExceptionMessage);
        SendForClient se = new SendForClient(out);
        this.ExceptionMessage = ExceptionMessage;
        se.LogError("输入非有效值，请重试！");
    }

}
