package sort;

import java.util.Arrays;

/**
 * @Description 选择排序
 * @ClassName SelectSort
 * @Author zzq
 * @Date 2020/8/2 9:49
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 9};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println("排序后：" + Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("选择排序法所花费的时间为：" + (end - start));
    }

    /**
     * @Description 选择排序：从小到大
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 10:16
     */
    public static void selectSort(int[] arr) {
        int temp;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) { //如果假定的最小值并不是最小的
                    minIndex = j;   //更换索引，变为更小值的索引
                }
            }
            if (minIndex != i) {    //判断minIndex是否变动过，如果没有变动，说明位置刚刚好
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * @Description 选择排序：从大到小
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 10:18
     */
    public static void reverseSelectSort(int[] arr) {
        int temp;
        int maxIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
