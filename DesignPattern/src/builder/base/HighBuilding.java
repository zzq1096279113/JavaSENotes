package builder.base;

/**
 * @Description 高楼
 * @ClassName HighBuilding
 * @Author zzq
 * @Date 2020/9/17 19:37
 */
public class HighBuilding extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println("给高楼打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("给高楼砌墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("给高楼封顶");
    }
}
