package classes;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 *  结论：
 *      1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 *      2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 *
 * @author zzq
 * @creat 2020-06-01 9:54
 */
public class FileInputOutputStreamTest {


    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void testFileInputStream() {
        FileInputStream fileInputStream = null;
        try {
            //1. 造文件
            File file = new File("Hello.txt");

            //2.造流
            fileInputStream = new FileInputStream(file);

            //3.读数据
            byte[] bytes = new byte[5];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                String s = new String(bytes, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                if(fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /*
        实现对图片的复制操作
    */
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file1 = new File("爱情与友情.jpg");
            File file2 = new File("爱情与友情（副本2）.jpg");

            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);

            byte[] bytes = new byte[5];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileOutputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(String srcPath,String destPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File src = new File(srcPath);
            File dest = new File(destPath);

            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(dest);

            byte[] bytes = new byte[1024];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileOutputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "";
        String destPath = "";
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }
}
