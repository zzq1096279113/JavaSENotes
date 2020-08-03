package sort;

import java.util.Arrays;

/**
 * @Description 快速排序
 * @ClassName QuickSort
 * @Author zzq
 * @Date 2020/8/2 17:41
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println("排序后：" + Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("快速排序法所花费的时间为：" + (end - start));
    }

    /**
     * @Description 快速排序：从小到大
     * @Param [arr, left, right]
     * @Return void
     * @Author zzq
     * @Date 2020/8/3 10:49
     */
    public static void quickSort(int[] arr, int left, int right) {
        int temp;
        int l = left;   //标记为左索引
        int r = right;  //标记为右索引
        int pivot = arr[(left + right) / 2];    //基准值
        while (l < r) {     //左边索引小于右边索引就可以进行循环
            while (arr[r] > pivot)      //在基准值右边寻找小于等于基准值的值
                r--;
            while (arr[l] < pivot)      //在基准值左边寻找大于等于基准值的值
                l++;
            if (l == r)     //当l与r相遇时，跳出循环（极限为l与r同时指向同一个基准值）
                break;
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot)     //当左索引指向基准值时，只需要移动右索引就可以了
                r--;
            if (arr[r] == pivot)     //当右索引指向基准值时，只需要移动左索引就可以了
                l++;
        }
        if (l == r) {   //现在l和r应该指向基准值
            l++;    //将l移动到右边当left
            r--;    //将r移动到左边当right
        }
        if (left < r)   //向左递归
            quickSort(arr, left, r);
        if (l < right)  //向右递归
            quickSort(arr, l, right);
    }
}
