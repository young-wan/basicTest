package designPattern.SocketTest;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: Young
 * @desc:
 * @date: Created at 5/21 0021 17:47
 */
public class Server {
    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        int port = 7777;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("启动服务器...");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "已连接到服务器...");
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String clientInfo = br.readLine();
                if (StringUtils.isNotBlank(clientInfo)) {
                    System.out.println("客户端说: " + clientInfo);
                }
//                String sendInfo = scanner.next();
//                if (StringUtils.isNotBlank(sendInfo)) {
//                    // 一定要加 \n 表示结束此行输入,否则无法正常消息传输
//                    bw.write(sendInfo + "\n");
//                    bw.flush();
//                }

                // 一定要加 \n 表示结束此行输入,否则无法正常消息传输
                bw.write(clientInfo + "\n");
//                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
