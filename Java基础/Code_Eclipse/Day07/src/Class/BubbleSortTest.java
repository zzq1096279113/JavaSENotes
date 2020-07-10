package Class;
/**
 * 
 * @Descripion 冒泡排序
 * @author zzq
 * @version
 * @date 2020年5月8日下午2:18:19
 */
public class BubbleSortTest {
	public static void main(String[] args) {
		int[] arr = new int[] {32,45,657,32,56,5959,655,324};
		
		//冒泡排序
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		//遍历
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
