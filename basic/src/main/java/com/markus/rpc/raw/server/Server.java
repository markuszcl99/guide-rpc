package com.markus.rpc.raw.server;

import java.io.IOException;

/**
 * @author: markus
 * @date: 2024/2/23 10:32 PM
 * @Description: 服务注册
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface Server {
    void stop();

    void start() throws IOException;

    void register(Class<?> serviceInterface, Class<?> impl);

    boolean isRunning();

    int getPort();
}
