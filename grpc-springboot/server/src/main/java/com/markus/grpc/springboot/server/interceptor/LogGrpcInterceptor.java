package com.markus.grpc.springboot.server.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/22
 * @Description:
 */
public class LogGrpcInterceptor implements ServerInterceptor {

  private Logger logger = LoggerFactory.getLogger(LogGrpcInterceptor.class);

  @Override
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
    logger.info(serverCall.getMethodDescriptor().getFullMethodName());
    return serverCallHandler.startCall(serverCall, metadata);
  }
}
