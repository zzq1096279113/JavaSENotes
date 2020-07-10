package classes1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 * @author zzq
 * @creat 2020-06-02 14:29
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            socket = new Socket("127.0.0.1", 8899);

            //2.获取一个输出流，用于输出数据
            outputStream = socket.getOutputStream();

            //3.写出数据的操作
            outputStream.write("Hello World!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    //服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8899);

            //2.调用accept()表示接收来自于客户端的socket
            accept = serverSocket.accept();

            //3.获取输入流
            inputStream = accept.getInputStream();

            int len;
            byte[] bytes = new byte[10];
            //不建议：可能会有乱码
//        while ((len = inputStream.read(bytes)) != -1){
//            String s = new String(bytes, 0, len);
//            System.out.print(s);
//        }
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            while ((len = inputStream.read(bytes)) != -1){
                baos.write(bytes,0,len);
            }
            System.out.println(baos);
            System.out.println("收到了来自于：" + accept.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            if(baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
