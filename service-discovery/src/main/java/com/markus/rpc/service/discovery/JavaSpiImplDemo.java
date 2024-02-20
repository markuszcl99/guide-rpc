package com.markus.rpc.service.discovery;

import java.util.ServiceLoader;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/20
 * @Description: Java SPI 机制实现示例
 */
public class JavaSpiImplDemo {
  public static void main(String[] args) {
    ServiceLoader<MessageService> services = ServiceLoader.load(MessageService.class);
    for (MessageService service : services) {
      System.out.println(service.getMessage());
    }
  }
}
