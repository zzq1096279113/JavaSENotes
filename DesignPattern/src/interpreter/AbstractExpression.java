package interpreter;

import java.util.HashMap;

/**
 * @Description 抽象表达式
 * @ClassName AbstractExpression
 * @Author zzq
 * @Date 2020/10/9 10:31
 */
public abstract class AbstractExpression {
    /**
     * @Description HashMap中的key就是表达中的变量，value就是变量的具体数值
     * @Param [value]
     * @Return int
     * @Author zzq
     * @Date 2020/10/9 10:39
     */
    public abstract int interpreter(HashMap<String, Integer> var);
}
