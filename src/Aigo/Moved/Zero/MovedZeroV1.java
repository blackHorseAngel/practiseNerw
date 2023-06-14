package Aigo.Moved.Zero;

import static Aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/move-zeroes
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 *@Author zhangshenming
 *@Date 2021/9/12 16:25
 *@Version 1.0
 */
public class MovedZeroV1 extends MovedZeroSuper {
    /**
     *@Description 双数组：重新开辟一个数组空的数组空间用来接收原数组中调整后的数字
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/9/12 17:20
     *@Return void
     */
    public void moveZeroes(int[] nums) {
        if(nums.length == 0){
            System.out.println("数组为空");
            return;
        }
        if(nums.length == 1){
            System.out.println("数组只有一个元素");
            System.out.println(nums[0]);
            return;
        }
        int[]arr = new int[nums.length];
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                arr[j] = nums[i];
                j++;
            }
        }
        printArray(arr);
    }
    public static void main(String[] args) {
        int[]nums = {1,1,2,0,3,0,4};
//        int[]nums = {1,0,2,0,3,0,4};
//        int[]nums = {0,1,0,3,12};
//        int[]nums = {1,2,3,4,5,6,7};
        MovedZeroV1 movedZeroV1 = new MovedZeroV1();
         movedZeroV1.moveZeroes(nums);
//        moveZeroes1(nums);
    }
}
