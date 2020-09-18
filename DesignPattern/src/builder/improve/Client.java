package builder.improve;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/18 9:32
 */
public class Client {
    public static void main(String[] args) {
        HighBuilding highBuilding = new HighBuilding();
        BuildingDirector buildingDirector = new BuildingDirector(highBuilding);
        House house = buildingDirector.creatHouse();
        System.out.println(house.getBasic());
        System.out.println(house.getWalls());
        System.out.println(house.getRoof());
    }
}
