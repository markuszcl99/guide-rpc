package com.markus.grpc.springboot.server.config;

import com.markus.grpc.springboot.server.interceptor.LogGrpcInterceptor;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/22
 * @Description:
 */
@Configuration
public class GlobalInterceptorConfiguration {
  @GrpcGlobalClientInterceptor
  public LogGrpcInterceptor logGrpcInterceptor() {
    return new LogGrpcInterceptor();
  }
}
