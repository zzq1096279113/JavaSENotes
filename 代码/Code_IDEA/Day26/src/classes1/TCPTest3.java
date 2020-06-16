package classes1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 *
 * @author zzq
 * @creat 2020-06-02 16:12
 */
public class TCPTest3 {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket("127.0.0.1",8848);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream("beauty.jpg");
            byte[] bytes1 = new byte[1024];
            int len1;
            while ((len1 = fileInputStream.read(bytes1)) != -1){
                outputStream.write(bytes1,0,len1);
            }
            socket.shutdownOutput();
            //接收来自于服务器端的数据，并显示到控制台上
            inputStream = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes2 = new byte[20];
            int len2;
             while ((len2 = inputStream.read(bytes2)) != -1){
                 baos.write(bytes2,0,len2);
             }
            System.out.println(baos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        }
    }



    //服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(8848);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            fileOutputStream = new FileOutputStream("beauty（副本1）.jpg");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
            //服务器端给予客户端反馈
            System.out.println("图片传输完成");
            outputStream = accept.getOutputStream();
            outputStream.write("你好，世界！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
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
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
