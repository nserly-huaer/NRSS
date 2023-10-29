package Main.usetwoyinshu_api;

import Main.RunMainSoft.scan;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 示例代码：可供程序员学习如何调用方法的示例
 */
public class ExampleClass {
    public void Example(InputStream in, OutputStream out) throws ZeroNumberException, OnlyOneNumberException, IOException {
        SendForClient se = new SendForClient(out);
        //创建扫描器
        EqulsNumber e = new EqulsNumber();
        se.Send("请输入要多少个因数");
        se.LogInfo("请输入要多少个因数");
        //在控制台中获取需要多少因数
        int howMany = Integer.parseInt(scan.str(out, in));
        se.LogInfo("用户输入:" + howMany);
        StringBuffer str = new StringBuffer();
        //从控制台中获取所有因数
        for (int i = 1; i < howMany + 1; i++) {
            se.Send(("请输入第" + i + "个自然数："));
            se.LogInfo("请输入第" + i + "个自然数：");
            String d = new String(String.valueOf(scan.str(out, in)));
            str = str.append(d);
            se.LogInfo("用户输入:" + d);
            str = str.append("、");
        }
        //获取开始时间
        long begintime = System.currentTimeMillis();
        se.LogInfo("开始时间:" + begintime);
        //进行整理StringBuffer类
        int len = str.length() - 1;
        str = str.deleteCharAt(len);
        //将StringBuffer对象换成long数组
        ExampleClass e1 = new ExampleClass();
        long[] l = e1.Run(howMany, str);
        StringBuffer sb = new StringBuffer();
        for (long i : l) {
            sb.append(i + "、");
        }
        sb = sb.deleteCharAt(sb.length() - 1);
        String sr = sb.toString();
        se.Send(("结果：公因数为：" + sr));
        se.LogInfo("结果：公因数为：" + sr);

        //获取结束时间
        long endtime = System.currentTimeMillis();
        se.LogInfo("结束时间:" + endtime);
        //获取差值，用于显示运行毫秒数
        se.Send("总耗时：" + (endtime - begintime) + "ms");
        se.LogInfo("总耗时：" + (endtime - begintime) + "ms");
        //关闭程序
        TwoThread.end();
    }

    public long[] Run(int howMany, StringBuffer str) throws ZeroNumberException, OnlyOneNumberException {
        //创建对象实例化
        TwoThread tw = new TwoThread(howMany, str);

        //运行主程序
        tw.Run();
        //捕获异常

        //返回结果
        return TwoThread.result;
    }

}
