package fun.aniss.netty.c1;

import java.nio.ByteBuffer;

import static fun.aniss.netty.c1.ByteBufferUtil.debugRead;

/**
 * @author TooAndy
 * date 2022/5/28 23:11
 */
public class TestByteBufferRead {
    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd', 'e'});
        // 切换到读模式
        buffer.flip();
        debugRead(buffer);
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get(1));
        // 从头开始读
        buffer.rewind();
        buffer.get(new byte[3]);
        System.out.println((char) buffer.get());

        // mark, position: e
        buffer.mark();
        System.out.println((char) buffer.get());
        // reset position to e
        buffer.reset();
        // get 'e'
        System.out.println((char) buffer.get());
    }
}
