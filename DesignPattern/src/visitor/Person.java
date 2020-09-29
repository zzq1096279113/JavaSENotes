package visitor;

/**
 * @Description 人类
 * @ClassName Person
 * @Author zzq
 * @Date 2020/9/28 22:21
 */
public abstract class Person {
    public String speak;

    public abstract void accept(Evaluation evaluation);
}
