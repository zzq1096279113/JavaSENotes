package search;

import java.util.Arrays;

/**
 * @Description 插值查找
 * @ClassName InsertValueSearch
 * @Author zzq
 * @Date 2020/8/4 11:05
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(index);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[0] || arr[arr.length - 1] < value) {
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);   //二分法查找为：left + 1 / 2 * (right - left)
        if (value < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, value);
        } else if (value > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
