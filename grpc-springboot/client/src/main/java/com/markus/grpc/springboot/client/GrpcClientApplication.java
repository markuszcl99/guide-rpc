package com.markus.grpc.springboot.client;

import com.markus.grpc.springboot.client.service.HelloClientServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/22
 * @Description:
 */
@SpringBootApplication
public class GrpcClientApplication implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(GrpcClientApplication.class, args);
  }

  @Resource
  private HelloClientServiceImpl helloClientService;

  @Override
  public void run(String... args) throws Exception {
    this.helloClientService.sayHello();
    this.helloClientService.sayHelloServerStream();
    this.helloClientService.sayHelloClientStream();
    this.helloClientService.sayHelloBiStream();
  }
}
