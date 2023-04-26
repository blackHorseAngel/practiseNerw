package Aigo;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/4/2 19:59
 * @Version 1.0.0
 */
public class TigerMachine {
    /**
     *
     * @param n
     * @param arr
     */
    public static void getBitOfNum(int n,int[]arr){
            for(int j = 0 ; j <= 9 ; j++){
                arr[n] = j ;
                if(n == 0){
                    printArr(arr);
                    continue;
                }
                getBitOfNum(n-1,arr);
            }
    }
    public static void getBitOfNum2(int bit,int result){
        int temp = result * 10;
        for(int j = 0 ; j <= 9 ; j++){
            result = temp + j;
            if(bit == 1){
                System.out.println(result);
                continue;
            }
            getBitOfNum2(bit-1,result);
        }
    }

    /**
     *
     * @param arr
     */
    public static void printArr(int[]arr){
        for(int i : arr){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int n = 3;
//        int[]arr = new int[n];
//       getBitOfNum(n,arr);

        getBitOfNum2(3,000);
    }
}
