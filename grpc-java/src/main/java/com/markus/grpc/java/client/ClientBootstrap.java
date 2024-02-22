package com.markus.grpc.java.client;

import com.markus.grpc.base.HelloGrpc;
import com.markus.grpc.base.HelloReply;
import com.markus.grpc.base.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/21
 * @Description: 客户端启动类
 */
public class ClientBootstrap {
  public static void main(String[] args) throws InterruptedException {
    String target = "localhost:50051";

    //初始化client stub
    ClientBootstrap helloClient = new ClientBootstrap();
    helloClient.init(target);

    //调用服务测试
    helloClient.callSayHello();
    helloClient.callSayHelloServerStream();
    helloClient.callSayHelloClientStream();
    helloClient.callSayHelloBiStream();

    //阻塞主线程，等待gRPC客户端异步调用完成
    Thread.sleep(10000);
  }

  /**
   *
   * 阻塞Hello客户端（仅支持Unary、Server Stream）
   */
  private HelloGrpc.HelloBlockingStub helloBlockingStub;
  /**
   * 非阻塞Hello客户端（全部仅支持Unary、Server Stream、Client Stream、BiDirection Stream）
   */
  private HelloGrpc.HelloStub helloStub;

  /**
   * 客户端初始化
   *
   * @param target 服务端连接目标
   */
  public void init(String target) {
    ManagedChannel managedChannel = ManagedChannelBuilder.forTarget(target)
        .usePlaintext()
        .build();
    this.helloBlockingStub = HelloGrpc.newBlockingStub(managedChannel);
    this.helloStub = HelloGrpc.newStub(managedChannel);
  }

  /**
   * 调用sayHello
   */
  public void callSayHello() {
    //构建请求参数
    HelloRequest helloRequest = HelloRequest.newBuilder()
        .setName("markus")
        .build();

    //阻塞API
    HelloReply helloReply = this.helloBlockingStub.sayHello(helloRequest);
    System.out.printf("[callSayHello]blocking resp: %s", helloReply);

    //非阻塞API
    this.helloStub.sayHello(helloRequest, new StreamObserver<HelloReply>() {
      @Override
      public void onNext(HelloReply value) {
        System.out.printf("[callSayHello]resp: %s", value);
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("[callSayHello]error");
      }

      @Override
      public void onCompleted() {
        System.out.println("[callSayHello]complete");
      }
    });
  }

  /**
   * 调用sayHelloServerStream
   */
  public void callSayHelloServerStream() {
    //构建请求参数
    HelloRequest helloRequest = HelloRequest.newBuilder()
        .setName("markus")
        .build();

    //阻塞API
    Iterator<HelloReply> helloReplyIterator = this.helloBlockingStub.sayHelloServerStream(helloRequest);
    while (helloReplyIterator.hasNext()) {
      HelloReply helloReply = helloReplyIterator.next();
      System.out.printf("[callSayHelloServerStream]blocking resp: %s", helloReply);
    }


    //非阻塞API
    this.helloStub.sayHelloServerStream(helloRequest, new StreamObserver<HelloReply>() {
      @Override
      public void onNext(HelloReply value) {
        System.out.printf("[callSayHelloServerStream]resp: %s", value);
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("[callSayHelloServerStream]error");
      }

      @Override
      public void onCompleted() {
        System.out.println("[callSayHelloServerStream]complete");
      }
    });
  }

  /**
   * 调用sayHelloClientStream
   */
  public void callSayHelloClientStream() {
    //仅支持非阻塞API
    StreamObserver<HelloRequest> requestObserver = this.helloStub.sayHelloClientStream(new StreamObserver<HelloReply>() {
      @Override
      public void onNext(HelloReply value) {
        System.out.printf("[callSayHelloClientStream]resp: %s", value);
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("[callSayHelloClientStream]error");
      }

      @Override
      public void onCompleted() {
        System.out.println("[callSayHelloClientStream]complete");
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
  public void callSayHelloBiStream() {
    //仅支持非阻塞API
    StreamObserver<HelloRequest> requestObserver = this.helloStub.sayHelloBiStream(new StreamObserver<HelloReply>() {
      @Override
      public void onNext(HelloReply value) {
        System.out.printf("[callSayHelloBiStream]resp: %s", value);
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("[callSayHelloBiStream]error");
      }

      @Override
      public void onCompleted() {
        System.out.println("[callSayHelloBiStream]complete");
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
