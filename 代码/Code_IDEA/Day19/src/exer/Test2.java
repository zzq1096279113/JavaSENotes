package exer;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 *
 * @author zzq
 * @creat 2020-05-26 8:29
 */
public class Test2 {
    public static void main(String[] args) {
        String s1 = "abcdefg";
        Test2 t = new Test2();
        String s2 = t.reverse1(s1, 1, 5);
        System.out.println(s2);

    }

    //方式一：
    public String reverse1(String string, int start, int end) {
        if(string != null){
            char[] chars = string.toCharArray();
            for (int i = start, j = end; i < j; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            return new String(chars);
        }
        return null;
    }

    //方式二：
    public String reverse2(String string, int start, int end) {
        String a = string.substring(0, start);
        String b = string.substring(start,end);
        String c = string.substring(end);
        StringBuffer sb = new StringBuffer(b);
        sb.reverse();
        return a + sb + c;
    }

}
