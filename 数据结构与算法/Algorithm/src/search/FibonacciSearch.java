package search;

import java.util.Arrays;

/**
 * @Description 斐波那契查找
 * @ClassName FibonacciSearch
 * @Author zzq
 * @Date 2020/8/4 14:46
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int index = fibonacciSearch(arr, 1);
        if (index == -1)
            System.out.println("数组中没有此数字");
        else
            System.out.println("数字在数组中的索引为：" + index);
    }

    /**
     * @Description 斐波那契查找法：(F[k]-1)=(F[k-1]-1)+(F[k-2]-1)+1
     * @Param [arr, value]
     * @Return int
     * @Author zzq
     * @Date 2020/8/4 15:42
     */
    public static int fibonacciSearch(int[] arr, int value) {
        int k = 0;  //表示斐波那契数值的下标
        int left = 0;
        int mid;
        int right = arr.length - 1;
        int[] fibonacci = fibonacci();  //得到一个斐波那契数组
        while (fibonacci[k] - 1 < arr.length)   //在斐波那契数组中寻找一个比arr数组大的值
            k++;
        int[] temp = deal(arr, fibonacci[k] - 1);
        while (left <= right) {     //斐波那契数列被分为三段 fibonacci[k-1]-1，mid，fibonacci[k-2]-1
            mid = left + fibonacci[k - 1] - 1;  //取得中间的值
            System.out.println(temp[mid]);
            if (value < temp[mid]) {
                right = mid - 1;    //右索引指向 mid-1 处
                k--;        //移动k到k-1位置
            } else if (value > temp[mid]) {
                left = mid + 1;    //左索引指向 mid+1 处
                k -= 2;     //移动k到k-2位置
            } else {
                //如果在原数组长度之内找到，则直接返回
                //如果在原数组长度之外找到，则返回边界
                return Math.min(mid, right);
            }
        }
        return -1;
    }

    /**
     * @Description 获取一个斐波那契数组
     * @Param []
     * @Return int[]
     * @Author zzq
     * @Date 2020/8/4 15:00
     */
    public static int[] fibonacci() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * @Description 对传进来的数组进行增长处理
     * @Param [arr, length]
     * @Return int[]
     * @Author zzq
     * @Date 2020/8/4 15:42
     */
    public static int[] deal(int[] arr, int length) {
        if (arr.length == length) {
            return arr;
        } else {
            int[] newArr = Arrays.copyOf(arr, length);
            for (int i = arr.length; i < length; i++) {
                newArr[i] = arr[arr.length - 1];
            }
            return newArr;
        }
    }
}
