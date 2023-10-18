package command;

import accept.Acess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Exception.InputException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Command {
    private static final Logger logger = LogManager.getLogger(Command.class);

    public Command(String arg) throws InputException {
        arg = arg.trim();
        String[] cache = arg.split(" ", 2);
        boolean b = cache.length == 2;
        if (cache[0].toLowerCase().equals("getclientdelay")) {
            if (b)
                getclientdelay(cache[1]);
            else
                throw new InputException("参数不正确，请重试");
        } else if (cache[0].toLowerCase().equals("help")) {
            if (cache.length == 1) {
                help();
            } else {
                if (b)
                    help(cache[1]);
                else {
                    throw new InputException("参数不正确，请重试");
                }
            }
        } else if (cache[0].toLowerCase().equals("restart")) {
            restart();
        } else if (cache[0].toLowerCase().equals("send")) {
            if (b)
                send(cache[1]);
            else
                throw new InputException("参数不正确，请重试");
        } else if (cache[0].toLowerCase().equals("stop")) {
            stop();
        } else if (cache[0].toLowerCase().equals("ban")) {
            if (b)
                ban(cache[1]);
            else
                throw new InputException("参数不正确，请重试");
        } else {
            logger.error("命令有误，请重试~");
        }

    }

    //将IP地址或者客户端名列入黑名单
    public static void ban(String str) {
        if (str.contains(":")) {
            //客户端IP地址

            //....
        } else {
            //客户端名

            //....
        }
    }

    public static void reDelay(long ClientTime, OutputStream out, InputStream in) {
        long serverTime = System.currentTimeMillis();
        System.out.println("服务器与客户端延迟为：" + (serverTime - ClientTime) + "ms");
        String str = "delay " + serverTime;
        try {
            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取客户端延迟
    public static void getclientdelay(String str) {
        if (str.contains(":")) {
            //客户端IP地址

            //....
        } else {
            //客户端名

            //....
        }
    }

    //帮助
    public static void help() {
        //....
    }

    //获取命令名帮助
    public static void help(String str) {
        //....
    }

    //重启服务器
    public static void restart() {
        //....

    }

    //向客户端发送信息
    public static void send(String str) {
        if (str.contains(":")) {
            //客户端IP地址

            //....
        } else {
            //客户端名

            //....
        }
    }

    //关闭服务器,如果退出代码小于2，则为正常退出，否则为异常退出
    public static void stop() {
        //....
        System.exit(1);
    }

}
