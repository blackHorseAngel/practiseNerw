package Aigo.Subsequence.Difference;

/**
 *@Desprition 给你一个整数数组arr和一个整数difference,请你找出并返回arr中最长等差子序列的长度,该子序列中相邻元素之间的差等于difference 。
 * 子序列是指在不改变其余元素顺序的情况下,通过删除一些元素或不删除任何元素而从arr派生出来的序列。
 * 输入：arr=[1,2,3,4], difference=1
 * 输出：4
 * 解释：最长的等差子序列是[1,2,3,4]。
 * 输入：arr=[1,3,5,7], difference=1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 输入：arr=[1,5,7,8,5,3,4,2,1], difference=-2
 * 输出：4
 * 解释：最长的等差子序列是[7,5,3,1]。
 *@Author zhangshenming
 *@Date 2021/11/17 19:46
 *@Version 1.0
 */
public class SubsequenceOgGivenDifferenceV1 extends SubsequenceDifferenceSuper {
    /**
     *@Description
     *@Author zhangshenming
     *@Param arr, difference
     *@Date 2021/11/17 19:48
     *@Return int
     */
    public int longestSubsequence(int[] arr, int difference) {
        int temp = 0;
        int num = 0;
        for(int i = 0;i < arr.length;i++){
           int count = 0;
            temp = arr[i];
            for(int j = i ; j < arr.length ; j++){
                if(arr[j] == temp){
                    count++;
                    temp += difference;
                }
            }
            num = num < count ? count : num;
        }
        return num;
    }
    /**
     *@Description
     *@Author zhangshenming
     *@Param arr, difference
     *@Date 2021/11/19 8:31
     *@Return int
     */
    public int longestSubsequence2(int[] arr, int difference) {
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
        SubsequenceOgGivenDifferenceV1 subsequenceOgGivenDifferenceV1 = new SubsequenceOgGivenDifferenceV1();
        int elementNumber = subsequenceOgGivenDifferenceV1.longestSubsequence(arr,difference);
        System.out.println("最长定差子序列是：" + elementNumber);
    }
}
