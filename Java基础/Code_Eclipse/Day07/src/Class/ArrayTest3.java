package Class;

public class ArrayTest3 {
	public static void main(String[] args) {
		String[] arr = new String[] {"JJ","MM","GG","BB","AA","DD"};
		
		//数组的复制
		String[] arr1 = new String[arr.length];
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i];
		}
		
//		//数组的反转
//		for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
//			String temp = arr[i];
//			arr[i] = arr[j];
//			arr[j] = temp;
//		}
		
		//查找
			//线性查找：
//		String desc = "BB";
//		boolean isFlag = true;
//		for(int i = 0; i < arr1.length; i++) {
//			if(desc.equals(arr1[i])) {
//				System.out.println("找到了，位置为：" + (i + 1));
//				isFlag = false;
//				break;
//			}
//		}
//		if(isFlag)
//			System.out.println("没找到");	

			//二分法查找：前提所要查找的数组必须有序
		int[] arr2 = new int[] {-98,-56,-21,0,12,35,68,979};
		int dest = 35;
		int head = 0;	//初始的首索引
		int end = arr2.length - 1;//初始的末索引
		boolean isFlag = true; 
		while(head <= end) {
			int mid = (head + end) / 2;
			if(dest == arr2[mid]) {
				System.out.println("找到了，位置为：" + (mid + 1));
				isFlag = false;
				break;
			}else if(arr2[mid] > dest) {
				end = mid - 1;
			}else{
				head = mid + 1;
			}
		}
		if(isFlag)
			System.out.println("没找到");
		
//		for(int i = 0; i < arr1.length; i++) {
//			System.out.print(arr[i] + "\t");
//		}
	}
}
