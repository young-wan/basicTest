package IOPack;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;

/**
 * @Author young
 * @Date 2020/7/22 14:00
 * @Desc
 **/
public class NIODemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(20);
        Channel channel;
        buffer.put(new byte[1024]);
    }
}
