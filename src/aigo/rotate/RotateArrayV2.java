package aigo.rotate;

import static aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:28
 * @Version 1.0.0
 */
public class RotateArrayV2 extends RotateArraySuper{
    /**
     *@Description 对数组进行移动位置操作，一次移动K个位置移动一次
     *@Author zhangshenming
     *@Param nums, k
     *@Date 2021/8/31 12:24
     *@Return void
     */
    public void rotate(int[]nums,int k){
        if(nums.length == 1 || k == 0){
            printArray(nums);
            return;
        }
        int length = nums.length;
        k = k%length;

        printArray(nums);
    }
    public static void main(String[] args) {
        int[]array1 = {1,2,3,4,5,6,7};
        int target1 = 3;
        int[]array2 = {-1,-100,3,99};
        int target2 = 2;
        int[]array3 = {1,2,3};
        int target3 = 2;
        RotateArrayV2 rotateArrayV2 = new RotateArrayV2();
        rotateArrayV2.rotate(array1,target1);
        rotateArrayV2.rotate(array2,target2);
        rotateArrayV2.rotate(array3,target3);
    }
}
