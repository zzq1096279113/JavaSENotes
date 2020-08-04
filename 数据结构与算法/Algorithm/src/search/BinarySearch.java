package search;

import java.util.ArrayList;

/**
 * @Description 二分法查找
 * @ClassName BinarySearch
 * @Author zzq
 * @Date 2020/8/4 9:56
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        ArrayList<Integer> indexList = binarySearchAll(arr, 0, arr.length - 1, 1000);
        if (indexList.isEmpty()) {
            System.out.println("数组中没有此数字");
        } else {
            System.out.println("数字在数组中的索引为：" + indexList);
        }
    }

    /**
     * @Description 二分法查找：返回第一个找到的位置
     * @Param [arr, left, right, value]
     * @Return int
     * @Author zzq
     * @Date 2020/8/4 10:10
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[0] || arr[arr.length - 1] < value) {    //没有找到的情况
            return -1;
        }
        int mid = (left + right) / 2;
        if (value < arr[mid]) {   //如果要查找的值小于中间值，向左递归
            return binarySearch(arr, left, mid - 1, value);
        } else if (value > arr[mid]) {    //反之，则向右递归
            return binarySearch(arr, mid + 1, right, value);
        } else {    //找到的情况
            return mid;
        }
    }

    /**
     * @Description 二分法查找：返回找到的所有位置
     * @Param [arr, left, right, value]
     * @Return int
     * @Author zzq
     * @Date 2020/8/4 10:29
     */
    public static ArrayList<Integer> binarySearchAll(int[] arr, int left, int right, int value) {
        int temp;
        ArrayList<Integer> indexList = new ArrayList<>();
        if (left > right) { //没找到的情况
            return indexList;
        }
        int mid = (left + right) / 2;
        if (value < arr[mid]) {   //如果要查找的值小于中间值，向左递归
            return binarySearchAll(arr, left, mid - 1, value);
        } else if (value > arr[mid]) {    //反之，则向右递归
            return binarySearchAll(arr, mid + 1, right, value);
        } else {    //找到的情况
            indexList.add(mid);
            temp = mid - 1;     //从mid的左边一位扫描
            while (temp >= 0 && arr[temp] == arr[mid]) {    //判断是否遍历到头或值是否相等
                indexList.add(temp);    //将temp加入List
                temp--;
            }
            temp = mid + 1;     //从mid的右边一位扫描
            while (temp <= arr.length - 1 && arr[temp] == arr[mid]) {    //判断是否遍历到头或值是否相等
                indexList.add(temp);    //将temp加入List
                temp++;
            }
            return indexList;
        }
    }
}
