package Aigo.Single.Number;

/**
 *@Desprition https://leetcode-cn.com/problems/single-number/
 * 给定一个非空整数数组,除了某个元素只出现一次以外,其余每个元素均出现两次.找出那个只出现了一次的元素.
 * 你的算法应该具有线性时间复杂度.
 *@Author zhangshenming
 *@Date 2021/10/3 10:23
 *@Version 1.0
 */
public class SingleNumberV1 extends SingleNumberSuper {
    /**
     *@Description
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/3 10:23
     *@Return int
     */
    public int findSingleNumber(int[] nums) {
        int num = 0;
        if(nums.length == 0){
            return 0;
        }
        for(int i : nums){
            num ^=i;
        }
        return num;
    }

    public static void main(String[] args) {
//        int[]nums = {1,2,2};
        int[]nums = {4,1,2,1,2};
        SingleNumberV1 singleNumberV1 = new SingleNumberV1();
//        int num1 = singleNumberV1.findSingleNumber(nums);
//        System.out.println("不重复的那个数是：" + num1);
        int num2 = singleNumberV1.findSingleNumber(nums);
        System.out.println("不重复的那个数是：" + num2);
    }
}
