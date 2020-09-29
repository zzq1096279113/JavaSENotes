package visitor;

/**
 * @Description 评价：成功
 * @ClassName Success
 * @Author zzq
 * @Date 2020/9/28 22:22
 */
public class Success extends Evaluation {
    @Override
    public String getManResult() {
        return "男人评价：成功";
    }

    @Override
    public String getWomanResult() {
        return "女人评价：成功";
    }
}
