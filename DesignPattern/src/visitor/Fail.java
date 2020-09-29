package visitor;

/**
 * @Description 评价：失败
 * @ClassName Fail
 * @Author zzq
 * @Date 2020/9/28 22:23
 */
public class Fail extends Evaluation {
    @Override
    public String getManResult() {
        return "男人评价：失败";
    }

    @Override
    public String getWomanResult() {
        return "女人评价：失败";
    }
}
