package uml.composition;

/**
 * @Description 组合
 * @ClassName Computer
 * @Author zzq
 * @Date 2020/9/13 17:03
 */
public class Computer {
    private Monitor monitor = new Monitor();    //显示器不能与电脑分离
    private Mouse mouse = new Mouse();          //鼠标也不能与电脑分离

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
