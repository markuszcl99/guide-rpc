package com.markus.rpc.raw.server;

import com.markus.rpc.raw.base.HelloService;
import com.markus.rpc.raw.server.service.HelloServiceImpl;

import java.io.IOException;

/**
 * @author: markus
 * @date: 2024/2/23 10:51 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ServerBootstrap {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            Server server = new ServiceCenter(8848);
            server.register(HelloService.class, HelloServiceImpl.class);
            try {
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
