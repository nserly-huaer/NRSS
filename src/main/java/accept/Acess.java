package accept;

import FileStart.Run;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Acess {
    private static Logger logger = LogManager.getLogger(Acess.class);

    public static void access(int ServerPort, int MaxConnect, String ServerName) {

        try {
            // 创建服务器套接字，监听指定端口
            ServerSocket serverSocket = new ServerSocket(ServerPort);

            System.out.println("服务器信息：\nip:" + InetAddress.getLocalHost() + ":" + ServerPort);
            logger.info("服务器信息：\nip:" + InetAddress.getLocalHost() + ":" + ServerPort);
            System.out.println("\n\n服务器已启动，等待客户端连接...");
            logger.info("服务器已启动，等待客户端连接...");
            // 创建线程池
            int corePoolSize = 2; // 最小线程数
            int maxPoolSize = MaxConnect + 1; // 最大线程数
            long keepAliveTime = 60; // 线程空闲时间（单位：秒）
            ThreadPoolExecutor executor = new ThreadPoolExecutor(
                    corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>());

            while (true) {
                // 等待客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端连接成功，IP地址：" + clientSocket.getInetAddress().getHostAddress());
                logger.info("客户端连接成功，IP地址：" + clientSocket.getInetAddress().getHostAddress());

                // 提交任务给线程池处理客户端请求
                executor.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // 获取客户端输入流和输出流
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                // 读取客户端发送的数据
                byte[] buffer = new byte[1024];
                int length = inputStream.read(buffer);
                String requestData = new String(buffer, 0, length);


//                System.out.println("接收到客户端数据：" + requestData);

                Run r = new Run();
                r.run(outputStream, inputStream);
//                // 根据客户端发送的数字执行不同的方法
//                int number = Integer.parseInt(requestData);
//                //....


                // 发送响应数据给客户端
                String responseData = "方法执行完毕";
                outputStream.write(responseData.getBytes());
                outputStream.flush();

                // 关闭流和客户端套接字
                outputStream.close();
                inputStream.close();
                clientSocket.close();
            } catch (IOException e) {
                logger.error(e);
            }

        }


    }
}