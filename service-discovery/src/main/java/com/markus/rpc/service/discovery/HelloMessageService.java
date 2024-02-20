package com.markus.rpc.service.discovery;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/20
 * @Description:
 */
public class HelloMessageService implements MessageService {
  @Override
  public String getMessage() {
    return "Hello";
  }
}
