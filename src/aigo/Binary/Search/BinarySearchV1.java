package aigo.Binary.Search;

/**
 *@Desprition https://leetcode-cn.com/problems/binary-search/
 * 二分查找法：给一个数组，给出数组的最小的下标，最大下标，中间下标，依次用中间下标对的数跟目标值比较，
 * 若目标值大于中间值，则在中间下标和最大下标之间，否则在最小下标和中间下标之间，确定了下一次的比较范围，重复上述过程
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。
 * nums的每个元素都将在[-9999, 9999]之间。
 *@Author zhangshenming
 *@Date 2021/8/17 23:28
 *@Version 1.0
 */
public class BinarySearchV1 extends BinarySearchSuper {
    /**
     *@Description 若给定的数组是有序的,target在数组中继续二分查找，反之返回-1；
     *@Author zhangshenming
     *@Param nums, target
     *@Date 2021/8/29 17:21
     *@Return int
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = (low+high)/2;
            if(nums[mid] < target){
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //4
//        int[]nums = {-1,0,3,5,9,12};
//        int target = 9;
        //-1
        int[]nums = {-1,0,3,5,9,12};
        int target = 2;
        BinarySearchV1 binarySearchV1 = new BinarySearchV1();
        int num = binarySearchV1.search(nums,target);
        System.out.println(num);
    }
}
