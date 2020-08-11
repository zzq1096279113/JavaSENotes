package kmp;

/**
 * @Description KMP算法
 * @ClassName KMP
 * @Author zzq
 * @Date 2020/8/11 17:07
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int index = kmpSearch(str1, str2);
        if (index != -1)
            System.out.println("找到索引为：" + index);
        else
            System.out.println("不存在");
    }

    public static int kmpSearch(String str1, String str2) {
        int[] match = partialMatch(str2);
        return kmpSearch(str1, str2, match);
    }

    /**
     * @Description 获得字符串的部分匹配表
     * @Param [str]
     * @Return int[]
     * @Author zzq
     * @Date 2020/8/11 19:03
     */
    public static int[] partialMatch(String str) {
        int[] match = new int[str.length()];    //用于保存部分匹配值
        match[0] = 0;   //只有一个字符，部分匹配值必定为0
        for (int i = 1, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = match[j - 1];
            if (str.charAt(i) == str.charAt(j))
                j++;
            match[i] = j;
        }
        return match;
    }

    /**
     * @Description 根据传入的字符串以及部分匹配值数组，返回第一次索引
     * @Param [str1, str2, match]
     * @Return int
     * @Author zzq
     * @Date 2020/8/11 19:11
     */
    public static int kmpSearch(String str1, String str2, int[] match) {
        for (int i = 0, j = 0; i < str1.length(); i++) {    //遍历长字符串
            while (j > 0 && str1.charAt(i) != str2.charAt(j))
                j = match[j - 1];
            if (str1.charAt(i) == str2.charAt(j))    //匹配到第一个字符
                j++;
            if (j == str2.length())
                return i - j + 1;
        }
        return -1;
    }
}
