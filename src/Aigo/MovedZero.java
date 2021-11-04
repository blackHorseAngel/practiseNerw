package Aigo;

import static Aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/move-zeroes
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 *@Author zhangshenming
 *@Date 2021/9/12 16:25
 *@Version 1.0
 */
public class MovedZero {
    /**
     *@Description 双数组：重新开辟一个数组空的数组空间用来接收原数组中调整后的数字
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/9/12 17:20
     *@Return void
     */
    public static void moveZeroes1(int[] nums) {
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
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                arr[j] = nums[i];
                j++;
            }
        }
        printArray(arr);
    }

    /**
     *@Description 分三段循环：1、找到数组中第一个不为0的数；
     * 2、从第一个不为零的下一个数开始，快指针将后面不为0的数字替换到慢指针指的数字，快、慢指针每次均移动一个单位；
     * 3、当快指针遍历完整个数组之后，慢指针从所指向的元素到数组结束这之间的元素都变成0；
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/9/12 16:27
     *@Return void
     */
    public static void moveZeroes(int[] nums) {
        if(nums.length == 0){
            System.out.println("数组为空");
            return;
        }
        if(nums.length == 1){
            System.out.println("数组只有一个元素");
            System.out.println(nums[0]);
            return;
        }
        int p = 0;
        int q = 0;
        while(p<nums.length){
            if(nums[p] == 0){
                break;
            }else{
                p++;
            }
        }
        q = p+1;
        while(q < nums.length){
            if(nums[q] != 0){
                nums[p] = nums[q];
                p++;
            }
                q++;
        }
        for(;p<nums.length;p++){
            nums[p] = 0;
        }
        printArray(nums);
    }

    public static void main(String[] args) {
        int[]nums = {1,1,2,0,3,0,4};
//        int[]nums = {1,0,2,0,3,0,4};
//        int[]nums = {0,1,0,3,12};
//        int[]nums = {1,2,3,4,5,6,7};
        moveZeroes(nums);
//        moveZeroes1(nums);
    }
}
