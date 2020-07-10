package classes;

import org.junit.jupiter.api.Test;

/**
 *
 * @author zzq
 * @creat 2020-05-25 16:14
 */
public class StringMethodTest {

    /*
    int length()：返回字符串的长度： return value.length
    char charAt(int index)： 返回某索引处的字符return value[index]
    boolean isEmpty()：判断是否是空字符串：return value.length == 0
    String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
    String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
    String trim()：返回字符串的副本，忽略前导空白和尾部空白
    boolean equals(Object obj)：比较字符串的内容是否相同
    boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
    String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
    int compareTo(String anotherString)：比较两个字符串的大小
    String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
    String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
    */
    @Test
    public void test1(){
        String s1 = "hello world";
        System.out.println(s1.length());//10

        System.out.println(s1.charAt(2));//l

        String s2 = "";
        System.out.println(s2.isEmpty());//由length判断是否为空

        String s3 = s1.toLowerCase();//全部转换为小写
        System.out.println(s1);//hello world
        System.out.println(s3);//hello world

        String s4 = "       He  l l o Wor  ld   ";
        String s5 = s4.trim();//忽略前导空格和尾部空格
        System.out.println("----" + s4 + "----");//----       He  l l o Wor  ld   ----
        System.out.println("----" + s5 + "----");//----He  l l o Wor  ld----

        String s6 = "HELLO WORLD";
        System.out.println(s1.equals(s6));//比较字符串的内容是否相同
        System.out.println(s1.equalsIgnoreCase(s6));//比较字符串的内容是否相同，忽略大小写

        String s7  = "abc";
        String s8 = s7.concat("def");//等价于用“+”
        System.out.println(s8);//abcdef

        String s9 = "abe";
        System.out.println(s7.compareTo(s9));//比较两个字符串的大小

        String s10 = "北京市密云区";
        String s11 = s10.substring(3);
        System.out.println(s11);//密云区

        String s12 = s10.substring(2, 5);
        System.out.println(s12);//市密云
    }


    /*
    boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
    boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
    boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
    */
    @Test
    public void test2(){
        String s1 = "helloworld";
        boolean b1 = s1.endsWith("ld");//判断是否以"ld"结尾的
        System.out.println(b1);

        boolean b2 = s1.startsWith("He");//判断是否以"He"开始的
        System.out.println(b2);

        boolean b3 = s1.startsWith("ll", 2);//判断从开始[2]是否以"ll"开始的
        System.out.println(b3);
    }


    /*
    boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
    int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
    int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
    int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
    int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
        注：indexOf和lastIndexOf方法如果未找到都是返回-1
    */
    @Test
    public void test3(){
        String s1 = "helloworld";
        String s2 = "wo";
        System.out.println(s1.contains(s2));//判断当前字符串是否包含s2字符串

        System.out.println(s1.indexOf("ll"));//返回指定子字符串在此字符串中第一次出现处的索引
        System.out.println(s1.indexOf("lol"));

        System.out.println(s1.indexOf("lo", 5));//从指定的索引开始，返回指定子字符串在此字符串中第一次出现处的索引
        System.out.println(s1.indexOf("lo", 2));

        String s3 = "hellorworld";
        System.out.println(s3.lastIndexOf("or"));
        System.out.println(s3.lastIndexOf("or",6));//从指定的索引开始反向搜索。

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str。情况二：不存在str
    }


    /*
    替换：
        String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
        String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
        String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
        String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
    匹配:
        boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
    切片：
        String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
        String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     */
    @Test
    public void test4(){
        String s1 = "北京市密云区北京";

        String s2 = s1.replace('北', '东');
        System.out.println(s2);

        String s3 = s1.replace("北京","上海");
        System.out.println(s3);
        System.out.println("***************************");

        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", "，").replaceAll("^，|，$", "");
        System.out.println(string);
        System.out.println("***************************");

        str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);
        System.out.println("***************************");

        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] + " ");
        }
        System.out.println();
        String str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.print(strs2[i] + " ");
        }
    }
}
