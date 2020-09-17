package prototype.deepclone;

import java.io.*;

/**
 * @Description 深拷贝
 * @ClassName DeepProtoType
 * @Author zzq
 * @Date 2020/9/17 13:57
 */
public class DeepProtoType implements Serializable, Cloneable {
    public String name;
    public int age;
    public Sheep friend;

    public DeepProtoType(String name, int age, Sheep sheep) {
        this.name = name;
        this.age = age;
        this.friend = sheep;
    }

    /**
     * @Description 深拷贝（方式一）：使用clone方法
     * @Param []
     * @Return prototype.deepclone.DeepProtoType
     * @Author zzq
     * @Date 2020/9/17 14:21
     */
    @Override
    protected DeepProtoType clone() throws CloneNotSupportedException {
        DeepProtoType deepProtoType;
        deepProtoType = (DeepProtoType) super.clone();  //先用默认的浅拷贝将基本数据类型内容克隆
        deepProtoType.friend = (Sheep) friend.clone();  //引用数据类型实现了克隆接口，可以直接克隆
        return deepProtoType;
    }

    /**
     * @Description 深拷贝（方式二）：使用序列化实现
     * @Param []
     * @Return prototype.deepclone.DeepProtoType
     * @Author zzq
     * @Date 2020/9/17 14:22
     */
    public DeepProtoType deepClone() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;       //对象输出流
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        DeepProtoType copy = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);   //将当前对象以对象流的方式输出
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());   //创建一个与输出流相同内容和长度的字符数组
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            copy = (DeepProtoType) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return copy;
    }

    @Override
    public String toString() {
        return "DeepProtoType{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friend=" + friend +
                '}';
    }
}
