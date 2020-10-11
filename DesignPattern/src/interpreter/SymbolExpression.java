package interpreter;

import java.util.HashMap;

/**
 * @Description 符号
 * @ClassName SymbolExpression
 * @Author zzq
 * @Date 2020/10/9 10:32
 */
public class SymbolExpression extends AbstractExpression {
    public AbstractExpression left;
    public AbstractExpression right;

    public SymbolExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
