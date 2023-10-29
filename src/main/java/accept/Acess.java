package accept;

import Exception.InputException;
import FileStart.Run;
import Main.RunMainSoft.MainS;
import Main.RunMainSoft.scan;
import command.Command;
import command.txt.file;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.SendForClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Acess {
    public static List<Socket> arrayList = new ArrayList<>();
    private static int clientCount = 0; // 当前客户端连接数量
    private static Logger logger = LogManager.getLogger(Acess.class);
    private ExecutorService executorService;
    public static int ServerPort;
    private static int MaxConnect;
    private static List<String> BLACKLIST = new ArrayList<>();

    static {
        file.Create();
    }

    public static void isInBlackList(Socket socket) throws IOException {
        BLACKLIST = List.of(file.Read());
        InetAddress clientAddress = socket.getInetAddress();
        String clientIP = clientAddress.getHostAddress();
        if (BLACKLIST.contains(clientIP)) {
            System.out.println("Connection from blacklisted IP " + clientIP + " rejected.");
            socket.close();
            clientCount--;
        }
    }

    public static void Restart() {
        System.out.println("服务器重启完成");
        logger.info("服务器重启完成");
        Acess ac = new Acess();
        ac.access(ServerPort, MaxConnect);
    }


    public void access(int ServerPort, int MaxConnect) {
        Acess.MaxConnect = MaxConnect;
        ScanCommand com = new ScanCommand();
        Thread t1 = new Thread(com, "Scan");
        t1.start();
        Acess.ServerPort = ServerPort;
        executorService = Executors.newFixedThreadPool(MaxConnect);
        try {
            // 创建服务器套接字，监听指定端口
            ServerSocket serverSocket = new ServerSocket(ServerPort);
            InetAddress localhost = InetAddress.getLocalHost();
            String ipAddress = localhost.getHostAddress();
            System.out.print("服务器信息：\nipv4: " + ipAddress + ":" + ServerPort);
            System.out.println(GetIPv6.getIPv6());
            logger.info("服务器信息：\nip:" + ipAddress + ":" + ServerPort);
            System.out.println("\n\n服务器已启动，等待客户端连接...");
            logger.info("服务器已启动，等待客户端连接...");

            while (true) {
                // 等待客户端连接
                Socket clientSocket = serverSocket.accept();
                //如果客户端IP地址在黑名单中，则关闭连接
                isInBlackList(clientSocket);
                // 检查当前连接数量
                if (clientCount >= MaxConnect) {
                    System.out.println("已达到最大客户端连接数量，拒绝新连接");
                    clientSocket.close();
                    continue;
                }
                // 处理客户端连接
                clientCount++;
                executorService.execute(new ClientHandler(clientSocket));
                System.out.println("客户端连接成功，IP地址：" + clientSocket.getInetAddress().getHostAddress());
                // 将客户端连接加入集合
                arrayList.add(clientSocket);
                logger.info("客户端连接成功，IPv4地址：" + clientSocket.getInetAddress().getHostAddress());
            }

        } catch (IOException e) {
            clientCount--;
            logger.error(e);
        }
    }

    public static void Disconnect(String IP, boolean isBlack) {
        boolean is = false;
        try {
            Remove(IP).close();
            System.out.println("与客户端的连接已断开");
            is = true;
        } catch (IOException e) {
            logger.error("关闭连接失败，请重试~");
        }
        if (!isBlack)
            if (!is)
                System.out.println("关闭失败，请检查IP地址是否有误");
    }

    public static Socket IPtoSocket(String IP) {
        // 使用迭代器遍历集合，找到与指定IP地址匹配的Socket连接，并关闭它并从集合中删除
        Iterator<Socket> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            Socket socket = iterator.next();
            if (IP.equals(socket.getInetAddress().getHostAddress())) {
                return socket;
            }
        }
        return null;
    }

    public static void CloseAllSocket() {
        SendForClient se = null;
        for (Socket socket : arrayList) {
            try {
                se = new SendForClient(socket.getOutputStream());
                se.Sender("exit");
                socket.close();
            } catch (IOException e) {
                MainS.centel(e, true);
            }
        }
    }

    public static Socket Remove(String IP) {
        // 使用迭代器遍历集合，找到与指定IP地址匹配的Socket连接，并关闭它并从集合中删除
        Iterator<Socket> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            iterator.remove();
            Socket socket = iterator.next();
            if (IP.equals(socket.getInetAddress().getHostAddress())) {
                return socket;
            }
        }
        return null;
    }

    public class ClientHandler implements Runnable {
        private static ArrayList<Socket> socketList = new ArrayList<>();
        public OutputStream out = null;
        public InputStream in = null;
        private Socket socket;

        public ClientHandler(Socket socket) {
            socketList.add(socket);
            this.socket = socket;
        }

        public static void close() {
            for (Socket socket : socketList) {
                try {
                    socket.close();
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }


        @Override
        public void run() {
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();

                // 调用方法的线程
                new Thread(new MethodCaller(out, in, socket)).start();
//                String st = null;
//                for (; ; ) {
//                    byte[] buffer = new byte[1024];
//                    int length = in.read(buffer);
//                    if (length == -1) {
//                        break;
//                    }
//                    st = new String(buffer, 0, length);
//                    if (st.startsWith("exit")) {
//                        Acess.clientCount--;
//                        socket.close();
//                    }
//                }
//                byte[] buffer = new byte[1024];
//
//                while (true) {
//                    int bytesRead = in.read(buffer);
//                    if (bytesRead == -1) {
//                        break;
//                    }
//                    if()
//
//                }

                // 关闭连接
//                socket.close();
            } catch (IOException e) {
                Acess.clientCount--;
                logger.error(e);
            }
        }
    }

    class ScanCommand implements Runnable {

        @Override
        public void run() {
            while (true) {
                Scanner sc = new Scanner(System.in);
                try {
                    String str = sc.nextLine();
                    Command com = new Command(str);
                } catch (InputException e) {
                    logger.error(e);
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
    }

    public static class MethodCaller implements Runnable {
        private InputStream in;
        private OutputStream out;
        private Socket socket;


        public MethodCaller(OutputStream out, InputStream in, Socket socket) {
            this.out = out;
            this.in = in;
            this.socket = socket;
        }

        public void end() {
            try {
                this.socket.close();
                Acess.clientCount--;
            } catch (IOException e) {
                logger.error(e);
            }
        }

        @Override
        public void run() {
            Run r = new Run();
            try {
                r.run(out, in);
            } catch (IOException e) {
                Acess.clientCount--;
                logger.error(e);
            } finally {
                end();
            }
        }
    }
}