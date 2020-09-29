package visitor;

/**
 * @Description 客户端：访问者模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/28 21:31
 */
public class Client {
    public static void main(String[] args) {
        Success success = new Success();    //创建评价成功访问者
        Fail fail = new Fail();     //创建评价失败访问者
        ObjectStructure objectStructure = new ObjectStructure();    //创建人集合
        Man man = new Man();    //创建一个男人
        man.accept(success);    //男人的评价为成功
        objectStructure.add(man);   //放入集合中
        Woman woman = new Woman();  //创建一个女人
        woman.accept(fail);     //女人的评价为失败
        objectStructure.add(woman); //放入集合中
        objectStructure.show();
    }
}
