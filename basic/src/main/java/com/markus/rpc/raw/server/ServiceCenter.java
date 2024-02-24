package com.markus.rpc.raw.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: markus
 * @date: 2024/2/23 10:34 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ServiceCenter implements Server {

    private static ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * 服务注册
     * key class 全限定名
     * value 具体的服务实现类
     */
    private static final HashMap<String, Class> serviceRegistry = new HashMap<>();

    /**
     * 服务运行状态
     */
    private boolean isRunning = false;

    /**
     * 服务对外开放的端口号
     */
    private int port;

    public ServiceCenter(int port) {
        this.port = port;
    }

    @Override

    public void stop() {
        this.isRunning = false;
        pool.shutdown();
    }

    @Override
    public void start() throws IOException {
        // 服务端启动
        ServerSocket serverSocket = new ServerSocket();
        // 绑定到指定的端口号
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("Server start , bind port : " + port);
        try {
            while (true) {
                // 监听 客户端 socket 连接，接收到请求就交给线程池执行（监听的过程是阻塞的）
                pool.execute(new ServiceTask(serverSocket.accept()));
            }
        } finally {
            serverSocket.close();
        }
    }

    @Override
    public void register(Class<?> serviceInterface, Class<?> impl) {
        serviceRegistry.put(serviceInterface.getName(), impl);
    }

    @Override
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    private static class ServiceTask implements Runnable {

        Socket client = null;

        public ServiceTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // jdk 原生 序列化 类
            ObjectInputStream inputStream = null;
            ObjectOutputStream outputStream = null;

            try {

                // 读取客户端发送的请求
                inputStream = new ObjectInputStream(client.getInputStream());
                String serviceName = inputStream.readUTF();
                String methodName = inputStream.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                Object[] arguments = (Object[]) inputStream.readObject();
                Class serviceClass = serviceRegistry.get(serviceName);
                if (serviceClass == null) {
                    throw new ClassNotFoundException(serviceName + " not found");
                }

                // 通过反射执行目标方法
                Method method = serviceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguments);

                // 将执行结果写入到 socket 流中返回给客户端
                outputStream = new ObjectOutputStream(client.getOutputStream());
                outputStream.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
