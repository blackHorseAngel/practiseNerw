package Aigo.Longest.Ones;

/**
 * @Description https://leetcode.cn/problems/max-consecutive-ones-iii
 * 给定一个二进制数组nums和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * 1 <= nums.length <= 105
 * nums[i]不是0就是1
 * 0 <= k <= nums.length
 * @Author Administrator
 * @Date 2023/6/4 14:57
 * @Version 1.0.0
 */
public class LongestOnesV1 extends LongestOnesSuper{
    @Override
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int num = k;
            for(int j = i ; j < nums.length ; j++){
                if(nums[j] == 0){
                    num--;
                    if(num < 0){
                        break;
                    }
                }
                count++;
            }
            maxLength = Math.max(maxLength,count);
            count = 0;
            if(nums.length-i < maxLength){
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        //6
        int[]nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        //10
        int[]nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;
        //25
        int[]nums = {1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        int k = 8;
        LongestOnesV1 longestOnes = new LongestOnesV1();
        int num = longestOnes.longestOnes(nums,k);
        System.out.println(num);
    }
}
