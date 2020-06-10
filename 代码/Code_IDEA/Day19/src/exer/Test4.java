package exer;

/**
 * 获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodefabcdef";str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 *
 * @author zzq
 * @creat 2020-05-26 14:16
 */
public class Test4 {
    public static void main(String[] args) {
        Test4 t = new Test4();
        String str1 = "abcwerthelloyuiodefabcdef";
        String str2 = "cvhellobnm";
        String s = t.getMaxSameString(str1, str2);
        System.out.println(s);
    }

    public String getMaxSameString(String s1, String s2) {
        String maxStr = s1.length() >= s2.length() ? s1 : s2;
        String minStr = s1.length() < s2.length() ? s1 : s2;
        int l = minStr.length();
        for (int i = 0; i < l; i++) {
            for (int x = 0, y = l - i; y <= l; x++, y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr))
                    return subStr;
            }
        }
        return null;
    }

}
