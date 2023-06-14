package Aigo.Long.SubArray;

/**
 * @Description https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element
 * 给你一个二进制数组nums，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 1 <= nums.length <= 105
 * nums[i]要么是0要么是1 。
 * @Author Administrator
 * @Date 2023/6/4 15:24
 * @Version 1.0.0
 */
public class LongestSubArrayV1 extends LongestSubArraySuper{
    /**
     *
     * @param nums
     * @return
     */
    @Override
    public int longestSubArray(int[] nums) {
        int count = 0;
        int maxLength = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int num = 1;
            for(int j = i ; j < nums.length ; j++){
                if(nums[j] == 0){
                    num--;
                    if(num < 0){
                        break;
                    }
                }
                count++;
            }
            if(count == nums.length){
                return count - 1;
            }
            maxLength = Math.max(maxLength,count);
            count = 0;
            if(nums.length - i < maxLength){
                break;
            }
        }
        return maxLength-1;
    }

    public static void main(String[] args) {
        //3
//        int[]nums = {1,1,0,1};
        //5
//        int[]nums = {0,1,1,1,0,1,1,0,1};
        //2
        int[]nums = {1,1,1};
        LongestSubArrayV1 longestSubArray = new LongestSubArrayV1();
        int num = longestSubArray.longestSubArray(nums);
        System.out.println(num);
    }
}
