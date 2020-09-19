package adapter.SpringMVC;

/**
 * @Description 多种Controller接口的实现
 * @ClassName Controller
 * @Author zzq
 * @Date 2020/9/19 16:51
 */
public interface Controller {

}

class HttpController implements Controller {
    public void doHttpHandler() {
        System.out.println("类型为：http");
    }
}

class SimpleController implements Controller {
    public void doSimplerHandler() {
        System.out.println("类型为：simple");
    }
}

class AnnotationController implements Controller {
    public void doAnnotationHandler() {
        System.out.println("类型为：annotation");
    }
}
