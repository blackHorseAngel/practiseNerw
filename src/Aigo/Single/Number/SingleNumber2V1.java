package Aigo.Single.Number;

/**
 *@Desprition https://leetcode-cn.com/problems/single-number-ii/
 *给你一个整数数组nums,除某个元素仅出现一次外,其余每个元素都恰出现三次.找出并返回那个只出现了一次的元素。
 *@Author zhangshenming
 *@Date 2021/10/3 10:41
 *@Version 1.0
 */
public class SingleNumber2V1 extends SingleNumberSuper {
    /**
     *@Description
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/3 10:42
     *@Return int
     */
    public int findSingleNumber(int[] nums) {
        int num = 0;
        //用来保存所有数字的各个位上的1的总和
        int[]array = new int[32];
        //找出数组中各个位上的1的总和
        for(int i = 0;i < array.length;i++){
            for(int j = 0;j < nums.length;j++){
                //array[i] += (nums[j] & (1 << i)) >> j;
                if((nums[j] & (1 << i)) != 0){
                    array[i]++;
                }
            }
        }
        int temp = 0;
        //将上面求出的1的总和与3做与操作，得到只出现一次的位数，用一个空的数字num和这个位数做或运算，得到该数组中只选一次的数字
        for(int k = 0;k < array.length;k++){
            temp = array[k] % 3;
                if(temp == 1){
                    num |= 1 << k;
                }
        }
        return num;
    }
    public static void main(String[] args) {
//        int[]nums = {7,7,7,8,8,8,1};
          int[]nums = {7,14,15,5,9,1};
//        int num = findSingleNumber2(nums);
        SingleNumber2V1 singleNumber2V1 = new SingleNumber2V1();
        int num = singleNumber2V1.findSingleNumber(nums);
        System.out.println("该数组中只出现后一次的数是：" + num);
    }
}
