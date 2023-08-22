package aigo.Product.exception;

import static aigo.util.Print.printArray;

/**
 * @Description https://leetcode.cn/problems/product-of-array-except-self
 * 给你一个整数数组nums，返回数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据保证数组nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内
 * @Author Administrator
 * @Date 2023/5/19 21:44
 * @Version 1.0.0
 */
public class ProductExceptSelfV1 extends ProduceExceptionSuper {
    /**
     * 采用两个临时数组，一个用来保存当前数组中数字在它前面的全部数字之积，一个用来保存当前数组中数字在它后面的全部数字之积，
     * 结果数组answer等于这两个数组对应下标之积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[]beforeTarget = new int[length];
        int[]afterTarget = new int[length];
        int[]answer = new int[length];
        int placeHolder = 1;
        for(int i = 0 ; i < length ; i++){
            if(i == 0){
                beforeTarget[i] = placeHolder;
            }else{
                beforeTarget[i] = nums[i - 1] *  beforeTarget[i - 1];
            }
        }
        for(int i = length - 1 ; i >= 0 ; i--){
            if(i == length - 1){
                afterTarget[i] = placeHolder;
            }else{
                afterTarget[i] = nums[i + 1] * afterTarget[i + 1];
                }
            }
        for(int i = 0 ; i < length ; i++){
            answer[i] = beforeTarget[i] * afterTarget[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        ProductExceptSelfV1 productExceptSelfV1 = new ProductExceptSelfV1();
        //[24,12,8,6]
        int[]nums1 = {1,2,3,4};
        int[]answer1 = productExceptSelfV1.productExceptSelf(nums1);
        printArray(answer1);
        //[0,0,9,0,0]
        int[]nums2 = {-1,1,0,-3,3};
        int[]answer2 = productExceptSelfV1.productExceptSelf(nums2);
        printArray(answer2);
    }
}
