package stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description 将一个中缀表达式转换为后缀表达式
 * @ClassName Conversion
 * @Author zzq
 * @Date 2020/7/31 10:58
 */
public class Conversion {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        ArrayList<String> infixExpression = getInfixExpression(expression);
        ArrayList<String> suffixExpression = parseSuffixExpression(infixExpression);
        int calculate = PolandCalculator.calculate(suffixExpression);
        System.out.println("运算结果为：" + calculate);
    }

    /**
     * @Description 将中缀表达式转成对应的ArrayList
     * @Param [str]
     * @Return java.util.ArrayList<java.lang.String>
     * @Author zzq
     * @Date 2020/7/31 12:03
     */
    public static ArrayList<String> getInfixExpression(String str) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        int i = 0;  //用于遍历中缀表达式字符串
        do {
            if (str.charAt(i) < 48 || str.charAt(i) > 57) { //如果不是数字，直接加入ArrayList
                stringArrayList.add(String.valueOf(str.charAt(i)));
                i++;
            } else {    //如果是一个数字，需要考虑多位数
                StringBuilder strBuilder = new StringBuilder();
                while (i < str.length() && str.charAt(i) >= 48 && str.charAt(i) <= 57) {    //循环判断是否为多位数
                    strBuilder.append(str.charAt(i));   //拼接
                    i++;
                }
                stringArrayList.add(String.valueOf(strBuilder));
            }
        } while (i < str.length());
        return stringArrayList;
    }

    /**
     * @Description 根据传入的中缀表达式List处理并返回后缀表达式List
     * @Param [arrayList]
     * @Return java.util.ArrayList<java.lang.String>
     * @Author zzq
     * @Date 2020/7/31 15:52
     */
    public static ArrayList<String> parseSuffixExpression(ArrayList<String> arrayList) {
        Stack<String> s = new Stack<>();   //用于存放符号的栈
        ArrayList<String> suffix = new ArrayList<>();   //存放后缀表达式的List
        for (String str : arrayList) {    //依次遍历传进来的中缀表达式list
            if (str.matches("\\d+")) {    //如果是数字，直接加入后缀表达式List中
                suffix.add(str);
            } else if (s.isEmpty() || "(".equals(str) || "(".equals(s.peek())) {  //如果符号栈为空或栈顶运算符为"("或就是"("，则直接入符号栈
                s.push(str);
            } else if (")".equals(str)) {  //如果是")"，则依次弹出符号栈栈顶的运算符，并加入List中，直到遇到"("
                while (!"(".equals(s.peek())) {
                    suffix.add(s.pop());
                }
                s.pop();    //将战中的")"弹出消除
            } else {
                while (s.size() != 0 && getOperation(str) <= getOperation(s.peek())) {  //如果str运算符的优先级低于栈顶运算符的优先级
                    suffix.add(s.pop());                                                //则取出栈顶运算符加入List直到str优先级大于栈顶优先级
                }
                s.push(str);
            }
        }
        while (s.size() != 0)   //将剩余的运算符依次弹出并加入List
            suffix.add(s.pop());
        return suffix;
    }

    /**
     * @Description 判断传入的运算符的优先级
     * @Param [str]
     * @Return int
     * @Author zzq
     * @Date 2020/7/31 15:56
     */
    public static int getOperation(String str) {
        int result;
        switch (str) {
            case "+", "-" -> result = 1;
            case "*", "/" -> result = 2;
            default -> throw new RuntimeException("运算符错误");
        }
        return result;
    }

}
