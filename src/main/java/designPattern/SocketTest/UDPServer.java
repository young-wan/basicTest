package designPattern.SocketTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author: Young
 * @desc:
 * @date: Created at 5/22 0022 10:59
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器端DatagramSocket并指定端口
        DatagramSocket serverSocket = new DatagramSocket(8001);
        System.out.println("服务器已启动,等待连接...");
        byte[] receiveData = new byte[1024];
        // 定义DatagramPacket数据报用于接收数据
        DatagramPacket serverPacket = new DatagramPacket(receiveData, receiveData.length);
        // 接收客户端发送的数据
        serverSocket.receive(serverPacket);
        // 读取数据
        String clientMsg = new String(receiveData, 0, serverPacket.getLength(), "UTF-8");
        System.out.println("客户端说: " + clientMsg);

        // 定义发送的数据byte[]字节数组
        byte[] serverData = "欢迎你,客户端!".getBytes();
        // 定义客户端的ip地址和端口号
        InetAddress clientAddress = serverPacket.getAddress();
        int clientPort = serverPacket.getPort();
        // 创建数据报,包含响应的数据信息,接受者ip地址和端口号
        DatagramPacket clientPacket = new DatagramPacket(serverData, serverData.length, clientAddress, clientPort);
        // 响应客户端
        serverSocket.send(clientPacket);
    }

    public static void startUDPServer() {
        try {
            DatagramSocket serverGram = new DatagramSocket(7777);
            byte[] receiveBytes = new byte[1024];
            DatagramPacket serverPacket = new DatagramPacket(receiveBytes, receiveBytes.length);
            serverGram.receive(serverPacket);
            String receiveMsg = new String(receiveBytes, 0, receiveBytes.length, "UTF-8");
            System.out.println("client msg ----" + receiveMsg);

            InetAddress clientAddress = serverPacket.getAddress();
            int clientPort = serverPacket.getPort();
            String sendMsg = "服务器的回应";
            DatagramPacket sendPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.getBytes().length,
                    clientAddress, clientPort);
            serverGram.send(sendPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
