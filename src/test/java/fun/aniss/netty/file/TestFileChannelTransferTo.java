package fun.aniss.netty.file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author TooAndy
 * date 2022/5/29 22:53
 */
public class TestFileChannelTransferTo {

    @Test
    public void transfer2() {
        try (FileChannel fromChannel = new FileInputStream("D:\\Videos\\Hollow Knight 2022-01-29 11-33-34.mp4").getChannel();
             FileChannel toChannel = new FileOutputStream("D:\\Videos\\Hollow Knight 2022-01-29 11-33-341111.mp4").getChannel()) {

            // fromChannel.transferTo(0, fromChannel.size(), toChannel);

            long size = fromChannel.size();
            for (long left = size; left > 0; ) {
                left -= fromChannel.transferTo(size - left, left, toChannel);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
