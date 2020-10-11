package interpreter;

import java.util.HashMap;

/**
 * @Description 加法
 * @ClassName AddExpression
 * @Author zzq
 * @Date 2020/10/9 10:34
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return this.left.interpreter(var) + this.right.interpreter(var);
    }
}
