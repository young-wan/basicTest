package designPattern.SocketTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**

 * @author: Young
 * @desc:
 * @date: Created at 5/22 0022 10:59
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        // 定义服务器的ip,端口
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int port = 8001;
        // 定义要发送给服务器的数据
        byte[] clientData = "你好,服务器,我是客户端!".getBytes("UTF-8");
        // 创建数据报,包含要发送的全部数据信息
        DatagramPacket clientPacket = new DatagramPacket(clientData, clientData.length, serverAddress, port);
        // 创建DatagramSocket对象
        DatagramSocket clientSocket = new DatagramSocket();
        // 向服务器发送数据
        clientSocket.send(clientPacket);

        // 创建数据报,用于接收服务器端发来的数据
        byte[] serverData = new byte[1024];
        DatagramPacket serverPacket = new DatagramPacket(serverData, serverData.length);
        // 接收数据
        clientSocket.receive(serverPacket);
        // 读取数据
        String serverMsg = new String(serverData, 0, serverPacket.getLength());
        System.out.println("这里是客户端,服务器说: " + serverMsg);
    }
}
