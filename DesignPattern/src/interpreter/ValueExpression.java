package interpreter;

import java.util.HashMap;

/**
 * @Description 变量
 * @ClassName ValueExpression
 * @Author zzq
 * @Date 2020/10/9 10:32
 */
public class ValueExpression extends AbstractExpression {
    private final String key;

    public ValueExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
