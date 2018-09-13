package designPattern.SocketTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @title: moral-edu-service
 * @copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved
 * @company: http://www.hanboard.com
 * @author: Young
 * @desc: 德育系统
 * @date: Created at 5/22 0022 10:59
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(8001);
        System.out.println("服务器已启动,等待连接...");
        byte[] recieveData = new byte[1024];
        DatagramPacket serverPacket = new DatagramPacket(recieveData, recieveData.length);
        serverSocket.receive(serverPacket);
        String clientMsg = new String(recieveData, 0, serverPacket.getLength(), "UTF-8");
        System.out.println("客户端说: " + clientMsg);

        byte[] serverData = "欢迎你,客户端!".getBytes();
        InetAddress clientAddress = serverPacket.getAddress();
        int clientPort = serverPacket.getPort();
        DatagramPacket clientPacket = new DatagramPacket(serverData, serverData.length, clientAddress, clientPort);
        serverSocket.send(clientPacket);

    }
}
