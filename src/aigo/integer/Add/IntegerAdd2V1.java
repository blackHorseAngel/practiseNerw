package aigo.integer.Add;

import static aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 给定一个已按照非递减顺序排列的整数数组numbers，你从数组中找出两个数满足相加之和等于目标数target。
 * 函数应该以长度为2的整数数组的形式返回这两个数的下标值。numbers的下标从1开始计数所以答案数组
 * 应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 *@Author zhangshenming
 *@Date 2021/8/31 20:32
 *@Version 1.0
 */
public class IntegerAdd2V1 extends IntegerAddSuper {
    /**
     *@Description 两数相加，双层循环
     *@Author zhangshenming
     *@Param numbers, target
     *@Date 2021/8/31 20:38
     *@Return int[]
     */
    public int[] twoAdd(int[] numbers, int target) {
        int[]arr = new int[2];
        int sum = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            for(int j = i + 1 ; j < numbers.length ; j++){
                sum = numbers[i] + numbers[j];
                if(sum == target){
                    arr[0] = i+1;
                    arr[1] = j+1;
                    return arr;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        //[1,3]
//        int[]array = {2,3,4};
//        int target = 6;
        //[1,2]
//        int[]array = {2,7,11,15};
//        int target = 9;
        //[1,2]
        int[]array = {-1,0};
        int target = -1;
        IntegerAdd2V1 integerAdd2V1 = new IntegerAdd2V1();
        int[]arr = integerAdd2V1.twoAdd(array,target);
        printArray(arr);
    }
}
