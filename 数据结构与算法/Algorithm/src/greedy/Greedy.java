package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description 贪心算法：覆盖问题
 * @ClassName Greedy
 * @Author zzq
 * @Date 2020/8/12 9:23
 */
public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcast = new HashMap<>();   //电台与地区的HashMap
        addEntry(broadcast);    //HashMap中加入数据
        ArrayList<String> greedy = greedy(broadcast);   //处理完得到ArrayList
        System.out.println(greedy);
    }

    public static ArrayList<String> greedy(HashMap<String, HashSet<String>> broadcast) {
        HashSet<String> allAreas = new HashSet<>();     //所有的地区
        HashSet<String> tempSet = new HashSet<>();      //临时变量
        ArrayList<String> select = new ArrayList<>();   //选定的电台
        String maxKey;      //当前最优解
        int maxTemp;    //当前最大覆盖的地区个数
        for (Map.Entry<String, HashSet<String>> entry : broadcast.entrySet()) {
            allAreas.addAll(entry.getValue());  //将所有电台覆盖的地区加入并去重
        }
        while (!allAreas.isEmpty()) {
            maxTemp = 0;
            maxKey = null;
            for (String key : broadcast.keySet()) {       //遍历所有电台
                tempSet.clear();    //清除上次留下的数据
                tempSet.addAll(broadcast.get(key));     //得到电台覆盖的地区加入临时HashSet
                tempSet.retainAll(allAreas);        //得到与剩余没有覆盖到地方的交集
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > maxTemp)) { //没有找到或是找到更大的覆盖数
                    maxKey = key;
                    maxTemp = tempSet.size();
                }
            }
            if (maxKey != null) {
                select.add(maxKey);
                allAreas.removeAll(broadcast.get(maxKey));     //将已经被覆盖的地区从所有地区中删除
                broadcast.remove(maxKey);   //删除电台
            }
        }
        return select;
    }

    /**
     * @Description 给传入的HashMap加入数据
     * @Param [broadcast]
     * @Return void
     * @Author zzq
     * @Date 2020/8/12 9:45
     */
    public static void addEntry(HashMap<String, HashSet<String>> broadcast) {
        HashSet<String> hashSet1 = new HashSet<>();   //K1
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();   //K2
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();   //K3
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();   //K4
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();   //K5
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcast.put("K1", hashSet1);
        broadcast.put("K2", hashSet2);
        broadcast.put("K3", hashSet3);
        broadcast.put("K4", hashSet4);
        broadcast.put("K5", hashSet5);
    }

}
