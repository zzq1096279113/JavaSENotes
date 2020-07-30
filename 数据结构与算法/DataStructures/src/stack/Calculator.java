package stack;

/**
 * @Description 栈实现计算器
 * @ClassName Calculator
 * @Author zzq
 * @Date 2020/7/30 14:34
 */
public class Calculator {
    public static void main(String[] args) {
        ArrayStackData numberStack = new ArrayStackData(10);    //数字栈
        ArrayStackData operatorStack = new ArrayStackData(10);  //符号栈
        int index = 0;  //用于扫描表达式
        int num1;
        int num2;
        int operator;
        int result;
        char ch;
        String num = ""; //用于拼接多位数字
        String str = "70*2*2-5+10-5+3-40"; //表达式
        do {
            ch = str.substring(index, index + 1).charAt(0); //得到索引位置的字符
            if (operatorStack.isOperator(ch)) {   //判断是否为运算符
                if (!operatorStack.isEmpty()) {   //判断符号栈是否为空
                    if (ArrayStackData.priority(ch) <= ArrayStackData.priority(operatorStack.peek())) { //当前运算符优先级大于符号栈栈顶运算符的优先级
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        operator = operatorStack.pop();
                        result = numberStack.calculation(num1, num2, operator);   //运算出结果
                        numberStack.push(result);   //将结果入栈
                    }
                }
                operatorStack.push(ch);     //将符号入栈
            } else {  //如果不是运算符，直接入栈数字栈
                num += ch;  //将数字拼入num字符串
                if (index == str.length() - 1) {    //如果是字符串最后一个字符，直接入栈
                    numberStack.push(Integer.parseInt(num));
                } else {   //如果不是字符串最后一个字符
                    if (operatorStack.isOperator(str.substring(index + 1, index + 2).charAt(0))) {  //判断下一个字符是否为数字
                        numberStack.push(Integer.parseInt(num));
                        num = "";
                    }
                }
            }
            index++;
        } while (index < str.length());
        while (!operatorStack.isEmpty()) {
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            operator = operatorStack.pop();
            result = numberStack.calculation(num1, num2, operator);
            numberStack.push(result);
        }
        System.out.println("表达式 " + str + " 的结果为：" + numberStack.peek());
    }
}

class ArrayStackData {
    private int maxSize;    //栈的大小
    private int[] array;    //数据放在该数组中
    private int top = -1;   //默认栈顶为-1

    public ArrayStackData(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    /**
     * @Description 入栈操作
     * @Param [value]
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 16:40
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;  //栈顶向上移
        array[top] = value; //将数据放入栈顶
    }

    /**
     * @Description 出栈操作
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/7/28 16:41
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = array[top]; //保存栈顶的数据
        top--;  //移动栈顶
        return value;   //返回栈顶的数据
    }

    /**
     * @Description 遍历显示栈中数据
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 16:47
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {    //从栈顶向下遍历直到索引为0
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }

    /**
     * @Description 判断栈是否已满
     * @Param null
     * @Return boolean
     * @Author zzq
     * @Date 2020/7/28 16:37
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * @Description 判断栈是否为空
     * @Param []
     * @Return boolean
     * @Author zzq
     * @Date 2020/7/28 16:38
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * @Description 根据传入符号判断计算优先级
     * @Param [value]
     * @Return int
     * @Author zzq
     * @Date 2020/7/30 14:41
     */
    public static int priority(int operator) {
        if (operator == '*' || operator == '/') { //乘除的优先级高于加减
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {    //假定表达式只存在+，-，*，/四种符号
            return -1;
        }
    }

    /**
     * @Description 判断是否是一个运算符
     * @Param [value]
     * @Return boolean
     * @Author zzq
     * @Date 2020/7/30 14:46
     */
    public boolean isOperator(char value) {
        return value == '*' || value == '/' || value == '+' || value == '-';
    }

    /**
     * @Description 根据传入的值和运算符计算出结果并返回
     * @Param [num1, num2, operator]
     * @Return int
     * @Author zzq
     * @Date 2020/7/30 14:51
     */
    public int calculation(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * @Description 返回栈顶的数据
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/7/30 15:05
     */
    public int peek() {
        return array[top];
    }
}