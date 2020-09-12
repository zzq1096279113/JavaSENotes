package principle.ocp;

/**
 * @Description 开闭原则：已改进
 * @ClassName Ocp2
 * @Author zzq
 * @Date 2020/9/12 16:01
 */
public class Ocp2 {
    public static void main(String[] args) {
        GraphicEditor1 graphicEditor1 = new GraphicEditor1();
        graphicEditor1.drawShape(new Rectangle1());
        graphicEditor1.drawShape(new Circle1());
        graphicEditor1.drawShape(new Triangle1());
    }
}

class GraphicEditor1 {
    public void drawShape(Shape1 s) {
        s.draw();
    }
}

/**
 * @Description 将形状类声明为抽象类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:05
 */
abstract class Shape1 {
    public abstract void draw();
}

/**
 * @Description 矩形类实现形状类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:05
 */
class Rectangle1 extends Shape1 {
    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

/**
 * @Description 圆形类实现形状类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:10
 */
class Circle1 extends Shape1 {
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

/**
 * @Description 三角形类实现形状类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:11
 */
class Triangle1 extends Shape1 {
    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}