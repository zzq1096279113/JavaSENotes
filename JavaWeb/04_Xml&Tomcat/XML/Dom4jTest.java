import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @Description dom4j的测试
 * @ClassName Dom4jTest
 * @Author zzq
 * @Date 2020/12/4 19:15
 */
public class Dom4jTest {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();      //创建一个SaxReader输入流
        Document document = saxReader.read("books.xml");    //读取xml配置文件，生成Document对象
        Element rootElement = document.getRootElement();    //通过Document对象获取根元素
        List<Element> books = rootElement.elements("book");       //通过标签名查询子元素 返回列表
        for(Element book : books){
            String sn = book.element("sn").getText();       //getText可以获取标签中的内容
            String name = book.elementText("name");     //直接获取指定标签名的文本内容
            String author = book.elementText("author");
            double price = Double.parseDouble(book.attributeValue("price"));
            System.out.println(new Book(sn, name, author, price));
        }
    }
}
