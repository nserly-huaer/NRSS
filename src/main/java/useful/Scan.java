package useful;

import java.util.Scanner;

public class Scan {

    public static String scan() {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        for (; ; ) {
            if (!result.trim().isEmpty()) {
                break;
            }
        }
        return result;
    }
}
