package com.markus.grpc.springboot.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/22
 * @Description:
 */
@SpringBootApplication
public class GrpcServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(GrpcServerApplication.class, args);
  }
}
