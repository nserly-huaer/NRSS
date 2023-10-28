package Main.usetwoyinshu_api;


import Main.yinshu_api.Mars;

import java.util.Scanner;
/**
 * &#064;Nserly
 * 此类中的成员方法说明：
 * usetime为处理时长（单位为“ms”）
 * result用于返回公因数，类型为String
 */
public class see {
    public static long usetime;
    public static String result;

    public void runSoft(long firstYinshu, long secondYinshu) {
        long begintime = System.currentTimeMillis();
        Mars ma = new Mars();
        ma.run_Main(String.valueOf(firstYinshu));
        String a = Mars.result;

        ma.run_Main(String.valueOf(secondYinshu));
        String b = Mars.result;
        see.Split(a, b);
        long endtime = System.currentTimeMillis();
        usetime = endtime - begintime;

    }

    static void Split(String a, String b) {
        String[] first = a.split("、");
        String[] second = b.split("、");
        result = see.resold(first, second);
    }

    static String resold(String[] a, String[] b) {
        String cache = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i].equals(b[j])) {
                    cache += a[i] + "、";
                }
            }
        }
        StringBuilder str1 = new StringBuilder(cache);
        int len = str1.length() - 1;
        str1 = str1.deleteCharAt(len);
        return str1.toString();
    }

    static long[] resold2(long[] a, long[] b) {
        String cache = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    cache += b[j] + "、";
                }
            }
        }
        StringBuilder str1 = new StringBuilder(cache);
        int len = str1.length() - 1;
        str1 = str1.deleteCharAt(len);
        StringTolong s = new StringTolong();
        return s.Cast(str1.toString());
    }

    public long[] Slip(StringBuffer str) {
        String str1 = str.toString();
        String[] str2 = str1.split("、");
        long[] l = new long[str2.length];
        for (int i = 0; i < str2.length; i++) {
            l[i] = Long.parseLong(str2[i]);
        }
        return l;
    }

    public long[] Runtime(int howMany, StringBuffer str) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < howMany + 1; i++) {
            System.out.println("请输入第" + i + "个自然数：");
            str = str.append(sc.nextLong());
            str = str.append("、");
        }
        int len = str.length() - 1;
        str = str.deleteCharAt(len);
        return Slip(str);
    }

}

