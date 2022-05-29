package fun.aniss.netty.buffer;

import java.nio.ByteBuffer;

import static fun.aniss.netty.util.ByteBufferUtil.debugAll;
import static fun.aniss.netty.util.ByteBufferUtil.debugRead;

/**
 * @author TooAndy
 * date 2022/5/23 23:00
 */
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put((byte) 0x61);
        debugAll(buffer);
        buffer.put(new byte[]{0x62, 0x63, 0x64});
        debugAll(buffer);
        buffer.flip();
        byte b = buffer.get();
        debugRead(buffer);
    }
}
