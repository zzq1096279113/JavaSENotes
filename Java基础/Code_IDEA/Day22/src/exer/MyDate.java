package exer;

/**
 * MyDate 类包含:
 * private 成员变量 year,month,day；
 * 并为每一个属性定义 getter, setter 方法；
 *
 * @author zzq
 * @creat 2020-05-29 13:38
 */
public class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof MyDate){
            MyDate myDate = (MyDate)o;
            if(this.getYear() == myDate.getYear()){
                if(this.getMonth() == myDate.getMonth()){
                    return Integer.compare(this.getDay(),myDate.getDay());
                }
                return Integer.compare(this.getMonth(),myDate.getMonth());
            }
            return Integer.compare(this.getYear(),myDate.getYear());
        }
        throw new RuntimeException("数据类型错误");
    }
}
