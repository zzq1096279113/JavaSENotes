package classes;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *  一、流的分类：
 *      1.操作数据单位：字节流、字符流
 *      2.数据的流向：输入流、输出流
 *      3.流的角色：节点流、处理流
 *
 *  二、流的体系结构
 *      抽象基类        节点流（或文件流）                               缓冲流（处理流的一种）
 *      InputStream     FileInputStream (read(byte[] bytes))            BufferedInputStream (read(byte[] bytes))
 *      OutputStream    FileOutputStream (write(byte[] bytes,0,len)     BufferedOutputStream (write(byte[] bytes,0,len) / flush()
 *      Reader          FileReader (read(char[] chars))                 BufferedReader (read(char[] chars)) / readLine())
 *      Writer          FileWriter (write(char[] chars,0,len)           BufferedWriter (write(char[] chars,0,len) / flush()
 *
 * @author zzq
 * @creat 2020-06-01 8:08
 */
public class FileReaderWriterTest {


    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台
        1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
        2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
        3. 读入的文件一定要存在，否则就会报FileNotFoundException。

    */
    @Test
    public void FileReaderWriterTest () {
        FileReader fileReader = null;
        try {
            //1.实例化File文件，指明操作的文件
            File file = new File("Hello.txt");//当前moudle

            //2.提供具体的流
            fileReader = new FileReader(file);

            //3.数据的读入
            //方式一：
//        int read = fileReader.read();//read():返回读入的一个字符。如果达到文件末尾，返回-1
//        while (read != -1){
//            System.out.print((char) read + " ");
//            read = fileReader.read();
//        }
            //方式二：
            int data;
            while((data = fileReader.read()) != -1){
                System.out.print((char) data + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader() {
        FileReader fileReader = null;
        try {
            //1.File类的实例化
            File file = new File("Hello.txt");

            //2.FileReader流的实例化
            fileReader = new FileReader(file);

            //3.读入的操作
            //read(char[] chars):返回每次读入chars数组中的字符的个数。如果达到文件末尾，返回-1
            char[] chars = new char[8];
            int len;
            while((len = fileReader.read(chars)) != -1){
                //方式一：
                //错误写法
//                for (int i = 0; i < chars.length; i++) {
//                    System.out.print(chars[i]);
//                }
                //正确写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(chars[i]);
//                }

                //方式二：
                //错误的写法,对应着方式一的错误的写法
//                String str = new String(chars);
//                System.out.print(str);
                //正确的写法
                String str = new String(chars,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.资源的关闭
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    /*
    从内存中写出数据到硬盘的文件里。
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2. File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
       File对应的硬盘中的文件如果存在：
            如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
            如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
    */
    @Test
    public void testFileReader1() {
        FileWriter fileWriter = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("Dream.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fileWriter = new FileWriter(file,true);

            //3.写出的操作
            fileWriter.write("I have a dream!\n");
            fileWriter.write("Hopeful and promising\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if(fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Test
    public void testFileReaderFileWriter() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File file1 = new File("Hello.txt");
            File file2 = new File("CopyFile.txt");

            //不能使用字符流来处理图片等字节数据
//            File file1 = new File("爱情与友情.jpg");
//            File file2 = new File("爱情与友情（副本1）.jpg");

            //2.创建输入流和输出流的对象
            fileReader = new FileReader(file1);
            fileWriter = new FileWriter(file2);

            //3.数据的读入和写出操作
            char[] chars = new char[5];
            int len;
            while((len = fileReader.read(chars)) != -1){
                fileWriter.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if(fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
