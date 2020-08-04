package sort;

import java.util.Arrays;

/**
 * @Description 排序算法练习
 * @ClassName test
 * @Author zzq
 * @Date 2020/8/2 9:14
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 9, 11, 10, 2};
//        bubble(arr);
//        System.out.println(Arrays.toString(arr));
//        select(arr);
//        System.out.println(Arrays.toString(arr));
//        insert(arr);
//        System.out.println(Arrays.toString(arr));
//        shell(arr);
//        System.out.println(Arrays.toString(arr));
//        quick(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//        radix(arr);
//        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @Description 冒泡
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 9:23
     */
    public static void bubble(int[] arr) {
        int temp;
        boolean isFlag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isFlag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (isFlag)
                isFlag = false;
            else
                break;
        }
    }

    /**
     * @Description 选择
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 9:23
     */
    public static void select(int[] arr) {
        int minIndex;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * @Description 插入
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 9:24
     */
    public static void insert(int[] arr) {
        int temp;
        int index;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            index = i;
            while (index > 0 && temp < arr[index - 1]) {
                arr[index] = arr[index - 1];
                index--;
            }
            if (index != i) {
                arr[index] = temp;
            }
        }
    }

    /**
     * @Description 希尔
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 9:24
     */
    public static void shell(int[] arr) {
        int temp;
        int index;
        for (int gap = arr.length / 3; gap > 0; gap /= 3) {
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                index = i;
                while (index - gap >= 0 && temp < arr[index - gap]) {
                    arr[index] = arr[index - gap];
                    index -= gap;
                }
                if (index != i) {
                    arr[index] = temp;
                }
            }
        }
    }

    /**
     * @Description 快速
     * @Param [arr, left, right]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 9:24
     */
    public static void quick(int[] arr, int left, int right) {
        int temp;
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        while (l < r) {
            while (arr[r] > pivot)
                r--;
            while (arr[l] < pivot)
                l++;
            if (l == r)
                break;
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            if (arr[r] == pivot)
                l++;
            if (arr[l] == pivot)
                r--;
        }
        if (l == r) {
            r--;
            l++;
        }
        if (left < r)
            quick(arr, left, r);
        if (r < right)
            quick(arr, l, right);
    }

    /**
     * @Description 基数
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 9:24
     */
    public static void radix(int[] arr) {
        int index;
        int max = arr[0];
        int[] count = new int[10];
        int[][] bucket = new int[10][arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        int length = Integer.toString(max).length();
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            index = 0;
            for (int k : arr) {
                int value = k / n % 10;
                bucket[value][count[value]] = k;
                count[value]++;
            }
            for (int j = 0; j < 10; j++) {
                if (count[j] != 0) {
                    for (int k = 0; k < count[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                    count[j] = 0;
                }
            }

        }
    }

    /**
     * @Description 归并
     * @Param [arr, left, mid, right]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 9:24
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int temp = left;
        int[] tempArr = new int[arr.length];
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                tempArr[temp] = arr[l];
                temp++;
                l++;
            } else {
                tempArr[temp] = arr[r];
                temp++;
                r++;
            }
        }
        while (l <= mid) {
            tempArr[temp] = arr[l];
            temp++;
            l++;
        }
        while (r <= right) {
            tempArr[temp] = arr[r];
            temp++;
            r++;
        }
        while (left <= right) {
            arr[left] = tempArr[left];
            left++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
}
