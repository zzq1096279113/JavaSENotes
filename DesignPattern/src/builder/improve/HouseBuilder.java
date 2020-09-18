package builder.improve;

/**
 * @Description 抽象建造者
 * @ClassName HouseBuilder
 * @Author zzq
 * @Date 2020/9/18 9:35
 */
public abstract class HouseBuilder {
    protected House house = new House();

    public abstract void buildBasic();  //建地基

    public abstract void buildWalls();  //砌墙

    public abstract void buildRoof();   //封顶

    public House buildHouse() {
        return house;   //建造好房子后返回产品
    }
}
