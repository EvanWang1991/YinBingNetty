package com.yinbing.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        //创建一个在本地端口进行监听的服务socket通道，并设置非阻塞方式
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //必须配置为非阻塞才能往selector上注册，否则会报错，selector模式本身就是非阻塞模式
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(19000));
        //创建一个选择器selector
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);


    }
}
