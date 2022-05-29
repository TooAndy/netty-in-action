package fun.aniss.netty.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author TooAndy
 * date 2022/5/28 23:39
 */
public class TestGatheringWrites {

    public static void main(String[] args) {
        ByteBuffer b1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer b2 = StandardCharsets.UTF_8.encode("netty");
        ByteBuffer b3 = StandardCharsets.UTF_8.encode("soHard");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/data/words2.txt", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.write(new ByteBuffer[]{b1, b2, b3});
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
