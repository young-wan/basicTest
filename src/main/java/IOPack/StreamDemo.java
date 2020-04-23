package IOPack;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * WeChat
 * {description}
 *
 * @author Young
 * @date 2020-04-23 9:52
 **/
public class StreamDemo {
    static String inPath = "D:/StreamDemo.txt";
    static String outPath = "D:/StreamDemoCopy.txt";
    static String inPath2 = "D:/render.dat";
    static String inPath3 = "D:/shuihu.jpg";
    static String outPath3 = "D:/shuihuDemo.jpg";

    public static void main(String[] args) {
//        readFromFile(inPath3);
//        copyFromFile(inPath3, outPath3);
//        bufferFromFile();
//        bufferFileCopy();
        propFile();
    }

    public static void readFromFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                System.out.println(new String(bytes, StandardCharsets.UTF_8));
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFromFile(String inPath, String outPath) {
        try {
            FileInputStream fis = new FileInputStream(inPath);
            FileOutputStream fos = new FileOutputStream(outPath);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                System.out.println("打印输入信息: " + new String(bytes, 0, len));
                fos.write(bytes, 0, len);
            }
            //  追加数据
//            fos.write("\nappend file".getBytes());
            fos.flush();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inPath2));
            char[] chars = new char[1024];
            int len;
            while ((len = br.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferFileCopy() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inPath3));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outPath3));
            char[] chars = new char[1024];
            int len;
            while ((len = br.read(chars)) != -1) {
                bw.write(chars, 0, len);
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void propFile() {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("E:\\MyProject\\JavaProject\\basicTest\\src\\main\\resources\\log4j.properties");
            props.load(fis);
            System.out.println(props.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
