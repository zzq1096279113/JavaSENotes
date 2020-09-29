package visitor;

/**
 * @Description 男人
 * @ClassName Man
 * @Author zzq
 * @Date 2020/9/28 22:21
 */
public class Man extends Person {
    private boolean isEvaluation = false;

    @Override
    public void accept(Evaluation evaluation) {
        if (!isEvaluation) {
            this.speak = evaluation.getManResult();
            this.isEvaluation = true;
        }
    }
}
