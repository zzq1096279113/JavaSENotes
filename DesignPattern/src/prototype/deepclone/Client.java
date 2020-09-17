package prototype.deepclone;

/**
 * @Description 客户端：深拷贝
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/17 14:13
 */
public class Client {
    public static void main(String[] args) throws Exception {
        DeepProtoType deepProtoType = new DeepProtoType("Tom", 12, new Sheep("Jerry", 13, "Blue"));
//        DeepProtoType clone = deepProtoType.clone();
//        System.out.println(deepProtoType.toString());
//        System.out.println(clone.toString());
//        System.out.println(deepProtoType.friend.hashCode());    //查看两者的friend引用数据类型hash值
//        System.out.println(clone.friend.hashCode());            //两者hash值不同
        DeepProtoType clone = deepProtoType.deepClone();
        System.out.println(deepProtoType.friend.hashCode());
        System.out.println(clone.friend.hashCode());
    }
}
