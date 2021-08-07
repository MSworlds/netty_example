package com.mashibing.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

/**
 * @author:ms
 * @date: 2021-08-05
 */
public class NioClient {

    public static void main(String[] args) {


        try {
            //1、创建socker通道
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
            //2、切换异步非阻塞
            socketChannel.configureBlocking(false); //1.7及以上
            //3、指定缓冲区大小
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(new Date().toString().getBytes());
            //4、切换到读取模式
            byteBuffer.flip();

            //3、指定缓冲区大小
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
            byteBuffer1.put("hjdgSJKhfkjsdhfkjshd就开始对方空间还是离开绝代风华是对方会发生的看法很快收到回复".getBytes());
            //4、切换到读取模式
            byteBuffer1.flip();
            //5、写入到缓冲区
            socketChannel.write(
                    new ByteBuffer[]{byteBuffer,byteBuffer1});

            byteBuffer1.flip();
            byteBuffer.flip();
            socketChannel.write(
                    new ByteBuffer[]{byteBuffer,byteBuffer1});
            byteBuffer1.clear();
            byteBuffer.clear();
            //6、关闭通道
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
