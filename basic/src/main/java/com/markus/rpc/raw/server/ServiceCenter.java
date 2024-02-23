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

    private static final HashMap<String, Class> serviceRegistry = new HashMap<>();

    private boolean isRunning = false;

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
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("Server start , bind port : " + port);
        try {
            while (true) {
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
            ObjectInputStream inputStream = null;
            ObjectOutputStream outputStream = null;

            try {

                inputStream = new ObjectInputStream(client.getInputStream());
                String serviceName = inputStream.readUTF();
                String methodName = inputStream.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                Object[] arguments = (Object[]) inputStream.readObject();
                Class serviceClass = serviceRegistry.get(serviceName);
                if (serviceClass == null) {
                    throw new ClassNotFoundException(serviceName + " not found");
                }

                Method method = serviceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguments);

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
