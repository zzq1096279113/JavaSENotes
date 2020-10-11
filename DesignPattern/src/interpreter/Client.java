package interpreter;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description 客户端：解释器模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/9 10:13
 */
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入表达式：");
        String expression = scanner.nextLine();
        HashMap<String, Integer> var = getValue(expression);
        Calculator calculator = new Calculator(expression);
        System.out.println("运算结果：" + expression + "=" + calculator.run(var));
    }

    /**
     * @Description 输入数值
     * @Param [expStr]
     * @Return java.util.HashMap<java.lang.String, java.lang.Integer>
     * @Author zzq
     * @Date 2020/10/9 11:21
     */
    public static HashMap<String, Integer> getValue(String expression) {
        HashMap<String, Integer> map = new HashMap<>();
        for (char c : expression.toCharArray()) {
            if (c != '+' && c != '-') {
                if (!map.containsKey(String.valueOf(c))) {
                    System.out.print("请输入" + c + "的值：");
                    String input = (new Scanner(System.in)).nextLine();
                    map.put(String.valueOf(c), Integer.valueOf(input));
                }
            }
        }
        return map;
    }
}
