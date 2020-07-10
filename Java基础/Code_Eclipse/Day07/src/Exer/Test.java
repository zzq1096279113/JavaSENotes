package Exer;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] =temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
			int temp1 = arr[i];
			arr[i] = arr[j];
			arr[j] = temp1;
		}
		System.out.println(Arrays.toString(arr));
		
		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i];
		}
		System.out.println(Arrays.toString(arr1));
		
		int desc = 22;
		boolean isFind = true;
		for(int i = 0; i < arr1.length; i++) {
			if(desc == arr[i]) {
				System.out.println("找到了，位置为：" + i);
				isFind = false;
				break;
			}
		}
		if(isFind) {
			System.out.println("没找到");	
		}
	}
}
