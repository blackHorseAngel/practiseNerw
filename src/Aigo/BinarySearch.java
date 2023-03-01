package Aigo;

/**
 *@Desprition 二分查找法：给一个数组，给出数组的最小的下标，最大下标，中间下标，依次用中间下标对的数跟目标值比较，
 * 若目标值大于中间值，则在中间下标和最大下标之间，否则在最小下标和中间下标之间，确定了下一次的比较范围，重复上述过程
 * https://leetcode-cn.com/problems/binary-search/
 *@Author zhangshenming
 *@Date 2021/8/17 23:28
 *@Version 1.0
 */
public class BinarySearch {
    /**
     *@Description 若给定的数组是有序的,target在数组中继续二分查找，反之返回-1；
     *@Author zhangshenming
     *@Param nums, target
     *@Date 2021/8/29 17:21
     *@Return int
     */
    public static int search(int[] nums, int target) {
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
    public static int binarySearch(int[]nums,int target){
        int left = 0;
        int right = nums.length-1;
        int middle = 0;
        while(left <= right){
            middle = (right - left)/2 + left;
            int comparasion = comparator(nums,target,middle);
            if(comparasion > 0){
                right = middle -1;
            }else if (comparasion < 0){
                left = middle + 1;
            }else{
                return middle;
            }
        }
       return -1;
    }
    public static int comparator(int[]nums,int target,int index){
        if(index >= 0 && index < nums.length){
            if(nums[index] > target){
                return 1;
            } else if (nums[index] < target) {
                return -1;
            }else{
                return 0;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        int[]array = initArray(10);
//        Arrays.sort(array);
//        printArray(array);
//        int[]nums = {-1,0,3,5,9,12};
        int[]nums = {1};
        int a = binarySearch(nums,1);
        System.out.println(a);


    }
}
