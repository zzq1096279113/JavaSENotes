package sort;

import java.util.Arrays;

/**
 * @Description 希尔排序
 * @ClassName ShellSort
 * @Author zzq
 * @Date 2020/8/2 16:28
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前：" + Arrays.toString(arr));
        shellSort2(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 800000);
//        }
//        long start = System.currentTimeMillis();
//        shellSort2(arr);
//        long end = System.currentTimeMillis();
//        System.out.println("希尔排序法所花费的时间为：" + (end - start));
    }

    /**
     * @Description 希尔排序【交换法】：从小到大
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 18:32
     */
    public static void shellSort1(int[] arr) {
        int temp;
        for (int gap = arr.length / 3; gap > 0; gap /= 3) {
            for (int i = gap; i < arr.length; i++) {    //将数组分为gap组，从arr[gap]处开始遍历数组
                for (int j = i - gap; j >= 0; j -= gap) {   //将分完组中每组的元素都遍历
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

    }

    /**
     * @Description 希尔排序【移位法】：从小到大
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 18:38
     */
    public static void shellSort2(int[] arr) {
        int index;
        int temp;
        for (int gap = arr.length / 3; gap > 0; gap /= 3) {
            for (int i = gap; i < arr.length; i++) {
                index = i;
                temp = arr[i];
                while (index - gap >= 0 && temp < arr[index - gap]) {   //先判断是否有数，再判断两个数据大小
                    arr[index] = arr[index - gap];  //将index - gap位置的数据复制到index位置
                    index -= gap;   //移动索引到index - gap位置
                }
                arr[index] = temp;
            }
        }
    }

    /**
     * @Description 希尔排序【移位法】：从大到小
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/2 19:12
     */
    public static void reverseShellSort2(int[] arr) {
        int index;
        int temp;
        for (int gap = arr.length / 3; gap > 0; gap /= 3) {
            for (int i = gap; i < arr.length; i++) {
                index = i;
                temp = arr[i];
                while (index - gap >= 0 && temp > arr[index - gap]) {
                    arr[index] = arr[index - gap];  //将index - gap位置的数据复制到index位置
                    index -= gap;   //移动索引到index - gap位置
                }
                arr[index] = temp;
            }
        }
    }
}