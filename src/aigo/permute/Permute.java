package aigo.permute;

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
public class Permute extends PermuteSuper {
    //
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>resultList = new ArrayList<>();
        int[]arr = new int[nums.length];
        getComposition(nums,arr,0,resultList);
        return resultList;
    }

    /**
     * 组合每个数字并返回结果
     * @param count
     * @param resultList
     * @return
     */
    private void getComposition(int[]nums,int[]arr,int count,List<List<Integer>>resultList) {
        if(count == nums.length){
            resultList = getArrayToList(arr,resultList);
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            arr[count] = nums[i];
            getComposition(nums,arr,count+1,resultList);
        }
    }

    /**
     * 将数组的值转成list
     * @param arr
     * @param resultList
     * @return
     */
    private List<List<Integer>> getArrayToList(int[] arr,List<List<Integer>>resultList) {
        List<Integer>numList = new ArrayList<>();
        for(int i:arr){
            if(numList.contains(i)){
                numList.clear();
                break;
            }
            numList.add(i);
        }
        if(!numList.isEmpty()){
            resultList.add(numList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        int[]nums = {1,2,3};
        Permute permute = new Permute();
        List<List<Integer>>resultList = permute.permute(nums);
        for(List<Integer>list:resultList){
            for(int i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
