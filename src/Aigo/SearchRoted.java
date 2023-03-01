package Aigo;

/**
 * @Description https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 输入：nums = [1], target = 0
 * 输出：-1
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * @Author Administrator
 * @Date 2023/2/27 15:01
 * @Version 1.0.0
 */
public class SearchRoted {
    //数组遍历,但是不满足O(logn)
    public static int search(int[] nums, int target) {
        for(int i : nums){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
    //二分法查找
    public static int search2(int[]nums,int target){
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else{
                return -1;
            }
        }else if(nums.length == 2){
            if(nums[0] == target){
                return 0;
            }else if(nums[1] == target){
                return 1;
            }else{
                return -1;
            }
        }
        int maxIndex = getMaxIndex(nums);
        int leftIndex = binarySearch(nums,target,0,maxIndex);
        int rightIndex = 0;
        if(leftIndex != -1){
            return leftIndex;
        }else{
            rightIndex = binarySearch(nums,target,maxIndex+1,nums.length-1);
            if(rightIndex != -1){
                return rightIndex;
            }
        }
        return -1;
    }
    //获取到数组单调增的最高点的数字值所对应的下标
    public static int getMaxIndex(int[]nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int temp = 0;
            if((i + 1) < nums.length){
               temp = nums[i+1] - nums[i];
                if(temp < 0){
                    return i;
                }
            }
        }
        return -1;
    }
    //
    public static int binarySearch(int[]nums,int target,int start,int end){
        int left = start;
        int right = end;
        int middle = 0;
        while(left <= right){
            middle = (right - left)/2 + left;
            if(nums[middle] > target){
                right = middle - 1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        int[]nums = {1};
//        int[]nums = {1,2};
//        int[]nums = {2,3,1};
//        int[]nums = {3,1,2};
        int[]nums = {1,3,5};
//        int[]nums = {4,5,6,7,0,1,2};
        int index = search2(nums,0);
        System.out.println(index);
    }
}
