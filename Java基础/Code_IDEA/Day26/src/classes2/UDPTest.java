package classes2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *  UDPd协议的网络编程
 *
 * @author zzq
 * @creat 2020-06-02 16:35
 */
public class UDPTest {
    //发送端
    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String s = "Hello JavaSE";
            byte[] data = s.getBytes();
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(data,data.length,byName,9090);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null)
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }



    //接收端
    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9090);

            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null)
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
