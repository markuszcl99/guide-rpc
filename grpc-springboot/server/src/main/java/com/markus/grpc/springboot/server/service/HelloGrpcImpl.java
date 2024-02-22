package com.markus.grpc.springboot.server.service;


import com.markus.grpc.base.HelloGrpc;
import com.markus.grpc.base.HelloReply;
import com.markus.grpc.base.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/21
 * @Description: Hello Grpc 实现类 （服务端代码）
 */
@GrpcService
@Slf4j
public class HelloGrpcImpl extends HelloGrpc.HelloImplBase {
  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    log.info("[sayHello]recv: {}", request);
    //构造返回结果
    HelloReply helloReply = HelloReply.newBuilder()
        .setMessage("Hello " + request.getName())
        .build();
    log.info("[sayHello]resp: {}", helloReply);
    //输出响应
    responseObserver.onNext(helloReply);
    //结束响应
    log.info("[sayHello]resp completed!");
    responseObserver.onCompleted();
  }

  @Override
  public void sayHelloServerStream(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    log.info("[sayHelloServerStream]recv: {}", request);
    //服务端输出响应流（多次onNext输出响应结果）
    IntStream.range(0, 5).forEach(index -> {
      //构造返回结果
      HelloReply helloReply = HelloReply.newBuilder()
          .setMessage(String.format("Hello_%d %s", index, request.getName()))
          .build();
      log.info("[sayHelloServerStream]resp: {}", helloReply);
      //输出响应
      responseObserver.onNext(helloReply);
    });

    //结束响应
    log.info("[sayHelloServerStream]resp completed!");
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
        log.info("[sayHelloClientStream]recv_{}: {}", nameList.size(), request.getName());
      }

      @Override
      public void onError(Throwable t) {
        //处理错误
        log.error("[sayHelloClientStream]recv error!", t);
      }

      @Override
      public void onCompleted() {
        //构造返回结果
        String nameListStr = nameList.stream().collect(Collectors.joining(","));
        HelloReply helloReply = HelloReply.newBuilder().setMessage(String.format("Hello %s", nameListStr)).build();
        log.info("[sayHelloClientStream]resp: {}", helloReply);
        //输出响应
        responseObserver.onNext(helloReply);
        log.info("[sayHelloClientStream]resp completed!");
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
        log.info("[sayHelloBiStream]recv: {}", request.getName());
        //构造返回结果
        HelloReply helloReply = HelloReply.newBuilder()
            .setMessage("Hello " + request.getName())
            .build();
        log.info("[sayHelloBiStream]resp: {}", helloReply);
        //输出响应
        responseObserver.onNext(helloReply);
      }

      @Override
      public void onError(Throwable t) {
        //处理错误
        log.error("[sayHelloBiStream]recv error!", t);
      }

      @Override
      public void onCompleted() {
        log.info("[sayHelloBiStream]resp completed!");
        //结束响应
        responseObserver.onCompleted();
      }
    };
  }
}
