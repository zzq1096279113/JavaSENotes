package classes;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @author zzq
 * @creat 2020-05-25 17:18
 */
public class StringTest1 {


    /*
    String 与基本数据类型、包装类之间的转换。
        String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
        基本数据类型、包装类 --> String：调用String重载的valueOf(xxx)
    */
    @Test
    public void test1() {
        String s1 = "123";
        int num = Integer.parseInt(s1);

        String s2 = String.valueOf(num);
        String s3 = num + "";
    }


    /*
    String 与 char[]之间的转换
        String --> char[]:调用String的toCharArray()
        char[] --> String:调用String的构造器
    */
    @Test
    public void test2() {
        String s1 = "abcdef123456";

        char[] c1 = s1.toCharArray();//String --> char[]
        for (int i = 0; i < c1.length; i++) {
            System.out.print(c1[i] + " ");
        }
        System.out.println();

        char[] c2 = new char[]{'h', 'e', 'l', 'l', 'o'};
        String s2 = new String(c2);//char[] --> String
        System.out.println(s2);
    }


    /*
    String 与 byte[]之间的转换
        编码：String --> byte[]:调用String的getBytes()
        解码：byte[] --> String:调用String的构造器

    编码：字符串 -->字节  （看得懂 --->看不懂的二进制数据）
    解码：字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）

    说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abcdef123456中国北京";
        byte[] b1 = s1.getBytes();//String --> byte[]
        System.out.println(Arrays.toString(b1));

        byte[] b2 = s1.getBytes("gbk");
        System.out.println(Arrays.toString(b2));

        String s2 = new String(b1);//char[] --> String
        System.out.println(s2);

        String s3 = new String(b2, "gbk");
        System.out.println(s3);
    }
}
