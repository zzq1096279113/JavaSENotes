package principle.ocp;

/**
 * @Description 开闭原则
 * @ClassName Ocp1
 * @Author zzq
 * @Date 2020/9/12 15:48
 */
public class Ocp1 {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
    }
}

/**
 * @Description 用于绘图的类[使用方]
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 15:49
 */
class GraphicEditor {
    /**
     * @Description 接收Shape对象，然后根据type，来绘制不同的图形
     * @Param [s]
     * @Return void
     * @Author zzq
     * @Date 2020/9/12 15:50
     */
    public void drawShape(Shape s) {
        if (s.m_type == 1)
            drawRectangle();
        else if (s.m_type == 2)
            drawCircle();
        else if (s.m_type == 3)
            drawTriangle();
    }

    /**
     * @Description 绘制矩形
     * @Param [r]
     * @Return void
     * @Author zzq
     * @Date 2020/9/12 15:50
     */
    private void drawRectangle() {
        System.out.println("绘制矩形");
    }

    /**
     * @Description 绘制圆形
     * @Param [r]
     * @Return void
     * @Author zzq
     * @Date 2020/9/12 15:50
     */
    private void drawCircle() {
        System.out.println("绘制圆形");
    }

    /**
     * @Description 绘制三角形
     * @Param [r]
     * @Return void
     * @Author zzq
     * @Date 2020/9/12 15:50
     */
    private void drawTriangle() {
        System.out.println("绘制三角形");
    }
}

//Shape类，基类
class Shape {
    int m_type;
}

class Rectangle extends Shape {
    public Rectangle() {
        this.m_type = 1;
    }
}

class Circle extends Shape {
    public Circle() {
        this.m_type = 2;
    }
}

/**
 * @Description 如果需要新增一个三角形
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 15:58
 */
class Triangle extends Shape {
    public Triangle() {
        this.m_type = 3;
    }
}