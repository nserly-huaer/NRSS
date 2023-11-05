package command;

import Main.Log4j2Pro.Main;
import Main.RunMainSoft.MainS;
import accept.Acess;
import command.txt.file;
import command.txt.help;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Exception.InputException;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Command {
    private static final Logger logger = LogManager.getLogger(Command.class);
    private boolean isSole;

    public Command() {

    }

    public Command(String arg) throws InputException, IOException {
        arg = arg.trim();
        String[] cache = arg.split(" ", 2);
        boolean b = cache.length == 2;
        if (cache[0].toLowerCase().equals("getclientdelay")) {
            if (b) getclientdelay(cache[1]);
            else throw new InputException("参数不正确，请重试");
        } else if (cache[0].toLowerCase().equals("help")) {
            if (cache.length == 1) {
                help();
            } else {
                if (b) help(cache[1]);
                else {
                    throw new InputException("参数不正确，请重试");
                }
            }
        } else if (cache[0].toLowerCase().equals("restart")) {
            restart();
        } else if (cache[0].toLowerCase().equals("send")) {
            String[] str = cache[1].split(" ", 2);//[0]为IP地址，[1]为发送信息
            send(str[1], str[0]);
        } else if (cache[0].toLowerCase().equals("stop")) {
            stop();
        } else if (cache[0].toLowerCase().equals("ban")) {
            if (b) ban(cache[1]);
            else throw new InputException("参数不正确，请重试");
        } else if (cache[0].equals("connectIP")) {
            connectIP();

        } else if (cache[0].toLowerCase().equals("disconnect")) {
            DisConnect(cache[1]);
        } else {
            logger.error("命令有误，请重试~");
        }

    }

    //关闭指定IP地址客户端Socket
    public static void DisConnect(String IP) {//已完成
        try {
            Acess.Disconnect(IP, false);
            System.out.println("关闭成功！IP地址：" + IP);
            logger.info("关闭成功！IP地址：" + IP);
        } catch (Exception e) {
            System.out.println("无法关闭连接，请检查IP地址是否有误！");
        }

    }

    //将IP地址或者客户端名列入黑名单
    public static void ban(String str) {//已完成
        file.Create();
        file f = new file();
        f.Write(str);
        try {
            Acess.Remove(str);
        } catch (Exception e) {
            logger.warn("移除失败，原因：无法找到对应的Socket连接");
        }
        System.out.println("成功将" + str + "加入黑名单");
        logger.info("成功将" + str + "加入黑名单");

    }

    //遍历所有已连接的客户端
    public static void connectIP() {//已完成
        System.out.println("客户端连接(共" + Acess.arrayList.size() + "个)：");
        logger.info("客户端连接(共" + Acess.arrayList.size() + "个)：");
        for (int i = 0; i < Acess.arrayList.size(); i++) {
            InetAddress clientAddress = Acess.arrayList.get(i).getInetAddress();
            String clientIP = clientAddress.getHostAddress();
            System.out.println(clientIP);
            Main.filecun(clientIP);
        }
        System.out.println("--------------------------------------------------");
        Main.filecun("--------------------------------------------------");
    }

    //延迟
    public void reDelay(long ClientTime, OutputStream out, InputStream in) {//已完成
        long serverTime = System.currentTimeMillis();
        if (isSole) {
            System.out.println("服务器与客户端延迟为：" + (serverTime - ClientTime) + "ms");
            logger.info("服务器与客户端延迟为：" + (serverTime - ClientTime) + "ms");
            isSole = false;
        }
        String str = "delay " + serverTime;
        try {
            out.write(str.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取客户端延迟
    public void getclientdelay(String str) throws IOException {//已完成
        isSole = true;
        Socket so = Acess.IPtoSocket(str);
        OutputStream out = so.getOutputStream();
        SendForClient se = new SendForClient(out);
        se.sendDelay(System.currentTimeMillis());
    }

    //帮助
    public static void help() {//已完成
        String str = help.Read("help");
        System.out.println(str);
        Main.filecun(str);
    }

    //获取命令名帮助
    public static void help(String str) {//已完成
        String str1 = help.Read(str);
        System.out.println(str1);
        Main.filecun(str1);

    }

    //重启服务器
    public static void restart() {//已完成
        System.out.println("关闭套接字中...");
        logger.info("关闭套接字中...");
        Acess.ClientHandler.close();
        System.out.println("套接字关闭成功，重启服务器中...");
        logger.info("套接字关闭成功，重启服务器中...");
        Acess.Restart();

    }

    //向客户端发送信息
    public static void send(String str, String IP) {//已完成
        try {
            Socket so = Acess.IPtoSocket(IP);
            OutputStream out = so.getOutputStream();
            SendForClient se = new SendForClient(out);
            se.OperatorSend(str);

        } catch (Exception e) {
            MainS.centel(e, true);
        }

    }


    //关闭服务器,如果退出代码小于2，则为正常退出，否则为异常退出
    public static void stop() {//已完成
        Acess.CloseAllSocket();
        System.out.println("已关闭所有连接");
        logger.info("已关闭所有连接");
        System.exit(1);
    }

}
