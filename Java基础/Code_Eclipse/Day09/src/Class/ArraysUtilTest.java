package Class;

public class ArraysUtilTest {
	public static void main(String[] args) {
		ArraysUtil util = new ArraysUtil();
		int[] arrays = new int[] {32,345,765,42,121,5,78,56,3};
		
		int max = util.getMax(arrays);
		System.out.println("最大值为：" + max);
		
		int min = util.getMin(arrays);
		System.out.println("最小值为：" + min);
		
		int sum = util.getSum(arrays);
		System.out.println("总和为：" + sum);
		
		int avg = util.getAvg(arrays);
		System.out.println("平均值为：" + avg);
		
//		System.out.println("排序前：");
//		util.print(arrays);
//		util.sort(arrays);
//		System.out.println("排序后：");
//		util.print(arrays);
		
		System.out.print("查找：");
		int index = util.getIndex(arrays, 5);
		if(index >= 0) {
			System.out.println("找到了，索引为：" + index);
		}else {
			System.out.println("没找到");
		}
	}
}
