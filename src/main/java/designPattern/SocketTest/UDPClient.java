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
public class UDPClient {
    public static void main(String[] args) throws IOException {
        byte[] clientData = "你好,服务器,我是客户端!".getBytes("UTF-8");
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int port = 8001;
        DatagramPacket clientPacket = new DatagramPacket(clientData, clientData.length, serverAddress, port);
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.send(clientPacket);

        byte[] serverData = new byte[1024];
        DatagramPacket serverPacket = new DatagramPacket(serverData, serverData.length);
        clientSocket.receive(serverPacket);
        String serverMsg = new String(serverData, 0, serverPacket.getLength());
        System.out.println("这里是客户端,服务器说: " + serverMsg);
    }
}
