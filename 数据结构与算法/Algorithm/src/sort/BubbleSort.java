package sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序法
 * @ClassName BubbleSort
 * @Author zzq
 * @Date 2020/8/1 17:39
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        reverseBubbleSort(arr);
//        System.out.println("排序后：" + Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序法所花费的时间为：" + (end - start));
    }

    /**
     * @Description 冒泡排序法：对数组进行从小到大排序
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 9:13
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = false;   //用于标记是否交换过元素
        for (int i = 0; i < arr.length - 1; i++) {  //排序的轮数为：数组长度 - 1
            for (int j = 0; j < arr.length - 1 - i; j++) {  //每轮交换的次数为：数组长度 - 1 - 排序的轮数
                if (arr[j] > arr[j + 1]) {  //如果前面的数比后面的大，则交换数据
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {   //如果进行过交换，继续循环并重置flag
                flag = false;
            } else {  //如果没进行过交换，退出循环
                break;
            }
        }
    }

    /**
     * @Description 冒泡排序法：对数组进行从大到小排序
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 9:38
     */
    public static void reverseBubbleSort(int[] arr) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
    }
}
