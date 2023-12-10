package command.txt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class help {
    private static final String information = "获取服务器信息（不仅限于服务器接发地址、端口、内存占用等）" +
            "\n" +
            "实例\n" +
            "information";
    private static final String ban = "将对方ip地址列入黑名单（此IP地址将无法再次连接到此服务器）\n" +
            "\n" +
            "ban [ClientIP]\n" +
            "\n" +
            "    ClientIP             客户端ip地址\n" +
            "\n" +
            "示例：\n" +
            "ban 123.321.456.654\n" +
            "ban Party";
    private static final String connect = "查看服务器连接的所有ip\n" +
            "\n" +
            "connectIP\n" +
            "\n" +
            "遍历所有的客户端ip，此命令可以帮助管理员客户端IP地址";
    private static final String disconnect = "关闭输入指定连接\n" +
            "\n" +
            "disconnect [IP]\n" +
            "\n" +
            "IP 客户端IP地址\n" +
            "\n" +
            "关闭指定连接可以帮助服务器减轻工作时压力：缓解宽带、内存占用、CPU占用率等";
    private static final String getclientdelay = "获取客户端到服务器之间的延迟\n" +
            "\n" +
            "getclientdelay [ClientIP]\n" +
            "ClientIP                        客户端ip地址\n" +
            "\n" +
            "示例：\n" +
            "getclientdelay Marty";
    private static final String help = "你好，这是帮助；我们竭尽全力为你服务，一下为命令列表，你可以输入help 命令名来获取命令名的详细描述\n" +
            "ban 将对方ip地址列入黑名单（此IP地址将无法再次连接到此服务器）\n" +
            "information 获取服务器信息\n" +
            "getclientdelay 获取客户端到服务器之间的延迟\n" +
            "help 帮助\n" +
            "restart 重启服务器：此操作将断开与客户端的连接并将服务器重启，未保存的数据将可能丢失！\n" +
            "send 向客户端发送消息\n" +
            "stop 停止服务器\n" +
            "connectIP 查看服务器连接的所有ip\n" +
            "disconnect 关闭指定客户端连接\n" +
            "\n" +
            "help [command]\n" +
            "command                 命令名\n" +
            "\n" +
            "示例：\n" +
            "help stop";
    public static final String restart = "重启服务器\n" +
            "\n" +
            "restart\n" +
            "\n" +
            "断开与客户端的连接并将服务器重启，未保存的数据将可能丢失！";
    private static final String send = "向客户端发送消息\n" +
            "\n" +
            "send [ClientIP] [message]\n" +
            "\n" +
            "ClientIP                       客户端ip地址\n" +
            "message                     发送信息（如果含有空格，请使用在发送信息前后写上\"）\n" +
            "\n" +
            "示例：\n" +
            "send Mary \"Hello,nice to you!\"";
    private static final String stop = "停止服务器\n" +
            "\n" +
            "stop\n" +
            "\n" +
            "将客户端连接断开，然后关闭服务器！";
    private static final Logger logger = LogManager.getLogger(help.class);

    public static String Read(String command) {
        String result = null;
        switch (command) {
            case "ban" -> result = ban;
            case "connect" -> result = connect;
            case "disconnect" -> result = connect;
            case "getclientdelay" -> result = getclientdelay;
            case "help" -> result = help;
            case "restart" -> result = restart;
            case "send" -> result = send;
            case "stop" -> result = stop;
            case "information" -> result = information;
            default -> result = "命令无效，请重试~";
        }

        return result;
    }


}