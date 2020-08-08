package huffmancode;

/**
 * @Description 哈夫曼编码压缩与解压
 * @ClassName HuffmanCode
 * @Author zzq
 * @Date 2020/8/7 10:35
 */
public class HuffmanCode {

    public static void main(String[] args) {
//        String content = "i like like like java do you like a java";
//        byte[] bytes = content.getBytes();
//        byte[] zip = Huffman.huffmanZip(bytes);
//        byte[] decode = Huffman.decode(zip,Huffman.huffmanCodes);
//        System.out.println(new String(decode));
//        String srcFile = "F:\\Java数据结构和算法.pptx";
//        String dstFile = "F:\\Java数据结构和算法.zip";
//        Huffman.zipFile(srcFile,dstFile);
//        System.out.println("压缩完毕");
        String srcFile = "F:\\Java数据结构和算法.zip";
        String dstFile = "F:\\Java数据结构和算法.pptx";
        Huffman.decodeFile(srcFile, dstFile);
        System.out.println("解压完毕");
    }
}

