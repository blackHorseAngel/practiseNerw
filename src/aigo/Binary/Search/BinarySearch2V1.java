package aigo.Binary.Search;


/**
 *@Desprition https://leetcode-cn.com/problems/search-insert-position
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 *@Author zhangshenming
 *@Date 2021/8/29 17:29
 *@Version 1.0
 */
public class BinarySearch2V1 extends BinarySearchSuper {
    /**
     *@Description 查找出添加下一个元素的位置
     *@Author zhangshenming
     *@Param array
     *@Date 2021/8/29 17:32
     *@Return int
     */
    public  int search(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int mid =0;
        if(target < nums[0]){
            return 0;
        }else if(target > nums[nums.length-1]){
            return nums.length;
        }
        while(low <= high){
            mid = (high - low)/2 + low;
            if(target > nums[mid]){
                if(target < nums[mid+1]){
                    return mid + 1;
                }
                low = mid + 1;
            }else if(target < nums[mid]){
                if(target > nums[mid - 1]){
                    return mid;
                }
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //2
        int[]nums = {1,3,5,6};
//        int target = 5;
        //1
//        int target = 2;
        //4
        int target = 7;
        BinarySearch2V1 binarySearch2V1 = new BinarySearch2V1();
        int num = binarySearch2V1.search(nums,target);
        System.out.println("添加下一个元素的位置是：" + num);

    }
}
