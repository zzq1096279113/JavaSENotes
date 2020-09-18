package builder.base;

/**
 * @Description 房子抽象类
 * @ClassName AbstractHouse
 * @Author zzq
 * @Date 2020/9/17 19:34
 */
public abstract class AbstractHouse {
    public abstract void buildBasic();  //建地基

    public abstract void buildWalls();  //砌墙

    public abstract void buildRoof();   //封顶

    public void buildHouse() {
        buildBasic();
        buildWalls();
        buildRoof();
        System.out.println("房子建设完毕");
    }
}
