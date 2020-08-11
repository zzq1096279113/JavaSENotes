package kmp;

/**
 * @Description 暴力匹配法
 * @ClassName ViolenceMatch
 * @Author zzq
 * @Date 2020/8/11 16:15
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "JavaLoveJaLoveJavaLoveJava";
        String str2 = "JavaLoveJava";
        int i = violenceMatch(str1, str2);
        System.out.println(i);
    }

    /**
     * @Description 在str1中暴力匹配str2
     * @Param [str1, str2]
     * @Return int
     * @Author zzq
     * @Date 2020/8/11 16:36
     */
    public static int violenceMatch(String str1, String str2) {
        int i = 0;
        int j = 0;
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        while (i < c1.length && j < c2.length) {    //保证匹配时不越界
            if (c1[i] == c2[j]) {    //匹配上第一个字符
                i++;
                j++;
            } else {    //没有匹配成功
                i = i - (j - 1);    //i移动
                j = 0;
            }
        }
        if (j == c2.length)   //判断是否匹配成功
            return i - j;
        else
            return -1;
    }
}
