package com.yinbing.netty.bio;

import java.io.IOException;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 19000);
        socket.getOutputStream().write("HelloServer".getBytes());
        socket.getOutputStream().flush();

        System.out.println("向服务端发送数据");

        byte[] bytes = new byte[1024];

        socket.getInputStream().read(bytes);

        System.out.println(bytes);

        System.out.println("接收服务端的数据：" + bytes);
        socket.close();
    }
}
