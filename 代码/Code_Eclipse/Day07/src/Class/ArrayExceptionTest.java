package Class;
/**
 * 
 * @Descripion	常见异常	
 * @author zzq
 * @version
 * @date 2020年5月8日下午3:04:58
 */
public class ArrayExceptionTest {
	public static void main(String[] args) {
		
		//1.数组角标越界异常:ArrayIndexOutOfBoundsException
//		for(int i = 0; i <= arr1.length; i++) {
//			System.out.println(arr1[i]);
//		}	
//		System.out.println(arr1[-2]);
		
		//2.空指针异常:NullPointerException
//		//情况一:
//		arr1 = null;
//		System.out.println(arr1[0]);
//		//情况二:
		int[][] arr2 = new int[4][];
		System.out.println(arr2[0][0]);
//		//情况三:
//		String[] arr2 = new String[] {null,"BB","CC"};
//		System.out.println(arr2[0].toString());	
	}
}
