package sort;

import java.util.Arrays;

/**
 * @Description 插入排序
 * @ClassName InsertSort
 * @Author zzq
 * @Date 2020/8/2 10:35
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        reverseInsertSort(arr);
//        System.out.println("排序后：" + Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("插入排序法所花费的时间为：" + (end - start));
    }

    /**
     * @Description 插入排序：从小到大
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 14:59
     */
    public static void insertSort(int[] arr) {
        int index;  //保存索引
        int temp;   //保存数据
        for (int i = 1; i < arr.length; i++) {
            index = i;
            temp = arr[i];
            while (index > 0 && temp < arr[index - 1]) {    //从后往前依次与带插入数据比较
                arr[index] = arr[index - 1];    //比待插入数据大的向后移一位
                index--;
            }
            if (index != i) {
                arr[index] = temp;
            }
        }
    }

    /**
     * @Description 插入排序：从大到小
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 15:01
     */
    public static void reverseInsertSort(int[] arr) {
        int index;
        int temp;
        for (int i = 1; i < arr.length; i++) {
            index = i;
            temp = arr[i];
            while (index > 0 && temp > arr[index - 1]) {
                arr[index] = arr[index - 1];
                index--;
            }
            if (index != i) {
                arr[index] = temp;
            }
        }
    }
}
