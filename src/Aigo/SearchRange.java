package Aigo;

/**
 * @Description
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @Author Administrator
 * @Date 2023/2/24 9:16
 * @Version 1.0.0
 */
public class SearchRange {
    //数组遍历
    public static int[]searchRange1(int[]nums,int target){
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int[]index = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                index[0] = i;
                break;
            }
        }
        for(int j = nums.length - 1 ; j > 0 ; j--){
            if(nums[j] == target){
                index[1] = j;
                break;
            }
        }
        if(index[0] == 0 && index[1] == 0){
            index[0] = -1;
            index[1] = -1;
        }
        return index;
    }

    //二分查找法
    public static int[] searchRange2(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int leftIndex = binarySearchForLeft(nums,target,0);
        int rightIndex = 0;
        if(leftIndex < 0){
            return new int[]{-1,-1};
        }else{
            rightIndex =  binarySearchForRight(nums,target,leftIndex + 1);
            if(rightIndex == -1){
                rightIndex = leftIndex;
            }
            return new int[]{leftIndex,rightIndex} ;
        }
    }
    public static int binarySearchForLeft(int[]nums,int target,int index){
        int left = index;
        int right = nums.length-1;
        int middle = 0;
        int comparasionLeft = 0;
        while(left <= right){
            middle = (right -left)/2 + left;
            comparasionLeft = comparatorLeft(nums,target,middle);
            if(comparasionLeft > 0){
                right = middle - 1;
            }else if(comparasionLeft < 0){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    public static int comparatorLeft(int[]nums,int target,int index){
        if(nums[index] == target){
            if((index-1) >= 0 && (nums[index-1] < target)){
                return 0;
            }else if(index == 0){
                return 0;
            }else{
                return 1;
            }
        }else if (nums[index] < target){
            return -1;
        }else{
            return 1;
        }
    }
    public static int binarySearchForRight(int[]nums,int target,int index) {
        int left = index;
        int right = nums.length - 1;
        int middle = 0;
        int comparasionRight = 0;
        while (left <= right) {
            middle = (right - left) / 2 + left;
            /**
             *
             * f返回0，  表示找到了
             * 返回 -1 ， 需要需要往左找
             * 返回1， 需要往右找
             * */
            comparasionRight =comparatorRight(nums,target,middle);
            if (comparasionRight > 0) {
                right = middle - 1;
            } else if (comparasionRight < 0) {
                left = middle + 1;
            }else if (comparasionRight == 0){
                return middle;
            }
        }
        return -1;
    }
    public static int comparatorRight(int[]nums,int target,int index){
        if (nums[index] == target){
            if(((index+1) <= nums.length-1) && (nums[index+1] > target)) {
                return 0;
            }else  if(index == nums.length-1){
                return 0;
            }else{
                return -1;
            }
        }else if(nums[index] > target){
            return 1;
        }else{
            return -1;
        }
    }
    public static int binarySearch(int[]nums,int target,int index){
        int left = index;
        int right = nums.length-1;
        int middle = -1;
        int comparasion = -1;
        while(left <= right){
            middle = (right-left)/2 + left;
            comparasion = comparatorResult(nums,target,middle);
            if(comparasion == 0){
                break;
            }else if(comparasion > 0){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
       return middle;
    }

    private static int comparatorResult(int[] nums, int target, int index) {
        if(index >= 1 && index < nums.length-1){
            if(nums[index] > target){
                return 1;
            }else if(nums[index] < target){
                return -1;
            }else{
                return 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

//        int[]nums = {5,7,7,8,8,10};
//        int[]nums = {};
//        int[]nums = {6,6,6,6,6,6};
//        int[]nums = {1};
//        int[]nums = {1,3};
//        int[]nums = {1,2,3};
        int[]nums ={2,2};
        int[]index = searchRange2(nums,2);
        for(int i : index){
            System.out.println(i);
        }
    }
}
