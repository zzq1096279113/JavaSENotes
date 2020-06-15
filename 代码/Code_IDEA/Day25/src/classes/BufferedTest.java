package classes;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 *  1.缓冲流：
 *      BufferedInputStream
 *      BufferedOutputStream
 *      BufferedReader
 *      BufferedWriter
 *
 *  2.作用：提供流的读取、写入的速度
 *    提高读写速度的原因：内部提供了一个缓冲区
 *
 *  3. 处理流，就是“套接”在已有的流的基础上。
 *
 * @author zzq
 * @creat 2020-06-01 10:33
 */
public class BufferedTest {
    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.造文件
            File file1 = new File("爱情与友情.jpg");
            File file2 = new File("爱情与友情（副本3）.jpg");

            //2.1 造节点流
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            //2.2 造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3.复制的细节
            byte[] bytes = new byte[10];
            int len;
            while((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭    要求：先关闭外层的流，再关闭内层的流
            try {
                if(bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fileInputStream.close();
//        fileOutputStream.close();
    }


    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2.1 造节点流
            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3.复制的细节
            byte[] bytes = new byte[1024];
            int len;
            while((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭    要求：先关闭外层的流，再关闭内层的流
            try {
                if(bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();
        String srcPath = "";
        String destPath = "";
        copyFileWithBuffered(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }



    /*
        使用BufferedReader和BufferedWriter实现文本文件的复制
    */
    @Test
    public void testBufferedReaderBufferedWriter() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //创建文件和相应的流
            bufferedReader = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("dbcp（副本）.txt")));

            //读写操作
            //方式一：
//            char[] chars = new char[1024];
//            int len;
//            while((len = bufferedReader.read(chars)) != -1){
//                bufferedWriter.write(chars,0,len);
//            }
            //方式二：
            String data;
            while((data = bufferedReader.readLine()) != null){
                bufferedWriter.write(data + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if(bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
