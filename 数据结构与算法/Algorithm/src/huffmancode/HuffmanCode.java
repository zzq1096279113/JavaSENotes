package huffmancode;

import java.util.*;


/**
 * @Description 哈夫曼编码
 * @ClassName HuffmanCode
 * @Author zzq
 * @Date 2020/8/7 10:35
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        byte[] zip = Huffman.huffmanZip(bytes);
        System.out.println(Arrays.toString(zip));
    }
}

