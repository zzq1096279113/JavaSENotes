package sort;

import java.util.Arrays;

/**
 * @Description 堆排序
 * @ClassName HeapSort
 * @Author zzq
 * @Date 2020/8/6 16:43
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        System.out.println("排序前：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 800000);
//        }
//        long start = System.currentTimeMillis();
//        heapSort(arr);
//        long end = System.currentTimeMillis();
//        System.out.println("堆排序法所花费的时间为：" + (end - start));
    }

    /**
     * @Description 调整大顶堆
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/6 17:50
     */
    public static void heapSort(int[] arr) {
        int temp;
        for (int i = arr.length / 2 - 1; i >= 0; i--)       //从第一个非叶子节点从下至上，从右至左
            adjustBigHeap(arr, i, arr.length);
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];    //数组中最大值一定在第一位
            arr[0] = temp;
            adjustBigHeap(arr, 0, j); //找到最大的与根节点互换
        }

    }

    /**
     * @Description 构建大顶堆
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/6 16:48
     */
    public static void adjustBigHeap(int[] arr, int index, int length) {
        int temp = arr[index];          //先取出当前节点的值保存
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {    //遍历index的左子节点
            if (i + 1 < length && arr[i] < arr[i + 1])     //找到最大的子节点，可以遍历到右子节点
                i++;
            if (temp < arr[i]) {      //如果子节点大于父节点，将较大的值赋给当前节点
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        arr[index] = temp;
    }

    /**
     * @Description 构建小顶堆
     * @Param [arr, index, length]
     * @Return void
     * @Author zzq
     * @Date 2020/8/6 18:05
     */
    public static void adjustSmallHeap(int[] arr, int index, int length) {
        int temp = arr[index];          //先取出当前节点的值保存
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {    //遍历index的左子节点
            if (i + 1 < length && arr[i] > arr[i + 1])     //找到最大的子节点，可以遍历到右子节点
                i++;
            if (temp > arr[i]) {      //如果子节点大于父节点，将较大的值赋给当前节点
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        arr[index] = temp;
    }
}
