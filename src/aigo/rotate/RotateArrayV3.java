package aigo.rotate;

import static aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:29
 * @Version 1.0.0
 */
public class RotateArrayV3 extends RotateArraySuper{
    /**
     *@Description 给定数组nums从第K个位置切分拆成前后两个数组并将前后两个数组对调
     *@Author zhangshenming
     *@Param nums, k
     *@Date 2021/9/6 0:01
     *@Return void
     */
    public void rotate(int[]nums,int k){
        if(nums.length == 1 || k == 0){
            printArray(nums);
            return;
        }
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        printArray(nums);
    }
    /**
     *@Description 反转数组
     *@Author zhangshenming
     *@Param nums, left, right
     *@Date 2021/10/6 10:04
     *@Return void
     */
    private void reverse(int[] nums, int left, int right) {
        int temp = 0;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[]array1 = {1,2,3,4,5,6,7};
        int target1 = 3;
        int[]array2 = {-1,-100,3,99};
        int target2 = 2;
        int[]array3 = {1,2,3};
        int target3 = 2;
        RotateArrayV3 rotateArrayV3 = new RotateArrayV3();
        rotateArrayV3.rotate(array1,target1);
        rotateArrayV3.rotate(array2,target2);
        rotateArrayV3.rotate(array3,target3);
    }
}
