package visitor;

/**
 * @Description 新增加的评价：待定
 * @ClassName Wait
 * @Author zzq
 * @Date 2020/9/29 9:33
 */
public class Wait extends Evaluation {
    @Override
    public String getManResult() {
        return "男人评价：待定";
    }

    @Override
    public String getWomanResult() {
        return "女人评价：待定";
    }
}
