package com.markus.rpc.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/29
 * @Description: NIO 示例
 */
public class NioDemo {
  static class NioServer {
    public static void main(String[] args) throws IOException {
      // 创建一个 Selector 用于轮询 SocketChannel
      Selector selector = Selector.open();

      // 创建一个 ServerSocketChannel
      ServerSocketChannel serverSocket = ServerSocketChannel.open();
      InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9001);
      // 绑定地址
      serverSocket.bind(address);
      // 配置非阻塞模式
      serverSocket.configureBlocking(false);

      // 将自己注册到 Selector 监听的可接受连接事件上，
      serverSocket.register(selector, SelectionKey.OP_ACCEPT);
      while (true) {
        if (selector.select() > 0) {
          Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
          while (selectionKeys.hasNext()) {
            SelectionKey selectionKey = selectionKeys.next();
            if (selectionKey.isAcceptable()) {
              SocketChannel client = serverSocket.accept();
              // 配置为非阻塞
              client.configureBlocking(false);

              client.register(selector, SelectionKey.OP_READ);
            } else {
              SocketChannel socket = (SocketChannel) selectionKey.channel();
              ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
              socket.read(byteBuffer);

              String content = new String(byteBuffer.array()).trim();
              System.out.println("服务端读取到客户端消息: " + content);

              socket.close();
            }
            selectionKeys.remove();
          }
        }
      }
    }
  }

  static class NioClient {
    public static void main(String[] args) throws IOException {
      SocketChannel socketChannel = SocketChannel.open();
      socketChannel.connect(new InetSocketAddress("127.0.0.1", 9001));

      String message = "Hello, NIO";
      ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());
      socketChannel.write(byteBuffer);

      socketChannel.close();
    }
  }
}
