package exer;

/**
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数
 *
 * @author zzq
 * @creat 2020-05-26 8:29
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        String s1 = "abkkcadkabkebfkaabkskab";
        String s2 = "ab";
        int count = t.getCount(s1, s2);
        System.out.println(count);

    }

    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength) {
            //方式一：
//            while((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subLength);
//            }

            //方式二：
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;
            }
            return count;
        } else {
            return -1;
        }
    }
}
