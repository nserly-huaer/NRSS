package Main.RunMainSoft;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class scan {
    public static String str(OutputStream out, InputStream in) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String st = null;
        for (; ; ) {
            st = new String(sc.nextLine());
            st = st.trim();
            if (!st.isEmpty())
                break;

        }
        return st;

    }

}
