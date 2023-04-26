package Aigo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode.cn/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 输入：nums = [1]
 * 输出：[[1]]
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * @Author Administrator
 * @Date 2023/4/14 14:35
 * @Version 1.0.0
 */
public class Permute {
    //
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>resultList = new ArrayList<>();
        List<Integer>numList = new ArrayList<>();
        for(int num:nums){
            numList.add(num);
        }
        int[]arr = new int[nums.length];
        getComposition(numList,arr,0,resultList);
        return resultList;
    }

    /**
     * 组合每个数字并返回结果
     * @param numList
     * @param count
     * @param resultList
     * @return
     */
    private static void getComposition(List<Integer>numList,int[]arr,int count,List<List<Integer>>resultList) {
        if(count > numList.size()){
            resultList = getArrayToList(arr, resultList);
        }
        for(int i = 0 ; i < numList.size();i++){
            if(count>0){
                numList.remove(arr[count-1]);
            }
            arr[count] = numList.get(i);
            getComposition(numList,arr,count+1,resultList);
        }
    }

    /**
     * 将数组的值转成list
     * @param arr
     * @param resultList
     * @return
     */
    private static List<List<Integer>> getArrayToList(int[] arr,List<List<Integer>>resultList) {
        List<Integer>list = new ArrayList<>();
        for(int i:arr){
            list.add(i);
        }
        resultList.add(list);
        return resultList;
    }

    public static void main(String[] args) {
        //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        int[]nums = {1,2,3};
        List<List<Integer>>resultList = permute(nums);
        for(List<Integer>list:resultList){
            for(int i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
