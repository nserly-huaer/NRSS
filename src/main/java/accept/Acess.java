package accept;

import Exception.InputException;
import FileStart.Run;
import ReadFile.Cast;
import command.Command;
import command.txt.file;
import nserlyServer.Start;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import useful.Formation;
import useful.Information;
import useful.OperatingClient;
import useful.PageOperating;

import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Acess {
    private static int clientCount = 0; // 当前客户端连接数量
    private static final Logger logger = LogManager.getLogger(Acess.class);
    public static int ServerPort;
    private static int MaxConnect;
    private static List<String> BLACKLIST = new ArrayList<>();
    private static final int timeout = 5000; // 超时时间为5秒
    public static OperatingClient ClientIP = new OperatingClient();
    public static OperatingClient ClentName = new OperatingClient();
    public static Socket clientSocket = null;
    public static ServerSocket serverSocket;
    private static ExecutorService executorService;
    private static Thread t1;
    public static Action ac;
    public static String IPInformation;

    static {
        try {
            ac = new Action("UserInput", "");
        } catch (SQLException e) {
            logger.error(e);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        file.Create();
    }

    {
        Acess.MaxConnect = Integer.parseInt(PageOperating.MaxConnect);
        Acess.ServerPort = Integer.parseInt(PageOperating.ServerPort);
    }

    public static boolean isInBlackList(Socket socket) throws IOException {
        BLACKLIST = List.of(file.Read());
        InetAddress clientAddress = socket.getInetAddress();
        String clientIP = clientAddress.getHostAddress();
        if (BLACKLIST.contains(clientIP)) {
            System.out.println("Connection from blacklisted IP " + clientIP + " rejected.");
            socket.getOutputStream().write("messageSender You are in blacklisted,Contact the administrator".getBytes());
//            socket.getOutputStream().flush();
            socket.getOutputStream().write("log Error-You are in blacklisted,Contact the administrator".getBytes());
            socket.getOutputStream().flush();
            socket.close();
//            socket = null;
            clientCount--;
            return true;
        }
        return false;
    }

    public static void Restart() {
        System.out.println("服务器重启完成");
        executorService.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {

        }
        logger.info("服务器重启完成");
        Acess ac = new Acess();
        ac.access();
    }


    public void access() {
        executorService = Executors.newFixedThreadPool(MaxConnect * 2);
        ScanCommand com = new ScanCommand();
        t1 = new Thread(com, "Scan");
        t1.start();
        try {
            // 创建服务器套接字，监听指定端口
            serverSocket = new ServerSocket(ServerPort);
            InetAddress localhost = InetAddress.getLocalHost();
            String ipAddress = localhost.getHostAddress();
            IPInformation = "----------------------服务器信息：----------------------\nipv4: " + ipAddress + ":" + ServerPort
                    + GetIPv6.getIPv6() + "\n"
                    + "------------------------------------------------------";
            System.out.println(IPInformation);
            logger.info(IPInformation);
            System.out.println("\n\n服务器已启动，等待客户端连接...");
            logger.info("服务器已启动，等待客户端连接...");

            while (true) {
                // 等待客户端连接
                clientSocket = serverSocket.accept();
                //如果客户端IP地址在黑名单中，则关闭连接
                if (isInBlackList(clientSocket)) continue;
                // 检查当前连接数量
                if (clientCount >= MaxConnect) {
                    System.out.println("已达到最大客户端连接数量，拒绝新连接");
                    clientSocket.close();
                    continue;
                }


                String expectedPrefix = "username"; // 期待接收的字符串前缀
                clientSocket.setSoTimeout(timeout); // 设置读取超时时间为5秒
                InputStream in = clientSocket.getInputStream();
                try {
                    byte[] buffer = new byte[1024];
                    int bytesRead = in.read(buffer);
                    String inputLine = new String(buffer, 0, bytesRead);

                    if (inputLine == null) {
                        System.out.println("Connection closed by client");
                        // 客户端关闭了连接，跳出循环或进行其他处理
                    } else if (inputLine.trim().toLowerCase().startsWith(expectedPrefix)) {
                        // 在收到以指定字符串开头的消息后，做相应的处理
                        clientCount++;
                        if (!inputLine.trim().toLowerCase().startsWith(expectedPrefix + "-delay")) {
                            System.out.println("客户端连接成功，IP地址：" + clientSocket.getInetAddress().getHostAddress());
                            // 将客户端连接加入集合
                            ClientIP.Add(clientSocket.getInetAddress().getHostAddress(), clientSocket);
                            logger.info("客户端连接成功，IP地址：" + clientSocket.getInetAddress().getHostAddress());
                            clientSocket.setSoTimeout(0); // 取消超时设置
                            String[] cache = inputLine.split(" ", 2);
                            Information information = new Information(cache[1], clientSocket.getInetAddress().getHostAddress(), null);
                            Cast c = (Cast) Start.co.Get();
                            String dyt = c.Change(information, "Welcome");
                            c.f = new Formation(dyt);

                            Class<?> pageOperatingClass = Information.class;
                            Field[] languageField = pageOperatingClass.getDeclaredFields();
                            for (Field fie : languageField) {
                                if (fie.get(information) == null) continue;
                                c.getFormation().Change(fie.getName(), fie.get(information).toString());
                            }

                            information.Welcome = c.f.getResult();
                            String message = information.Welcome + "\n";
                            System.out.print(message);
                            clientSocket.getOutputStream().write(message.getBytes());
                            clientSocket.getOutputStream().flush();
                            executorService.execute(new ClientHandler(clientSocket));
                        } else {
                            executorService.execute(() -> {
                                try {
                                    OutputStream out1 = null;
                                    InputStream in1 = clientSocket.getInputStream();
                                    out1 = clientSocket.getOutputStream();

                                    String st = "";
                                    for (; ; ) {
                                        byte[] buffer1 = new byte[1024];
                                        int length = in.read(buffer);
                                        if (length == -1) {
                                            break;
                                        }
                                        Command c = new Command();
                                        st = new String(buffer, 0, length);
                                        if (st.toLowerCase().startsWith("getdelay")) {
                                            String[] cache = st.split(" ", 2);
                                            c.reDelay(Long.parseLong(cache[1]), out1, in1);
                                        } else if (st.toLowerCase().startsWith("redelay")) {
                                            c.reDelay(System.currentTimeMillis(), out1, in1);
                                        }
                                    }
                                } catch (IOException e) {
                                    logger.error(e);
                                }

                            });
                        }
                    }

                } catch (SocketTimeoutException e) {
                    System.out.println("Timeout, closing the connection");
                    // 读取超时，关闭客户端连接
                    clientSocket.close();

                } catch (IllegalAccessException e) {
                    logger.error(e);
                }

            }
        } catch (SocketException e) {
            logger.error(e);
        } catch (UnknownHostException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }

    }

    public static void Disconnect(String IP, boolean isBlack) {
        boolean is = false;
        try {
//            Remove(IP).close();
            Socket[] so = ClientIP.RemoveAndReturn(IP);
            for (int i = 0; i < so.length; i++) {
                so[i].getOutputStream().write("exit".getBytes());
                so[i].getOutputStream().flush();
                so[i].close();
            }
            System.out.println("与客户端的连接已断开");
            is = true;
        } catch (IOException e) {
            logger.error("关闭连接失败，请重试~");
        }
        if (!isBlack) if (!is) System.out.println("关闭失败，请检查IP地址是否有误");
    }


    public class ClientHandler implements Runnable {
        private static final ArrayList<Socket> socketList = new ArrayList<>();
        public OutputStream out = null;
        public InputStream in = null;
        private final Socket socket;

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
        private final InputStream in;
        private final OutputStream out;
        private final Socket socket;


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
        public boolean equals(Object obj) {
            return super.equals(obj);
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