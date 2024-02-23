package com.markus.rpc.raw.client;

import com.markus.rpc.raw.base.HelloRequest;
import com.markus.rpc.raw.base.HelloResponse;
import com.markus.rpc.raw.base.HelloService;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author: markus
 * @date: 2024/2/23 10:53 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ClientBootstrap {
    public static void main(String[] args) {
        HelloService helloService = Stub.getRemoteProxyObject(HelloService.class, new InetSocketAddress("localhost", 8848));
        HelloRequest request = new HelloRequest();

        System.out.println("请输入要 'sayHello' 的用户名 : ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String username = scanner.next();
            request.setUsername(username);
            HelloResponse helloResponse = helloService.sayHello(request);
            System.out.println(username + " invoke rpc : " + helloResponse);
        }
    }
}
