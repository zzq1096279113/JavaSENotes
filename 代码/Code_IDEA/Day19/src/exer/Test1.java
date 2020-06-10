package exer;

/**
 * @author zzq
 * @creat 2020-05-26 8:28
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        String s1 = "       He  l l o Wor  ld   ";
        String s2 = t.trimTest(s1);
        System.out.println("----" + s1 + "----");
        System.out.println("----" + s2 + "----");
    }

    public String trimTest(String string) {
        if (string != null) {
            int start = 0;
            int end = string.length() - 1;
            while (start < end && string.charAt(start) == ' ') {
                start++;
            }
            while (start < end && string.charAt(end) == ' ') {
                end--;
            }
            if (string.charAt(start) == ' ') {
                return "";
            }
            return string.substring(start, end + 1);
        }
        return null;
    }
}


