package fun.aniss.netty.c1;

import java.nio.ByteBuffer;

/**
 * @author TooAndy
 * date 2022/5/28 23:05
 */
public class TestByteBufferAllocate {

    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        ByteBuffer buffer = ByteBuffer.allocateDirect(16);
        // java.nio.HeapByteBuffer: JVM 堆内存, 读写效率比较低, 会受到 GC 的影响
        System.out.println(allocate.getClass());
        // java.nio.DirectByteBuffer: 系统直接内存, 读写效率高, 不会受到 GC 的影响
        System.out.println(buffer.getClass());
    }

}
