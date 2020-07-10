package exer;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 练习3:获取文本上字符出现的次数,把数据写入文件
 *
 * 思路：
 * 1.遍历文本每一个字符
 * 2.字符出现的次数存在Map中
 *
 * Map<Character,Integer> map = new HashMap<Character,Integer>();
 * map.put('a',18);
 * map.put('你',2);
 *
 * 3.把map中的数据写入文件
 *
 * @author zzq
 * @creat 2020-06-01 14:48
 */
public class WordCount {
    @Test
    public void test() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            HashMap<Character, Integer> map = new HashMap<>();
            fileReader = new FileReader("dbcp.txt");
            fileWriter = new FileWriter("WordCount.txt");
            int len;
            while((len = fileReader.read()) != -1){
                char chars = (char)len;
                if(map.get(chars) == null){
                    map.put(chars,1);
                }else{
                    map.put(chars,map.get(chars) + 1);
                }
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()){
                Map.Entry<Character, Integer> next = iterator.next();
                switch (next.getKey()) {
                    case ' ':
                        fileWriter.write("空格=" + next.getValue());
                        break;
                    case '\t'://\t表示tab 键字符
                        fileWriter.write("tab键=" + next.getValue());
                        break;
                    case '\r'://
                        fileWriter.write("回车=" + next.getValue());
                        break;
                    case '\n'://
                        fileWriter.write("换行=" + next.getValue());
                        break;
                    default:
                        fileWriter.write(next.getKey() + "=" + next.getValue());
                        break;
                }
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
