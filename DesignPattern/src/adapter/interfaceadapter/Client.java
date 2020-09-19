package adapter.interfaceadapter;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/19 15:34
 */
public class Client {
    public static void main(String[] args) {
        PersonAdapter personAdapter = new PersonAdapter() {
            @Override
            public void say() {      //只需要覆盖使用的接口方法
                System.out.println("人可以说话");
            }
        };
        personAdapter.say();
        personAdapter.run();        //没有重写的方法默认为空
    }
}
