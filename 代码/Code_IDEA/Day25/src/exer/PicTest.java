package exer;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zzq
 * @creat 2020-06-01 14:35
 */
public class PicTest {

    //图片的加密
    @Test
    public void test1() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("爱情与友情.jpg");
            fileOutputStream = new FileOutputStream("爱情与友情（加密）.jpg");
            byte[] bytes = new byte[20];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                //字节数据修改
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null)
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    //图片的解密
    @Test
    public void test2() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("爱情与友情（加密）.jpg");
            fileOutputStream = new FileOutputStream("爱情与友情（解密）.jpg");
            byte[] bytes = new byte[20];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                //字节数据修改
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null)
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
