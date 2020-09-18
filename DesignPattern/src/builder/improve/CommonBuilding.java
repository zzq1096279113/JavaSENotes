package builder.improve;

/**
 * @Description 普通房屋
 * @ClassName CommonBuilding
 * @Author zzq
 * @Date 2020/9/18 9:44
 */
public class CommonBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        this.house.setBasic("建造房屋的地基");
    }

    @Override
    public void buildWalls() {
        this.house.setWalls("建造房屋的墙壁");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("建造房屋的屋顶");
    }
}
