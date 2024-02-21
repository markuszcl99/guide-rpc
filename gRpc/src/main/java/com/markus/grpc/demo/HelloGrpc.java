package com.markus.grpc.demo;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *gRPC服务定义
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.0)",
    comments = "Source: hello.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HelloGrpc {

  private HelloGrpc() {}

  public static final String SERVICE_NAME = "hello.Hello";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHello",
      requestType = HelloRequest.class,
      responseType = HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = HelloGrpc.getSayHelloMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getSayHelloMethod = HelloGrpc.getSayHelloMethod) == null) {
          HelloGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("sayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getSayHelloServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHelloServerStream",
      requestType = HelloRequest.class,
      responseType = HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getSayHelloServerStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloReply> getSayHelloServerStreamMethod;
    if ((getSayHelloServerStreamMethod = HelloGrpc.getSayHelloServerStreamMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getSayHelloServerStreamMethod = HelloGrpc.getSayHelloServerStreamMethod) == null) {
          HelloGrpc.getSayHelloServerStreamMethod = getSayHelloServerStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayHelloServerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("sayHelloServerStream"))
              .build();
        }
      }
    }
    return getSayHelloServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getSayHelloClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHelloClientStream",
      requestType = HelloRequest.class,
      responseType = HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getSayHelloClientStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloReply> getSayHelloClientStreamMethod;
    if ((getSayHelloClientStreamMethod = HelloGrpc.getSayHelloClientStreamMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getSayHelloClientStreamMethod = HelloGrpc.getSayHelloClientStreamMethod) == null) {
          HelloGrpc.getSayHelloClientStreamMethod = getSayHelloClientStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayHelloClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("sayHelloClientStream"))
              .build();
        }
      }
    }
    return getSayHelloClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getSayHelloBiStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHelloBiStream",
      requestType = HelloRequest.class,
      responseType = HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getSayHelloBiStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloReply> getSayHelloBiStreamMethod;
    if ((getSayHelloBiStreamMethod = HelloGrpc.getSayHelloBiStreamMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getSayHelloBiStreamMethod = HelloGrpc.getSayHelloBiStreamMethod) == null) {
          HelloGrpc.getSayHelloBiStreamMethod = getSayHelloBiStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayHelloBiStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("sayHelloBiStream"))
              .build();
        }
      }
    }
    return getSayHelloBiStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloStub>() {
        @Override
        public HelloStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloStub(channel, callOptions);
        }
      };
    return HelloStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloBlockingStub>() {
        @Override
        public HelloBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloBlockingStub(channel, callOptions);
        }
      };
    return HelloBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloFutureStub>() {
        @Override
        public HelloFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloFutureStub(channel, callOptions);
        }
      };
    return HelloFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *gRPC服务定义
   * </pre>
   */
  public static abstract class HelloImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *gRPC服务方法定义 - Unary
     * </pre>
     */
    public void sayHello(HelloRequest request,
                         io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - Server Streaming - 服务端流
     * </pre>
     */
    public void sayHelloServerStream(HelloRequest request,
                                     io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloServerStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - Client Streaming - 客户端流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HelloRequest> sayHelloClientStream(
        io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSayHelloClientStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - BiDirection Streaming - 双向流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HelloRequest> sayHelloBiStream(
        io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSayHelloBiStreamMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                HelloRequest,
                HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getSayHelloServerStreamMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloReply>(
                  this, METHODID_SAY_HELLO_SERVER_STREAM)))
          .addMethod(
            getSayHelloClientStreamMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloReply>(
                  this, METHODID_SAY_HELLO_CLIENT_STREAM)))
          .addMethod(
            getSayHelloBiStreamMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloReply>(
                  this, METHODID_SAY_HELLO_BI_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   *gRPC服务定义
   * </pre>
   */
  public static final class HelloStub extends io.grpc.stub.AbstractAsyncStub<HelloStub> {
    private HelloStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloStub(channel, callOptions);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - Unary
     * </pre>
     */
    public void sayHello(HelloRequest request,
                         io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - Server Streaming - 服务端流
     * </pre>
     */
    public void sayHelloServerStream(HelloRequest request,
                                     io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSayHelloServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - Client Streaming - 客户端流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HelloRequest> sayHelloClientStream(
        io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSayHelloClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - BiDirection Streaming - 双向流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HelloRequest> sayHelloBiStream(
        io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getSayHelloBiStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *gRPC服务定义
   * </pre>
   */
  public static final class HelloBlockingStub extends io.grpc.stub.AbstractBlockingStub<HelloBlockingStub> {
    private HelloBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - Unary
     * </pre>
     */
    public HelloReply sayHello(HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - Server Streaming - 服务端流
     * </pre>
     */
    public java.util.Iterator<HelloReply> sayHelloServerStream(
        HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSayHelloServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *gRPC服务定义
   * </pre>
   */
  public static final class HelloFutureStub extends io.grpc.stub.AbstractFutureStub<HelloFutureStub> {
    private HelloFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *gRPC服务方法定义 - Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<HelloReply> sayHello(
        HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SAY_HELLO_SERVER_STREAM = 1;
  private static final int METHODID_SAY_HELLO_CLIENT_STREAM = 2;
  private static final int METHODID_SAY_HELLO_BI_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloReply>) responseObserver);
          break;
        case METHODID_SAY_HELLO_SERVER_STREAM:
          serviceImpl.sayHelloServerStream((HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sayHelloClientStream(
              (io.grpc.stub.StreamObserver<HelloReply>) responseObserver);
        case METHODID_SAY_HELLO_BI_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sayHelloBiStream(
              (io.grpc.stub.StreamObserver<HelloReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return HelloProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Hello");
    }
  }

  private static final class HelloFileDescriptorSupplier
      extends HelloBaseDescriptorSupplier {
    HelloFileDescriptorSupplier() {}
  }

  private static final class HelloMethodDescriptorSupplier
      extends HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSayHelloServerStreamMethod())
              .addMethod(getSayHelloClientStreamMethod())
              .addMethod(getSayHelloBiStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
