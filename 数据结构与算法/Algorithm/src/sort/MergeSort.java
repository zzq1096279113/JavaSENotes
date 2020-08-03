package sort;

import java.util.Arrays;

/**
 * @Description 归并排序
 * @ClassName MergeSort
 * @Author zzq
 * @Date 2020/8/3 15:25
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] tempArr = new int[arr.length];  //临时数组
//        System.out.println("排序前：" + Arrays.toString(arr));
//        mergeSort(arr, 0, arr.length - 1, tempArr);
//        System.out.println("排序后：" + Arrays.toString(arr));
        int[] arr = new int[80000];
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, tempArr);
        long end = System.currentTimeMillis();
        System.out.println("归并排序法所花费的时间为：" + (end - start));
    }

    /**
     * @Description 分解
     * @Param [arr, left, right]
     * @Return void
     * @Author zzq
     * @Date 2020/8/3 16:27
     */
    public static void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left < right) { //只要left < right，则证明还没有分解到只有1个数
            int mid = (left + right) / 2;   //算出中间索引
            mergeSort(arr, left, mid, tempArr);      //向左递归，mid是左边序列的最后一个数据
            mergeSort(arr, mid + 1, right, tempArr);     //向右递归，mid+1才是右边序列的开始
            merge(arr, left, mid, right, tempArr);   //当分解到无法分解时候，开始合并
        }
    }

    /**
     * @Description 合并
     * @Param [arr, left, mid, right]
     * @Return void
     * @Author zzq
     * @Date 2020/8/3 16:02
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        int i = left;       //初始化i，左边有序序列的第一位
        int j = mid + 1;    //初始化j，右边有序序列的第一位
        int temp = left;    //使合并的两个序列与原数组起始位置相同
        while (i <= mid && j <= right) {    //将左右两边的有序数组填充到临时数组，直到左右两边有一边处理完毕
            if (arr[i] <= arr[j]) {     //如果左序列的当前元素小于等于右序列的当前元素
                tempArr[temp] = arr[i]; //将左序列的当前元素拷贝到临时数组
                temp++; //移动temp索引
                i++;    //移动i索引
            } else {    //反之，将右序列当前元素拷贝到临时数组
                tempArr[temp] = arr[j];
                temp++;
                j++;
            }
        }
        while (i <= mid) {      //如果左序列还有数据，将剩余数据按顺序添加到临时数组
            tempArr[temp] = arr[i];
            temp++;
            i++;
        }
        while (j <= right) {    //如果右序列还有数据，将剩余数据按顺序添加到临时数组
            tempArr[temp] = arr[j];
            temp++;
            j++;
        }
        while (left <= right) {
            arr[left] = tempArr[left];  //将临时数组中排好序的数据复制回原数组的相应位置
            left++;
        }
    }
}
