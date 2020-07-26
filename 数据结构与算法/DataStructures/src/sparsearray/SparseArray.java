package sparsearray;

/**
 * @author zzq
 * @creat 2020-06-02 8:19
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0：没有棋子  1：黑色棋子  2：蓝色棋子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][6] = 1;
        chessArr1[6][7] = 2;

        //将二维数组转换为稀疏数组
        //1.先遍历得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }

        //2.创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //3.遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;//i：代表第i行
                    sparseArray[count][1] = j;//j：代表第j列
                    sparseArray[count][2] = chessArr1[i][j];//代表第i行第j列的值
                }
            }
        }

        for (int i = 0; i < sparseArray.length; i++) {
            System.out.println(sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2]);
        }
        System.out.println();


        //将稀疏数组 --> 恢复成原始的二维数组
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //2. 在读取稀疏数组后几行的数据（从第二行开始），并赋给原始的二维数组即可.
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }
}
