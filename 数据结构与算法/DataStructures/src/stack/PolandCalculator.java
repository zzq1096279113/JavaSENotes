package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @Description 逆波兰计算器
 * @ClassName PolandNotation
 * @Author zzq
 * @Date 2020/7/30 16:18
 */
public class PolandCalculator {
    public static void main(String[] args) {
        String expression = "4 5 * 8 - 60 + 8 2 / +";   //逆波兰表达式（后缀表达式）
        ArrayList<String> strings = toList(expression);
        int res = calculate(strings);
        System.out.println("运算结果为：" + res);
    }

    /**
     * @Description 将表达式所有数据和运算符放入一个ArrayList中
     * @Param [str]
     * @Return java.util.ArrayList<java.lang.String>
     * @Author zzq
     * @Date 2020/7/31 10:05
     */
    public static ArrayList<String> toList(String str) {
        String[] s = str.split(" ");
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, s);
        return stringArrayList;
    }

    /**
     * @Description 根据传进来的ArrayList计算并返回结果
     * @Param [strings]
     * @Return int
     * @Author zzq
     * @Date 2020/7/31 10:20
     */
    public static int calculate(ArrayList<String> strings) {
        Stack<String> num = new Stack<>();  //创建一个栈用于存放数据
        for (String item : strings) {
            if (item.matches("\\d+")) {   //正则表达式：匹配多位数
                num.push(item);
            } else {
                int num1 = Integer.parseInt(num.pop());     //依次取出栈顶和次顶
                int num2 = Integer.parseInt(num.pop());
                int result = switch (item) {    //根据运算符进行运算
                    case "+" -> num1 + num2;
                    case "-" -> num2 - num1;
                    case "*" -> num1 * num2;
                    case "/" -> num2 / num1;
                    default -> throw new RuntimeException("运算符错误");
                };
                num.push(String.valueOf(result));   //将结果入栈
            }
        }
        return Integer.parseInt(num.pop());
    }
}
