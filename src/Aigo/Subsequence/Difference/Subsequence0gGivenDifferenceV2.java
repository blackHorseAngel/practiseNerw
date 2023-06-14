package Aigo.Subsequence.Difference;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 18:28
 * @Version 1.0.0
 */
public class Subsequence0gGivenDifferenceV2 extends SubsequenceDifferenceSuper{
    /**
     *@Description
     *@Author zhangshenming
     *@Param arr, difference
     *@Date 2021/11/19 8:31
     *@Return int
     */
    public int longestSubsequence(int[] arr, int difference) {
        //用于标注使用过的数字
        boolean[]flag = new boolean[arr.length];
        int temp = 0;
        int num = 0;
        for(int i = 0;i < arr.length;i++){
            if(flag[i]){
                continue;
            }
            temp = arr[i];
            int count = 0;
            for(int j = i;j<arr.length;j++){
                if(arr[j] == temp){
                    flag[j] = true;
                    count++;
                    temp += difference;
                }
            }
            num = num < count ? count : num;
        }
        return num;
    }
    public static void main(String[] args) {
//        int[]arr = {1,2,3,4};
//        int difference = 1;
        int[]arr = {1,3,5,7};
        int difference = 1;
//        int[]arr = {1,5,7,8,5,3,4,2,1};
//        int difference = -2;
//        int[]arr = {3,4,-3,-2,-4};
//        int difference = -5;
//        int[]arr = {3,0,-3,4,-4,7,6};
//        int difference = 3;
        Subsequence0gGivenDifferenceV2 Subsequence0gGivenDifferenceV2 = new Subsequence0gGivenDifferenceV2();
        int elementNumber = Subsequence0gGivenDifferenceV2.longestSubsequence(arr,difference);
        System.out.println("最长定差子序列是：" + elementNumber);
    }
}
