package fun.aniss.netty.buffer;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author TooAndy
 * date 2022/5/23 22:10
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("src/main/resources/data/data.txt", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                // 向 buffer 写入
                int len = channel.read(buffer);
                log.debug("读到字节数：{}", len);
                if (len == -1) {
                    break;
                }
                // 切换 buffer 读模式
                buffer.flip();
                while (buffer.hasRemaining()) {
                    log.debug("{}", (char) buffer.get());
                }
                // 切换 buffer 写模式
                buffer.clear();
            }
        } catch (IOException e) {
            log.error("error.", e);
        }
    }
}