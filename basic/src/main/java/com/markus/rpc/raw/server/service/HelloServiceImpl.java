package com.markus.rpc.raw.server.service;

import com.markus.rpc.raw.base.HelloRequest;
import com.markus.rpc.raw.base.HelloResponse;
import com.markus.rpc.raw.base.HelloService;

/**
 * @author: markus
 * @date: 2024/2/23 10:33 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public HelloResponse sayHello(HelloRequest helloRequest) {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setMessage(helloRequest.getUsername() + " say Hello!");
        return helloResponse;
    }
}
