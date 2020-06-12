package classes;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 一、Map的实现类的结构：
 *      |----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 *          |----HashMap:作为Map的主要实现类；线程不安全的，效率较高；可以存储null的key和value
 *              |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                             原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                             对于频繁的遍历操作，此类执行效率高于HashMap。
 *          |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                       底层使用红黑树
 *          |----Hashtable:作为古老的实现类；线程安全的，效率较低；不能存储null的key和value
 *              |----Properties:常用来处理配置文件。key和value都是String类型
 *
 *      HashMap的底层：数组+链表  （jdk7及之前）
 *                    数组+链表+红黑树 （jdk 8）
 *  面试题：
 *      1. HashMap的底层实现原理？
 *      2. HashMap和Hashtable的异同？
 *      3. CurrentHashMap与Hashtable的异同？（暂时不讲）
 *
 *
 *  二、Map结构的理解：
 *      Map中的key:无序的、不可重复的，使用Set存储所有的key。 --->  key所在的类要重写equals()和hashCode() （以HashMap为例）
 *      Map中的value:无序的、可重复的，使用Collection存储所有的value。 --->  value所在的类要重写equals()
 *      Map中的entry:无序的、不可重复的，使用Set存储所有的entry。
 *      一个键值对：key-value构成了一个Entry对象。
 *
 *
 *  三、HashMap的底层实现原理？以jdk7为例说明：
 *      HashMap map = new HashMap();//在实例化以后，底层创建了长度是16的一维数组Entry[] table。
 *      map.put(key1,value1);
 *      //首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
 *              如果此位置上的数据为空，此时的key1-value1添加成功。 ---->情况1
 *              如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据的哈希值：
 *                  如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。 ---->情况2
 *                  如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较：
 *                      如果equals()返回false:此时key1-value1添加成功。 ----情况3
 *                      如果equals()返回true:使用value1替换value2。
 *
 *      补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *      扩容问题：当超出临界值且要存放的位置非空时，扩容。
 *      默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *      jdk8 相较于jdk7在底层实现方面的不同：
 *          1. new HashMap():底层没有创建一个长度为16的数组
 *          2. jdk 8底层的数组是：Node[],而非Entry[]
 *          3. 首次调用put()方法时，底层创建长度为16的数组
 *          4. jdk8中底层结构：数组+链表+红黑树。
 *              4.1 形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
 *              4.2 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8且当前数组的长度 > 64时，此时此索引位置上的所数据改为使用红黑树存储。
 *
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量：16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *      threshold：扩容的临界值 = 容量*填充因子：16 * 0.75 = 12
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树：8
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量：64
 *
 *
 *  四、LinkedHashMap的底层实现原理（了解）
 *      源码：
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *          Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *          Entry(int hash, K key, V value, Node<K,V> next) {
 *              super(hash, key, value, next);
 *          }
 *      }
 *
 *
 * 五、Map中定义的方法：
 *      添加、删除、修改操作：
 *          Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *          void putAll(Map m):将m中的所有key-value对存放到当前map中
 *          Object remove(Object key)：移除指定key的key-value对，并返回value
 *          void clear()：清空当前map中的所有数据
 *      元素查询的操作：
 *          Object get(Object key)：获取指定key对应的value
 *          boolean containsKey(Object key)：是否包含指定的key
 *          boolean containsValue(Object value)：是否包含指定的value
 *          int size()：返回map中key-value对的个数
 *          boolean isEmpty()：判断当前map是否为空
 *          boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *      元视图操作的方法：
 *          Set keySet()：返回所有key构成的Set集合
 *          Collection values()：返回所有value构成的Collection集合
 *          Set entrySet()：返回所有key-value对构成的Set集合
 *
 *
 *  总结：常用方法：
 *      添加：put(Object key,Object value)
 *      删除：remove(Object key)
 *      修改：put(Object key,Object value)
 *      查询：get(Object key)
 *      长度：size()
 *      遍历：keySet() / values() / entrySet()
 *
 * @author zzq
 * @creat 2020-05-29 14:37
 */
public class MapTest {

    @Test
    public void test1(){
//        HashMap hashMap = new HashMap();
        HashMap hashMap = new LinkedHashMap();
//        Hashtable hashtable = new Hashtable();
        hashMap.put(123,"AA");
        hashMap.put(234,"CC");
        hashMap.put(1432,"HH");
        hashMap.put(343,"EE");
        System.out.println(hashMap);
//        hashtable.put(null,123);

    }



    /*
     添加、删除、修改操作：
        Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        void putAll(Map m):将m中的所有key-value对存放到当前map中
        Object remove(Object key)：移除指定key的key-value对，并返回value
        void clear()：清空当前map中的所有数据
    */
    @Test
    public void test2(){
        HashMap hashMap = new HashMap();

        //Object put(Object key,Object value)
        hashMap.put("AA",123);
        hashMap.put(45,123);
        hashMap.put("BB",56);
        //修改：
        hashMap.put("AA",87);
        System.out.println(hashMap);

        //Object remove(Object key)
        HashMap hashMap1 = new HashMap();
        hashMap1.put("CC",123);
        hashMap1.put("DD",123);
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);

        //Object remove(Object key)
        Object cc = hashMap.remove("CC");
        System.out.println(cc);
        System.out.println(hashMap);

        //void clear()
        hashMap.clear();//与map = null操作不同
        System.out.println(hashMap.size());
        System.out.println(hashMap);
    }



    /*
    元素查询的操作：
        Object get(Object key)：获取指定key对应的value
        boolean containsKey(Object key)：是否包含指定的key
        boolean containsValue(Object value)：是否包含指定的value
        int size()：返回map中key-value对的个数
        boolean isEmpty()：判断当前map是否为空
        boolean equals(Object obj)：判断当前map和参数对象obj是否相等
    */
    @Test
    public void test3(){
        Map hashMap = new HashMap();
        hashMap.put("AA",123);
        hashMap.put(45,123);
        hashMap.put("BB",56);

        //Object get(Object key)
        System.out.println(hashMap.get("AA"));

        //boolean containsKey(Object key)
        System.out.println(hashMap.containsKey("BB"));

        //boolean containsValue(Object value)
        System.out.println(hashMap.containsValue(123));

        //boolean isEmpty()//判断size==0
        HashMap hashMap1 = new HashMap();
        System.out.println(hashMap1.isEmpty());

        //boolean equals(Object obj)
        hashMap1.put("AA",123);
        hashMap1.put(45,123);
        hashMap1.put("BB",56);
        System.out.println(hashMap.equals(hashMap1));
    }



    /*
    元视图操作的方法：
        Set keySet()：返回所有key构成的Set集合
        Collection values()：返回所有value构成的Collection集合
        Set entrySet()：返回所有key-value对构成的Set集合

        */
    @Test
    public void test4(){
        Map hashMap = new HashMap();
        hashMap.put("AA",123);
        hashMap.put(45,123);
        hashMap.put("BB",56);

        //Set keySet()
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Collection values()
        Collection values = hashMap.values();
        for(Object object : values){
            System.out.println(object);
        }

        //Set entrySet()
        Set set1 = hashMap.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object object = iterator1.next();
            Map.Entry entry = (Map.Entry)object;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }

    }
}
