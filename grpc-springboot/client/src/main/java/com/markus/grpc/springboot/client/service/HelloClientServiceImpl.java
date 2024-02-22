package com.markus.grpc.springboot.client.service;

import com.markus.grpc.base.HelloGrpc;
import com.markus.grpc.base.HelloReply;
import com.markus.grpc.base.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/22
 * @Description:
 */
@Service("helloClientService")
@Slf4j
public class HelloClientServiceImpl {
  @GrpcClient("grpc-sb-server")
  private HelloGrpc.HelloBlockingStub helloBlockingStub;

  @GrpcClient("grpc-sb-server")
  private HelloGrpc.HelloStub helloStub;

  /**
   * 调用sayHello
   */
  public void sayHello() {
    //构建请求参数
    HelloRequest helloRequest = HelloRequest.newBuilder()
        .setName("markus")
        .build();

    //阻塞API
    HelloReply helloReply = this.helloBlockingStub.sayHello(helloRequest);
    log.info("[callSayHello]blocking resp: {}", helloReply);

    //非阻塞API
    this.helloStub.sayHello(helloRequest, new StreamObserver<HelloReply>() {
      @Override
      public void onNext(HelloReply value) {
        log.info("[callSayHello]resp: {}", value);
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("[callSayHello]error");
      }

      @Override
      public void onCompleted() {
        log.info("[callSayHello]complete");
      }
    });
  }

  /**
   * 调用sayHelloServerStream
   */
  public void sayHelloServerStream() {
    //构建请求参数
    HelloRequest helloRequest = HelloRequest.newBuilder()
        .setName("markus")
        .build();

    //阻塞API
    Iterator<HelloReply> helloReplyIterator = this.helloBlockingStub.sayHelloServerStream(helloRequest);
    while (helloReplyIterator.hasNext()) {
      HelloReply helloReply = helloReplyIterator.next();
      log.info("[callSayHelloServerStream]blocking resp: {}", helloReply);
    }


    //非阻塞API
    this.helloStub.sayHelloServerStream(helloRequest, new StreamObserver<HelloReply>() {
      @Override
      public void onNext(HelloReply value) {
        log.info("[callSayHelloServerStream]resp: {}", value);
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("[callSayHelloServerStream]error");
      }

      @Override
      public void onCompleted() {
        log.info("[callSayHelloServerStream]complete");
      }
    });
  }

  /**
   * 调用sayHelloClientStream
   */
  public void sayHelloClientStream() {
    //仅支持非阻塞API
    StreamObserver<HelloRequest> requestObserver = this.helloStub.sayHelloClientStream(new StreamObserver<HelloReply>() {
      @Override
      public void onNext(HelloReply value) {
        log.info("[callSayHelloClientStream]resp: {}", value);
      }

      @Override
      public void onError(Throwable t) {
        log.error("[callSayHelloClientStream]error", t);
      }

      @Override
      public void onCompleted() {
        log.info("[callSayHelloClientStream]complete");
      }
    });

    //发送请求
    requestObserver.onNext(HelloRequest.newBuilder().setName("markus1-c").build());
    //连续发送请求
    requestObserver.onNext(HelloRequest.newBuilder().setName("markus2-c").build());
    //连续发送请求
    requestObserver.onNext(HelloRequest.newBuilder().setName("markus3-c").build());

    //结束发送请求
    requestObserver.onCompleted();

  }

  /**
   * 调用sayHelloBiStream
   */
  public void sayHelloBiStream() {
    //仅支持非阻塞API
    StreamObserver<HelloRequest> requestObserver = this.helloStub.sayHelloBiStream(new StreamObserver<HelloReply>() {
      @Override
      public void onNext(HelloReply value) {
        log.info("[callSayHelloBiStream]resp: {}", value);
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("[callSayHelloBiStream]error");
      }

      @Override
      public void onCompleted() {
        log.info("[callSayHelloBiStream]complete");
      }
    });

    //发送请求
    requestObserver.onNext(HelloRequest.newBuilder().setName("markus1-b").build());
    //连续发送请求
    requestObserver.onNext(HelloRequest.newBuilder().setName("markus2-b").build());
    //连续发送请求
    requestObserver.onNext(HelloRequest.newBuilder().setName("markus3-b").build());

    //结束发送请求
    requestObserver.onCompleted();
  }
}
