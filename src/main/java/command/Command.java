package command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Command {
    private String arg;
    private static final Logger logger = LogManager.getLogger(Command.class);

    public Command(String arg) {
        arg = arg.trim();
        String[] cache = arg.split(" ", 2);
        if (cache[0].toLowerCase().equals("getclientdelay")) {
            getclientdelay(cache[1]);
        } else if (cache[0].toLowerCase().equals("help")) {
            if (cache.length == 1) {
                help();
            } else {
                help(cache[1]);
            }
        } else if (cache[0].toLowerCase().equals("restart")) {
            restart();
        } else if (cache[0].toLowerCase().equals("send")) {
            send(cache[1]);
        } else if (cache[0].toLowerCase().equals("stop")) {
            stop();
        } else {
            logger.error("命令有误，请重试~");
        }

    }
//获取客户端延迟
    public static void getclientdelay(String str) {
        if(str.contains(":")){
            //客户端IP地址

            //....
        }else{
            //客户端名

            //....
        }
    }
//帮助
    public static void help() {
    }
//获取命令名帮助
    public static void help(String str) {
    }
//重启服务器
    public static void restart() {

    }
//向客户端发送信息
    public static void send(String str) {

    }
//关闭服务器
    public static void stop() {
    }

}
