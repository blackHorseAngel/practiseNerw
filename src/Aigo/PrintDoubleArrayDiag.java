package Aigo;

/**
 * @description 打印二位数组的对称元素
 * @author zhangshenming
 * @date 2021/5/19 16:38
 * @see 1.0.0
 */
public class PrintDoubleArrayDiag {
    public static void main(String[] args) {
        int[][] array = initDouble(5);
        printArray(array);
        int length = array.length-1;
        int x = 0;
        for (int d = 0; d <= length*2; d++) {
            for (int y = 0; y <=length; y++) {
                x=d-y;
                if(x>=0 && x<=length){
                   System.out.print(array[x][y]+" ");
                }
            }
            System.out.println();

        }
    }
    /**
     *@description 初始化二维数组
     *@author zhangshenming
     *@param length
     *@date 2021/5/22 15:58
     *@return int[][]
     *@throws
     
     */ 
    public static int[][]initDouble(int length){
        int[][]arr = new int[length][length];
        int m = 1;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                arr[x][y] = m;
                m++;
            }
        }
        return arr;
    }
    /***
     *@description 打印二维数组
     *@author zhangshenming
     *@param array
     *@date 2021/5/22 16:00
     *@return
     *@throws
     */
    public static void printArray(int[][]array){
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                System.out.println("数组序号是："+x+y+" : "+array[x][y]);
            }
        }
    }
}