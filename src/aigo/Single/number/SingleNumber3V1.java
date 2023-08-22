package aigo.Single.number;

import static aigo.util.Print.printArray;

/**
 *@Desprition 一个数组中只有两个元素出现了奇数次，其他元素都出现偶数次，找出这两个元素
 *@Author zhangshenming
 *@Date 2021/10/4 11:32
 *@Version 1.0
 */
public class SingleNumber3V1 extends SingleNumberSuper {
    /**
     *@Description 找到只出现奇数次的数
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/4 11:34
     *@Return int[]
     */
    public int[]findSingleNumberArray(int[]nums){
        int[]arr = new int[2];
        int num = 0;
        for(int i = 0;i < nums.length;i++){
            num ^= nums[i];
        }
        //提取出不为0的数字的位数中最右侧的1
        int rightOne = num & (~num + 1);
        int onlyOne = 0;
        for(int j = 0;j < nums.length;j++){
            if((j & rightOne) == 1){
                onlyOne ^= nums[j];
            }
        }
        arr[0] = onlyOne;
        arr[1] = num ^ onlyOne;
        return arr;
    }

    public static void main(String[] args) {
        int[]nums = {1,3,2,2,2,2,4,4,4,4,6,6,6,6,5,5,5,5,7,7};
        SingleNumber3V1 singleNumber3V1 = new SingleNumber3V1();
//        int[]arr = singleNumber3V1.finsSingleNumber(nums);
        int[]result = singleNumber3V1.findSingleNumberArray(nums);
       printArray(result);
    }
}
