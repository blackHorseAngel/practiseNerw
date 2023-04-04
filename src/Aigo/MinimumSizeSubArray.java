package Aigo;

/**
 * @Description https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * @Author Administrator
 * @Date 2023/3/6 16:15
 * @Version 1.0.0
 */
public class MinimumSizeSubArray{

   public static int minSubArrayLen(int[]nums,int target){
       //用于存储子数组和
//        int[]dp = new int[nums.length];
       //用于存储等于或大于target的子数组的长度
        int[]lp = new int[nums.length];
        //子数组临时和
        int temp = 0;
        //最终返回的最小子数组长度
        int minLength = nums.length + 1;
        for(int i = 0 ; i < nums.length ; i++){
            temp = 0;
            for(int j = i ; j < nums.length ; j++){
                temp = temp + nums[j];
                if(temp >= target){
//                    dp[i] = temp;
                    lp[i] = j - i + 1;
                    minLength = Math.min(minLength,lp[i]);
                    break;
                }
            }
        }
       return minLength > nums.length ? 0 : minLength;
   }

    public static void main(String[] args) {
//     int[]nums = {2,3,1,2,4,3};
//        int[]nums = {1,4,4};
        int[]nums = {1,1,1,1,1,1,1,1};
     int minLength = minSubArrayLen(nums,11);
        System.out.println(minLength);
    }
}
