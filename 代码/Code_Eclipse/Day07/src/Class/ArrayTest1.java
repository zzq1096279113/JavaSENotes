package Class;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 90 + 10);
		}
		
		int maxValue = 0;
		int minValue = arr[0];
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			if(maxValue < arr[i]) {	//求最大值
				maxValue = arr[i];
			}
			if(minValue > arr[i]) {	//求最小值
				minValue = arr[i];
			}
			sum += arr[i];	//总和
		}
		System.out.println("最大值为：" + maxValue);
		System.out.println("最小值为：" + minValue);
		System.out.println("总和为：" + sum);
		System.out.println("平均值为：" + sum / arr.length);	//平均值
	}
}
