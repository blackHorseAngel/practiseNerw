package Aigo;

/**
 * @Description https://leetcode.cn/problems/find-peak-element/
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；或者返回索引 5， 其峰值元素为 6。
 *   1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * @Author Administrator
 * @Date 2023/2/28 16:52
 * @Version 1.0.0
 */
public class FindPeakElement {
    //遍历数组，寻找最大值
    public static int findPeakElement(int[] nums) {
        for(int i = 1 ; i < nums.length - 1 ; i++){
            if((nums[i] > nums[i-1]) && (nums[i] > nums[i+1])){
                return i;
            }
        }
        return -1;
    }
    //二分法
    public static int findPeakElement2(int[]nums){
       return binarySearch(nums);
    }
    public static int binarySearch(int[]nums){
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        int index = -1;
        while(left < right){
            middle = (right - left)/2 + left;
            if(comparator(nums,middle-1,middle) < 0 && comparator(nums,middle,middle+1) > 0){
                index = middle;
                break;
            }
            if(comparator(nums,middle,middle+1) < 0){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return index;
    }
    //用来处理边界情况
    public static int[]get(int[]nums,int index){
        if(index == -1 || index == nums.length){
            return new int[]{0,0};
        }
        return new int[]{1,nums[index]};
    }
    public static int comparator(int[]nums,int start,int end){
        int[]nums1 = get(nums,start);
        int[]nums2 = get(nums,end);
        if(nums1[0] != nums2[0]){
            return nums1[0] > nums2[0] ? 1 : -1;
        }
        if(nums1[1] == nums2[1]){
            return 0;
        }else{
            return nums1[1] > nums2[1] ? 1 : -1;
        }
    }
    public static void main(String[] args) {
        int[]nums = {1,2,3,1};
//        int[]nums = {1,2,1,3,5,6,4};
        int peak = findPeakElement2(nums);
        System.out.println(peak);
    }
}
