package com.markus.grpc.springboot.client.config;

import com.markus.grpc.springboot.client.interceptor.LogGrpcInterceptor;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/22
 * @Description:
 */
@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration
public class GlobalClientInterceptorConfiguration {
  @GrpcGlobalClientInterceptor
  LogGrpcInterceptor logClientInterceptor() {
    return new LogGrpcInterceptor();
  }

}
