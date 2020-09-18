package builder.improve;

/**
 * @Description 建造指挥者
 * @ClassName BuildingDirector
 * @Author zzq
 * @Date 2020/9/18 9:46
 */
public class BuildingDirector {
    public HouseBuilder houseBuilder;

    public BuildingDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House creatHouse() {
        this.houseBuilder.buildBasic();
        this.houseBuilder.buildWalls();
        this.houseBuilder.buildRoof();
        return this.houseBuilder.buildHouse();
    }
}
