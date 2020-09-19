package adapter.SpringMVC;

/**
 * @Description 适配器接口
 * @ClassName HandlerAdapter
 * @Author zzq
 * @Date 2020/9/19 16:54
 */
public interface HandlerAdapter {
    public boolean supports(Object handler);    //判断类型

    public void handle(Object handler);     //转换类型
}

/**
 * @Description 适配器接口的实现类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/19 16:54
 */
class SimpleHandlerAdapter implements HandlerAdapter {

    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }

    public void handle(Object handler) {
        ((SimpleController) handler).doSimplerHandler();
    }

}

class HttpHandlerAdapter implements HandlerAdapter {

    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }

    public void handle(Object handler) {
        ((HttpController) handler).doHttpHandler();
    }

}

class AnnotationHandlerAdapter implements HandlerAdapter {

    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }

    public void handle(Object handler) {
        ((AnnotationController) handler).doAnnotationHandler();
    }

}
