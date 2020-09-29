package visitor;

/**
 * @Description 女人
 * @ClassName Woman
 * @Author zzq
 * @Date 2020/9/28 22:21
 */
public class Woman extends Person {
    private boolean isEvaluation = false;

    @Override
    public void accept(Evaluation evaluation) {
        if (!isEvaluation) {
            this.speak = evaluation.getWomanResult();
            this.isEvaluation = true;
        }
    }
}
