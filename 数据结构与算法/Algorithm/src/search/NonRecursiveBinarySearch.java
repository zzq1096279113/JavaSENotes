package search;

/**
 * @Description 二分法查找：非递归
 * @ClassName NonRecursiveBinarySearch
 * @Author zzq
 * @Date 2020/8/10 14:54
 */
public class NonRecursiveBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 10);
        if (index == -1)
            System.out.println("数组中不存在此数据");
        else
            System.out.println("数据索引为：" + index);
    }

    /**
     * @Description 采用非递归的二分法查找，找到返回索引值，没有找到返回-1
     * @Param [arr, value]
     * @Return int
     * @Author zzq
     * @Date 2020/8/10 15:04
     */
    public static int binarySearch(int[] arr, int value) {
        int mid;
        int left = 0;   //左索引
        int right = arr.length - 1;     //右索引
        while (left <= right) {
            mid = (left + right) / 2;   //中间索引
            if (value < arr[mid])       //查找值小于中间值
                right = mid - 1;
            else if (arr[mid] < value)  //查找值大于中间值
                left = mid + 1;
            else        //找到
                return mid;
        }
        return -1;
    }
}
