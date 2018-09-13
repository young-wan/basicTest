package designPattern.ChatAppDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @title: wechat-service
 * @author: Young
 * @desc: 微信
 * @date: Created at 8/31 0031 11:17
 */
public class SimpleServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader sys = new BufferedReader(new InputStreamReader(System.in));

            String inMsg = null;
            while ((inMsg = br.readLine()) != null) {
                System.out.println("msg from client: " + inMsg);
//                String outMsg = sys.readLine();
                String outMsg = inMsg;
                bw.write("server says: " + outMsg + "\n");
                bw.flush();
            }



            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
