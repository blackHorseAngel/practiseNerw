package aigo.Pow.subArray;

/**
 * @Description https://leetcode.cn/problems/subarray-product-less-than-k
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 * @Author Administrator
 * @Date 2023/3/7 21:05
 * @Version 1.0.0
 */
public class PowSubArray extends PowSubArraySuper {
    //
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int temp = 1;
        for(int i = 0 ; i < nums.length ; i++){
            temp = 1;
            for(int j = i ; j < nums.length ; j++){
                temp = temp * nums[j];
                if(temp < k){
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //8 [10],[5],[2],[6],[10,5],[5,2],[5,2,6],[2,6]
//      int[]nums = {10,5,2,6};
      //0
      int[]nums = {1,2,3};
      PowSubArray powSubArray = new PowSubArray();
      int num = powSubArray.numSubarrayProductLessThanK(nums,0);
      System.out.println(num);
    }
}
