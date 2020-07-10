package classes;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * 1. System类中currentTimeMillis();
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 * @author zzq
 * @creat 2020-05-26 16:17
 */
public class DateTimeTest {

    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    1.两个操作：
        1.1 格式化：日期 --->字符串
        1.2 解析：格式化的逆过程，字符串 ---> 日期
    2.SimpleDateFormat的实例化
    */
    @Test
    public void test1() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);

        //格式化：日期 --->字符串
        String format = sdf.format(date);
        System.out.println(format);

        //解析：字符串 ---> 日期
        String str = "2019/5/26 下午4:27";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
        //*******************************************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),否则，抛异常
        String str1 = "2020-05-26 16:33:07";
        Date date2 = sdf1.parse(str1);
        System.out.println(date2);
    }


    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date

    练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？
        举例：2020-09-08 ？ 总天数
            总天数 % 5 == 1,2,3 : 打渔
            总天数 % 5 == 4,0 : 晒网

        总天数的计算？
            方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
            方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
    */
    @Test
    public void test2() throws ParseException {
        String day = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf1.parse(day);
        System.out.println(date1);
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }


    /*
    Calendar日历类(抽象类）的使用
    */
    @Test
    public void test3() throws ParseException {
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();


        //2.常用方法
        //get()
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int day1 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(day);
        System.out.println(day1);

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        int day2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day2);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,7);
        int day3 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day3);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        int day4 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day4);
    }
}
