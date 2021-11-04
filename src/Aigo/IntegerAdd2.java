package Aigo;

/**
 *@Desprition https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 给定一个已按照非递减顺序排列的整数数组numbers，你从数组中找出两个数满足相加之和等于目标数target。
 * 函数应该以长度为2的整数数组的形式返回这两个数的下标值。numbers的下标从1开始计数所以答案数组
 * 应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *@Author zhangshenming
 *@Date 2021/8/31 20:32
 *@Version 1.0
 */
public class IntegerAdd2 {
    /**
     *@Description 两数相加，双层循环
     *@Author zhangshenming
     *@Param numbers, target
     *@Date 2021/8/31 20:38
     *@Return int[]
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[]arr = new int[2];
        int a = 0;
        for(int i = 0;i < numbers.length;i++){
            for(int j = i+1;j < numbers.length;j++){
                a = numbers[i] + numbers[j];
                if(a > target){
                    break;
                }
                if(a == target){
                    arr[0] = i+1;
                    arr[1] = j+1;
                    return arr;
                }
            }
        }
        return arr;
    }
    /**
     *@Description 使用二分查找法
     *@Author zhangshenming
     *@Param numbers, target
     *@Date 2021/8/31 20:59
     *@Return int[]
     */
    public static int[]twoSum2(int[]numbers,int target){
        int[]arr = new int[2];
        int low = 0;
        int high = numbers.length-1;
        int sum = 0;
        while(low < high){
            sum = numbers[low] + numbers[high];
            if(sum > target){
                high--;
            }else if(sum < target){
                low++;
            }else if(sum == target){
                arr[0] = low + 1;
                arr[1] = high + 1;
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[]array = {2,3,4};
        int[]arr = new int[2];
        arr = twoSum2(array,6);
//        arr = twoSum(array,6);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
