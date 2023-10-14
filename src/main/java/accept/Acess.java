package accept;

import FileStart.Run;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Acess {
    private static int clientCount = 0; // 当前客户端连接数量
    private static Logger logger = LogManager.getLogger(Acess.class);
    private ExecutorService executorService;

    public void access(int ServerPort, int MaxConnect) {
        executorService = Executors.newFixedThreadPool(MaxConnect);
        try {
            // 创建服务器套接字，监听指定端口
            ServerSocket serverSocket = new ServerSocket(ServerPort);
            InetAddress localhost = InetAddress.getLocalHost();
            String ipAddress = localhost.getHostAddress();
            System.out.println("服务器信息：\nip: " + ipAddress + ":" + ServerPort);
            logger.info("服务器信息：\nip:" + ipAddress + ":" + ServerPort);
            System.out.println("\n\n服务器已启动，等待客户端连接...");
            logger.info("服务器已启动，等待客户端连接...");

            while (true) {
                // 等待客户端连接
                Socket clientSocket = serverSocket.accept();
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
                logger.info("客户端连接成功，IP地址：" + clientSocket.getInetAddress().getHostAddress());
            }

        } catch (IOException e) {
            logger.error(e);
        }
    }

    class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                // 调用方法的线程
                new Thread(new MethodCaller(out, in)).start();

                byte[] buffer = new byte[1024];

//                while (true) {
//                    int bytesRead = in.read(buffer);
//                    if (bytesRead == -1) {
//                        break;
//                    }
//
//                    // 返回客户端发来的字节数组
//                    out.write(buffer, 0, bytesRead);
//                    out.flush();
//                }

                // 关闭连接
//                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class MethodCaller implements Runnable {
        private InputStream in;
        private OutputStream out;

        public MethodCaller(OutputStream out, InputStream in) {
            this.out = out;
            this.in = in;
        }

        @Override
        public void run() {
            Run r = new Run();
            try {
                r.run(out, in);
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}