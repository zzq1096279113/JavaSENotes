package builder.improve;

/**
 * @Description 高楼
 * @ClassName HighBuilding
 * @Author zzq
 * @Date 2020/9/18 9:40
 */
public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        this.house.setBasic("建造高楼的地基");
    }

    @Override
    public void buildWalls() {
        this.house.setWalls("建造高楼的墙壁");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("建造高楼的屋顶");
    }
}
