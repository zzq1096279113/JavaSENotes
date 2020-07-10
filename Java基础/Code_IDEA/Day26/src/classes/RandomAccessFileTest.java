package classes;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 *
 * 1.RandomAccessFile 直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 *
 * 2.RandomAccessFile 既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.RandomAccessFile 作为输出流时：如果写出到的文件如果不存在，则在执行过程中自动创建。
 *                                 如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * 4.可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * @author zzq
 * @creat 2020-06-02 10:18
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile1 = new RandomAccessFile("爱情与友情.jpg", "r");
            randomAccessFile2 = new RandomAccessFile("爱情与友情（副本）.jpg", "rw");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = randomAccessFile1.read(bytes)) != -1) {
                randomAccessFile2.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test2() {
        RandomAccessFile rw = null;
        try {
            File file = new File("Hello.txt");
            rw = new RandomAccessFile(file, "rw");
            rw.seek(file.length());//将指针调到角标为3的位置
            rw.write("xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() {
        RandomAccessFile rw = null;
        try {
            File file = new File("Hello.txt");
            rw = new RandomAccessFile(file, "rw");
            rw.seek(3);
            StringBuilder stringBuilder = new StringBuilder((int) file.length());
            byte[] bytes = new byte[20];
            int len;
            while ((len = rw.read(bytes)) != -1){
                stringBuilder.append(new String(bytes,0,len));
            }
            rw.seek(3);
            rw.write("xyz".getBytes());
            rw.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
