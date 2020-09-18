package adapter.classadapter;

/**
 * @Description 适配器
 * @ClassName VoltageAdapter
 * @Author zzq
 * @Date 2020/9/18 21:43
 */
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        int srcVoltage = output220V(); //获得220V电压
        int dstVoltage = srcVoltage / 44;   //经过处理得到目标电压
        System.out.println("处理电压为" + dstVoltage +"V");
        return dstVoltage;
    }
}
