package aigo.rotate;

import static aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:30
 * @Version 1.0.0
 */
public class RotateArrayV4 extends RotateArraySuper{

    /**
     *@Description 借助额外的数组，将原来数组移动完之后放入新数组
     *@Author zhangshenming
     *@Param nums, k
     *@Date 2021/9/4 19:47
     *@Return void
     */
    public void rotate(int[]nums,int k){
        if(nums.length == 1 || k == 0){
            printArray(nums);
            return;
        }
        int length = nums.length;
        int[]arr = new int[length];
        if(k % length == 0){
            printArray(nums);
            return;
        }else{
            int n = k % length;
            for(int i = 0 ; i < length ; i++){
                if(i+n >= length){
                    arr[i+n-length] = nums[i];
                }else{
                    arr[i+n] = nums[i];
                }
            }
            nums = arr;
        }
        printArray(nums);
    }
    public static void main(String[] args) {
        int[]array1 = {1,2,3,4,5,6,7};
        int target1 = 3;
        int[]array2 = {-1,-100,3,99};
        int target2 = 2;
        int[]array3 = {1,2,3};
        int target3 = 2;
        RotateArrayV4 rotateArrayV4 = new RotateArrayV4();
        rotateArrayV4.rotate(array1,target1);
        rotateArrayV4.rotate(array2,target2);
        rotateArrayV4.rotate(array3,target3);
    }
}
