package com.markus.rpc.raw.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author: markus
 * @date: 2024/2/23 10:46 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Stub<T> {
    @SuppressWarnings("unchecked")
    public static <T> T getRemoteProxyObject(final Class<?> serviceInterface, final InetSocketAddress address) {
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class[]{serviceInterface}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;
                ObjectOutputStream outputStream = null;
                ObjectInputStream inputStream = null;

                try {
                    socket = new Socket();
                    socket.connect(address);

                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeUTF(serviceInterface.getName());
                    outputStream.writeUTF(method.getName());
                    outputStream.writeObject(method.getParameterTypes());
                    outputStream.writeObject(args);

                    inputStream = new ObjectInputStream(socket.getInputStream());
                    return inputStream.readObject();
                } finally {
                    if (socket != null) socket.close();
                    if (outputStream != null) outputStream.close();
                    if (inputStream != null) inputStream.close();
                }
            }
        });
    }
}
