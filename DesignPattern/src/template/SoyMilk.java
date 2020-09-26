package template;

/**
 * @Description 豆浆：抽象类
 * @ClassName SoyMilk
 * @Author zzq
 * @Date 2020/9/26 14:20
 */
public abstract class SoyMilk {
    public final void make() {
        System.out.println("开始制作豆浆");
        select();
        add();
        soak();
        beat();
        System.out.println("豆浆制作完毕");
    }

    public void select() {      //大豆选材
        System.out.println("第一步：精选黄豆");
    }

    public abstract void add(); //口味添加

    public void soak() {        //浸泡
        System.out.println("第三步：浸泡材料");
    }

    public void beat() {        //打豆浆
        System.out.println("第四步：混合打碎");
    }
}
