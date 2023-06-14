package Aigo.Rotate;

/**
 *@Desprition https://leetcode-cn.com/problems/rotate-array/
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 *@Author zhangshenming
 *@Date 2021/8/30 19:52
 *@Version 1.0
 */
public class RotateArrayV1 extends RotateArraySuper {
    /**
     *@Description 对数组进行移动位置操作，一次移动一个位置移动K次（超时）
     *@Author zhangshenming
     *@Param nums, k
     *@Date 2021/8/30 19:54
     *@Return void
     */
    public void rotate(int[] nums, int k) {
        int a = 0;
            for(int i = 1;i <= k;i++){
                a = nums[nums.length-1];
                for(int j = nums.length-1;j >= 0;j--){
                    if(j==0){
                        nums[j] = a;
                    }else{
                        nums[j] = nums[j-1];
                    }
                }
        }
    }
    public static void main(String[] args) {
        int[]array1 = {1,2,3,4,5,6,7};
        int target1 = 3;
        int[]array2 = {-1,-100,3,99};
        int target2 = 2;
        int[]array3 = {1,2,3};
        int target3 = 2;
        RotateArrayV1 rotateArrayV1 = new RotateArrayV1();
        rotateArrayV1.rotate(array1,target1);
        rotateArrayV1.rotate(array2,target2);
        rotateArrayV1.rotate(array3,target3);
    }
}
