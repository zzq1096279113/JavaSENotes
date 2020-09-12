package principle.inversion;

public class DependencyPass {
    public static void main(String[] args) {
        ChangHongTV changHong = new ChangHongTV();
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.open(changHong);

//        ChangHongTV changHong = new ChangHongTV();
//        OpenAndClose openAndClose = new OpenAndClose(changHong);
//		openAndClose.open();

//        ChangHongTV changHong = new ChangHongTV();
//        OpenAndClose openAndClose = new OpenAndClose();
//        openAndClose.setTv(changHong);
//        openAndClose.open();
    }
}

// 方式1： 通过接口传递实现依赖
/**
 * @Description 电视的接口
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 10:22
 */
interface ITV {
    public void play();
}

/**
 * @Description 遥控器的接口
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 10:24
 */
interface IOpenAndClose {
    public void open(ITV tv);
}

/**
 * @Description 电视的具体实现类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 10:24
 */
class ChangHongTV implements ITV {
    @Override
    public void play() {
        System.out.println("打开电视");
    }
}

/**
 * @Description 遥控器的实现类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 10:23
 */
class OpenAndClose implements IOpenAndClose {
    public void open(ITV tv) {
        tv.play();
    }
}


// 方式2: 通过构造方法依赖传递
//interface IOpenAndClose {   //遥控器接口
//    public void open(); //抽象方法
//}
//
//interface ITV {     //电视机接口
//    public void play();
//}
//
//class ChangHongTV implements ITV {  //电视机的实现类
//    @Override
//    public void play() {
//        System.out.println("打开电视");
//    }
//}
//
//class OpenAndClose implements IOpenAndClose {   //遥控器的实现类
//    public ITV tv;
//
//    public OpenAndClose(ITV tv) {   //创建遥控器的实现类需要给出电视机的实现类对象
//        this.tv = tv;
//    }
//
//    public void open() {
//        this.tv.play();
//    }
//}


// 方式3 , 通过setter方法传递
//interface IOpenAndClose {   //遥控器接口
//    public void open();
//
//    public void setTv(ITV tv);
//}
//
//interface ITV {     //电视机接口
//    public void play();
//}
//
//class ChangHongTV implements ITV {  //电视机的实现类
//    @Override
//    public void play() {
//        System.out.println("打开电视");
//    }
//}
//
//class OpenAndClose implements IOpenAndClose {   //遥控器的实现类
//    private ITV tv;
//
//    public void setTv(ITV tv) {
//        this.tv = tv;
//    }
//
//    public void open() {
//        this.tv.play();
//    }
//}

