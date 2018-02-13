package com.goura.test.nio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class ClientSocketTest {

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("google.com", 80);
        Future<Void> future = client.connect(address);
        future.get();
    }

}
