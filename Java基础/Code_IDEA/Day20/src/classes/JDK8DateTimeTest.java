package classes;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author zzq
 * @creat 2020-05-26 17:12
 */
public class JDK8DateTimeTest {

    @Test
    public void test1(){
        Date date = new Date(2020 - 1900,4,8);
        System.out.println(date);
    }


    /*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
    */
    @Test
    public void test2(){
        //now()当前的年、月、日、时、分、秒
        LocalDate localDate = LocalDate.now();//获取当前的年、月、日
        LocalTime localTime = LocalTime.now();//获取当前的时、分、秒
        LocalDateTime localDateTime = LocalDateTime.now();//获取当前的年、月、日、时、分、秒
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println("*******************************************");

        //of()设置指定的年、月、日、时、分、秒
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 23, 59, 59);
        System.out.println(localDateTime1);
        System.out.println("*******************************************");

        //getXxx():获取相关属性
        System.out.println(localDateTime.getDayOfMonth());//27
        System.out.println(localDateTime.getDayOfWeek());//WEDNESDAY
        System.out.println(localDateTime.getDayOfYear());//148
        System.out.println(localDateTime.getMonthValue());//5
        System.out.println(localDateTime.getMinute());//11
        System.out.println("*******************************************");

        //withXxx():设置相关属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(23);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println("*******************************************");

        //plusXxx():加时间
        LocalDateTime localDateTime3 = localDateTime.plusDays(2);
        System.out.println(localDateTime3);

        //minusXxx():减时间
        LocalDateTime localDateTime4 = localDateTime.minusDays(3);
        System.out.println(localDateTime4);

    }


    /*
    Instant的使用
        类似于 java.util.Date类
    */
    @Test
    public void test3(){
        //now():获取本初子午线对应的标准时间
        Instant now = Instant.now();
        System.out.println(now);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long l = now.toEpochMilli();
        System.out.println(l);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant ago = now.ofEpochMilli(1590539283234L);
        System.out.println(ago);

    }


    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
    */
    @Test
    public void test4(){

        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime now = LocalDateTime.now();
        String format = dtf1.format(now);
        System.out.println(format);
        //解析：字符串 -->日期
        TemporalAccessor parse = dtf1.parse("2020-05-27T08:35:55.5362336");
        System.out.println(parse);

        //方式二：
        //本地化相关的格式。如：ofLocalizedDateTime()FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
//        String format1 = dtf2.format(LocalDate.now());
//        System.out.println(format1);
        //本地化相关的格式。如：ofLocalizedDate()  FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String format2 = dtf3.format(LocalDate.now());
        System.out.println(format2);//2019-2-18

        //重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format3 = dtf4.format(LocalDateTime.now());
        System.out.println(format3);
        //解析
        TemporalAccessor parse1 = dtf4.parse("2020-05-27 08:51:46");
        System.out.println(parse1);

    }
}
