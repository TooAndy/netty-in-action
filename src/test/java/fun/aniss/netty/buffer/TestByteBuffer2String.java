package fun.aniss.netty.buffer;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static fun.aniss.netty.util.ByteBufferUtil.debugAll;

/**
 * ByteBuffer <--> String
 *
 * @author TooAndy
 * date 2022/5/28 23:21
 */
public class TestByteBuffer2String {

    @Test
    public void string2ByteBuffer() {
        // 1. String 2 ByteBuffer, 生成后, 是默认的写模式
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("hello".getBytes());
        debugAll(buffer);

        // 2. use Charset, 会自动转换为读模式.
        ByteBuffer world = StandardCharsets.UTF_8.encode("world");
        debugAll(world);

        // 3. wrap
        ByteBuffer buffer1 = ByteBuffer.wrap("helloworld".getBytes());
        debugAll(buffer1);

    }


    @Test
    public void byteBuffer2String() {
        //1.  这种方式, 输出的 buffer 是读模式的.
        ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");
        // 可以直接使用 decode 转换成 String
        String s = StandardCharsets.UTF_8.decode(hello).toString();
        System.out.println(s);

        // 2. 新建 buffer 后, 用 put 方法. 这种方式写完后, 是写模式. 因此需要用 flip 进行转换
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd', 'e'});
        // 使用 flip() 转换为 读模式
        buffer.flip();
        System.out.println(StandardCharsets.UTF_8.decode(buffer));
    }
}
