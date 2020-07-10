package Class;
/*
 * 二维数组的使用:
 * 1.理解：
 * 对于二维数组的理解，我们可以看成是一维数组array1又作为另一个一维数组array2的元素而存在。
 * 其实，从数组底层的运行机制来看，其实没有多维数组。
 * 
 * 2. 二维数组的使用:
 *   ① 二维数组的声明和初始化
 *   ② 如何调用数组的指定位置的元素
 *   ③ 如何获取数组的长度
 *   ④ 如何遍历数组
 *   ⑤ 数组元素的默认初始化值
 *   ⑥ 数组的内存解析 
 * 
 */
public class ArryTest2 {
	public static void main(String[] args) {
		
		//① 二维数组的声明和初始化
		int[][] arr1 = new int[][] {{1,2,3},{5,6,7}, {12,34}};//静态初始化
		String[][] arr2 = new String[4][3];//动态初始化
		String[][] arr3 = new String[3][];
		
		//② 如何调用数组的指定位置的元素
		System.out.println(arr1[0][1]);//2
		System.out.println(arr2[1][1]);//null
		arr3[1] = new String[4];
		System.out.println(arr3[1][1]);//null
		
		//③ 如何获取数组的长度
		System.out.println(arr1.length);//3
		System.out.println(arr1[2].length);//2
		
		//④ 如何遍历数组
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		
		//⑤ 数组元素的默认初始化值
//		int[][] arr4 = new int[4][3];
//		System.out.println(arr4[0]);//[I@28a418fc
//		System.out.println(arr4[0][0]);//0
//		float[][] arr4 = new float[4][3];
//		System.out.println(arr4[0]);//[F@28a418fc
//		System.out.println(arr4[0][0]);//0.0
		String[][] arr4 = new String[4][3];
		System.out.println(arr4[0]);//[Ljava.lang.String;@28a418fc
		System.out.println(arr4[0][0]);//null
		
		int[][] arr5 = new int[4][];
		System.out.println(arr5[0]);//null
		System.out.println(arr5[0][0]);//报错

	}
}
