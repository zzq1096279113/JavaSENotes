package interpreter;

import java.util.HashMap;

/**
 * @Description 减法
 * @ClassName SubExpression
 * @Author zzq
 * @Date 2020/10/9 10:34
 */
public class SubExpression extends SymbolExpression {
    public SubExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return this.left.interpreter(var) - this.right.interpreter(var);
    }
}
