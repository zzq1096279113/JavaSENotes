package adapter.SpringMVC;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Spring源码分析
 * @ClassName DispatchServlet
 * @Author zzq
 * @Date 2020/9/19 16:57
 */
public class DispatchServlet {
    public static List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    public DispatchServlet() {
        handlerAdapters.add(new SimpleHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new AnnotationHandlerAdapter());
    }

    public HandlerAdapter getHandler(Controller controller) {
        for (HandlerAdapter adapter : handlerAdapters) {    //遍历适配器
            if (adapter.supports(controller)) {     //判断适配器类型是否一致
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DispatchServlet dispatchServlet = new DispatchServlet();
//        SimpleController controller = new SimpleController();
//        HttpController controller = new HttpController();
        AnnotationController controller = new AnnotationController();   //获得对象
        HandlerAdapter adapter = dispatchServlet.getHandler(controller);    //根据传入的对象动态得到适配器
        adapter.handle(controller); //将对象放入适配器转换类型
    }
}

