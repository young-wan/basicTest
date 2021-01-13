package designPattern.SocketTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: Young
 * @date: Created at 5/21 0021 17:47
 */
public class Client {
    public static void main(String[] args) {
        startClient();
    }

    public static void startClient() {
        String address = "127.0.0.1";
        int port = 7777;
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                Socket socket = new Socket(address, port);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("请输入消息：");
                String sendInfo = scanner.next();
                // 一定要加 \n 表示结束此行输入,否则无法正常消息传输
                bw.write(sendInfo + "\n");
//                bw.flush();
                String serverInfo = br.readLine();
                System.out.println("服务器说: " + serverInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
