package Aigo;

import java.util.*;

import static Aigo.util.Init.initArray;
import static Aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 答案中不可以包含重复的三元组。
 *@Author zhangshenming
 *@Date 2021/9/2 13:54
 *@Version 1.0
 */
public class IntegerAdd3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int a = 0;
        boolean flag = false;
        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
               a = nums[i] + nums[j];
                for(int k = j+1;k < nums.length;k++){
                    if(a + nums[k] == 0){
                        List<Integer>list2 = new ArrayList<Integer>();
                        list2.add(nums[i]);
                        list2.add(nums[j]);
                        list2.add(nums[k]);
                        for(List<Integer>list1:list){
                            flag = list1.containsAll(list2);
                            if(flag){
                                break;
                            }
                        }
                        if(!flag){
                            list.add(list2);
                        }
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
//        int[]array = initArray(5);
//        printArray(array);
        int[]array = {-1,0,1,2,-1,-4};
        List<List<Integer>>list = new ArrayList<List<Integer>>();
        List<Integer>list2 = new ArrayList<Integer>();
        list = threeSum(array);
        for(int i = 0;i<list.size();i++){
            list2 = list.get(i);
            for(int j = 0;j<list2.size();j++){
                System.out.println("数组"+i+"中的元素是："+list2.get(j));
            }
        }
    }
}
