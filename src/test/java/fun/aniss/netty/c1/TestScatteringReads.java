package fun.aniss.netty.c1;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author TooAndy
 * date 2022/5/28 23:32
 */
public class TestScatteringReads {
    @Test
    public void reads() {
        try (FileInputStream inputStream = new FileInputStream("src/main/resources/data/words.txt")) {
            FileChannel channel = inputStream.getChannel();
            ByteBuffer buffer1 = ByteBuffer.allocate(3);
            ByteBuffer buffer2 = ByteBuffer.allocate(3);
            ByteBuffer buffer3 = ByteBuffer.allocate(5);

            channel.read(new ByteBuffer[]{buffer1, buffer2, buffer3});

            // 不要忘了切换为读模式
            buffer1.flip();
            buffer2.flip();
            buffer3.flip();

            System.out.println(StandardCharsets.UTF_8.decode(buffer1));
            System.out.println(StandardCharsets.UTF_8.decode(buffer2));
            System.out.println(StandardCharsets.UTF_8.decode(buffer3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
