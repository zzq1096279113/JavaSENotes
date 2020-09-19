package adapter.objectadapter;

/**
 * @Description 适配器
 * @ClassName VoltageAdapter
 * @Author zzq
 * @Date 2020/9/18 21:43
 */
public class VoltageAdapter implements Voltage5V {
    private final Voltage220V voltage220V;     //通过构造器聚合

    public VoltageAdapter(Voltage220V v) {
        this.voltage220V = v;
    }

    @Override
    public int output5V() {
        int dstVoltage;
        if (voltage220V != null) {
            int srcVoltage = voltage220V.output220V();
            dstVoltage = srcVoltage / 44;
            System.out.println("处理电压为" + dstVoltage +"V");
            return dstVoltage;
        }else
            throw new RuntimeException("电源错误");
    }
}
