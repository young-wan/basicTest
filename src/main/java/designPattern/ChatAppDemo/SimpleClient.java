package designPattern.ChatAppDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @title: wechat-service
 * @author: Young
 * @desc: 微信
 * @date: Created at 8/31 0031 11:17
 */
public class SimpleClient {
    public static void main(String[] args) throws IOException {


        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader sys = new BufferedReader(new InputStreamReader(System.in));

            String inMsg = null;
            String outMsg = null;
            String promptMsg = "Please enter a  message  (Bye  to quit):";
            System.out.println(promptMsg);


            while ((inMsg = sys.readLine()) != null) {
                if (inMsg.equalsIgnoreCase("bye")) {
                    break;
                }
                bw.write("client says: " + inMsg + "\n");
                bw.flush();
                outMsg = br.readLine();
                System.out.println("msg from server: " + outMsg);
                System.out.println(promptMsg);
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
