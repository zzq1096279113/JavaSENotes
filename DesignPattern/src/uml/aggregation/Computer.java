package uml.aggregation;

/**
 * @Description 聚合
 * @ClassName Computer
 * @Author zzq
 * @Date 2020/9/13 17:03
 */
public class Computer {
    private Monitor monitor;    //显示器可以与电脑分离
    private Mouse mouse;        //鼠标也可以与电脑分离

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
