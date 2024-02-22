package com.markus.grpc.java.server;


import com.markus.grpc.base.HelloGrpc;
import com.markus.grpc.base.HelloReply;
import com.markus.grpc.base.HelloRequest;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/21
 * @Description: Hello Grpc 实现类 （服务端代码）
 */
public class HelloGrpcImpl extends HelloGrpc.HelloImplBase {
  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    System.out.printf("[sayHello]recv: %s", request);
    //构造返回结果
    HelloReply helloReply = HelloReply.newBuilder()
        .setMessage("Hello " + request.getName())
        .build();
    System.out.printf("[sayHello]resp: %s", helloReply);
    //输出响应
    responseObserver.onNext(helloReply);
    //结束响应
    System.out.println("[sayHello]resp completed!");
    responseObserver.onCompleted();
  }

  @Override
  public void sayHelloServerStream(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    System.out.printf("[sayHelloServerStream]recv: %s", request);
    //服务端输出响应流（多次onNext输出响应结果）
    IntStream.range(0, 5).forEach(index -> {
      //构造返回结果
      HelloReply helloReply = HelloReply.newBuilder()
          .setMessage(String.format("Hello_%d %s", index, request.getName()))
          .build();
      System.out.printf("[sayHelloServerStream]resp: %s", helloReply);
      //输出响应
      responseObserver.onNext(helloReply);
    });

    //结束响应
    System.out.println("[sayHelloServerStream]resp completed!");
    responseObserver.onCompleted();
  }

  @Override
  public StreamObserver<HelloRequest> sayHelloClientStream(StreamObserver<HelloReply> responseObserver) {
    //实现StreamObserver接受客户端流
    return new StreamObserver<HelloRequest>() {
      //name列表
      private List<String> nameList = new ArrayList<>();

      @Override
      public void onNext(HelloRequest request) {
        //接受请求
        nameList.add(request.getName());
        System.out.printf("[sayHelloClientStream]recv_%d: %s\n", nameList.size(), request.getName());
      }

      @Override
      public void onError(Throwable t) {
        //处理错误
        System.err.println("[sayHelloClientStream]recv error!");
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        //构造返回结果
        String nameListStr = nameList.stream().collect(Collectors.joining(","));
        HelloReply helloReply = HelloReply.newBuilder().setMessage(String.format("Hello %s", nameListStr)).build();
        System.out.printf("[sayHelloClientStream]resp: %s", helloReply);
        //输出响应
        responseObserver.onNext(helloReply);
        System.out.println("[sayHelloClientStream]resp completed!");
        //结束响应
        responseObserver.onCompleted();
      }
    };
  }

  @Override
  public StreamObserver<HelloRequest> sayHelloBiStream(StreamObserver<HelloReply> responseObserver) {
    //实现StreamObserver接受客户端流
    return new StreamObserver<HelloRequest>() {
      @Override
      public void onNext(HelloRequest request) {
        //接受请求
        System.out.printf("[sayHelloBiStream]recv: %s\n", request.getName());
        //构造返回结果
        HelloReply helloReply = HelloReply.newBuilder()
            .setMessage("Hello " + request.getName())
            .build();
        System.out.printf("[sayHelloBiStream]resp: %s", helloReply);
        //输出响应
        responseObserver.onNext(helloReply);
      }

      @Override
      public void onError(Throwable t) {
        //处理错误
        System.err.println("[sayHelloBiStream]recv error!");
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        System.out.println("[sayHelloBiStream]resp completed!");
        //结束响应
        responseObserver.onCompleted();
      }
    };
  }
}
