package search;

/**
 * @Description 顺序（线性）查找
 * @ClassName SeqSearch
 * @Author zzq
 * @Date 2020/8/4 9:36
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, -11);
        if (index == -1)
            System.out.println("数组中没有此数字");
        else
            System.out.println("数字在数组中的索引为：" + index);
    }

    /**
     * @Description 顺序查找：找到一个满足条件的值就返回
     * @Param [arr, value]
     * @Return int
     * @Author zzq
     * @Date 2020/8/4 9:40
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
