package com.markus.rpc.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author: markus
 * @date: 2024/2/12 3:49 PM
 * @Description: 同步阻塞 IO 模型 示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class BioDemo {

    static class IOClient {
        public static void main(String[] args) {
            // 模拟一个客户端连接服务端
            new Thread(() -> {
                try (Socket socket = new Socket("127.0.0.1", 9001)) {
                    while (true) {
                        socket.getOutputStream().write((new Date() + " : Hello World!").getBytes());
                        Thread.sleep(2000);
                    }
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    static class IOServer {
        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(9001);

            // 一个线程 启动服务端程序
            new Thread(() -> {
                while (true) {
                    try {
                        // 监听端口号，阻塞获取 socket 连接
                        Socket socket = serverSocket.accept();

                        // 每获取到一个 socket 连接，就创建一个线程去处理 socket
                        new Thread(() -> {
                            int len;
                            byte[] buffer = new byte[1024];
                            try {
                                InputStream inputStream = socket.getInputStream();
                                while ((len = inputStream.read(buffer)) != -1) {
                                    System.out.println(new String(buffer, 0, len));
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }).start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

        }
    }
}
