package cn.eros.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * NIO file channel demo.
 * <p>Create time: 2020/5/13 22:42</p>
 *
 * @author 周光兵
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("build/data.txt");

        try (
                // 获取文件输出流
                RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
                // 获取文件通道
                FileChannel fileChannel = accessFile.getChannel()) {

            // 创建缓冲区
            ByteBuffer buffers = ByteBuffer.allocate(1024);
            String strPut = "java nio " + LocalDateTime.now();
            buffers.put(strPut.getBytes());
            // 此处必须调用此方法
            buffers.flip();
            fileChannel.write(buffers);

            buffers.clear();
            fileChannel.read(buffers);

            String strRead = new String(buffers.array(), buffers.position(), buffers.limit(), StandardCharsets.UTF_8);

            System.out.println(buffers);
            System.out.println(strRead.trim());
        }

    }
}
