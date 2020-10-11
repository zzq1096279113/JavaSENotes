package interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description 计算器
 * @ClassName Calculator
 * @Author zzq
 * @Date 2020/10/9 10:34
 */
public class Calculator {
    private final AbstractExpression abstractExpression;
    public AbstractExpression left;
    public AbstractExpression right;

    /**
     * @Description 在构造器中解析
     * @Param [expression]
     * @Return
     * @Author zzq
     * @Date 2020/10/9 11:00
     */
    public Calculator(String expression) {
        Stack<AbstractExpression> stack = new Stack<>();    //建立栈
        char[] charArray = expression.toCharArray();        //将表达式变为字符数组
        for (int i = 0; i < charArray.length; i++) {    //遍历数组
            switch (charArray[i]) {
                case '+' -> {   //如果为+号
                    this.left = stack.pop();    //取出栈顶的对象
                    this.right = new ValueExpression(String.valueOf(charArray[++i]));    //创建右边的对象
                    stack.push(new AddExpression(this.left, this.right));
                }
                case '-' -> {   //如果为-号
                    this.left = stack.pop();
                    this.right = new ValueExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(this.left, this.right));
                }
                default -> stack.push(new ValueExpression(String.valueOf(charArray[i])));   //都不是，默认为数字
            }
        }
        this.abstractExpression = stack.pop();
    }

    public int run(HashMap<String, Integer> var) {
        return this.abstractExpression.interpreter(var);
    }
}
