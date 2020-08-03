package sort;

import java.util.Arrays;

/**
 * @Description 基数排序
 * @ClassName RadixSort
 * @Author zzq
 * @Date 2020/8/3 16:53
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        radixSort(arr);
//        System.out.println("排序后：" + Arrays.toString(arr));
        int[] arr = new int[80000];
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("基数排序法所花费的时间为：" + (end - start));
    }

    /**
     * @Description 基数排序
     * @Param [arr]
     * @Return void
     * @Author zzq
     * @Date 2020/8/3 17:26
     */
    public static void radixSort(int[] arr) {
        int value;
        int index;
        int max = arr[0];   //假定第一个是最大值
        int[][] bucket = new int[10][arr.length];   //定义一个二维数组包含10个一维数组，防止溢出每个一维数组大小定义为arr.length
        int[] count = new int[10];    //用于记录各个桶放入数据的个数
        for (int i = 1; i < arr.length; i++) {  //遍历数组找到最大值
            if (max < arr[i])
                max = arr[i];
        }
        int maxLength = Integer.toString(max).length();   //将最大值转为字符串，得到字符串长度即为最大值的位数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {   //n为控制取出的位数
            index = 0;
            for (int item : arr) {      //遍历arr数组
                value = item / n % 10;  //判断相应位数的值
                bucket[value][count[value]] = item;     //将数据放入二维数组中
                count[value]++;
            }
            for (int k = 0; k < count.length; k++) {    //遍历二维数组取出数据
                if (count[k] != 0) {        //如果桶中没有数据，略过
                    for (int l = 0; l < count[k]; l++) {    //如果有数据，遍历并取出数据
                        arr[index] = bucket[k][l];  //放回arr数组
                        index++;
                    }
                }
                count[k] = 0;   //判断、遍历过的位数清零。以便下次大循环
            }
        }
    }
}
