package Aigo.Combination.Sum;

import java.util.*;

/**
 * @Description https://leetcode.cn/problems/combination-sum
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 *  @Author Administrator
 * @Date 2023/4/18 0:24
 * @Version 1.0.0
 */
public class CombinationSumV1 extends CombinationSumSuper {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>resultList = new ArrayList<>();
        Arrays.sort(candidates);
        if(target < candidates[0]){
            return resultList;
        }
        //结果数组的长度，取决于target除以排序后的candidates的最小值的商
        int[]result = new int[candidates.length];
        //将candidates中的数字变成这些数字分别去除target的商
        int[]candidatesNew = new int[candidates.length];
        for(int i = 0 ; i < candidates.length ; i++){
            candidatesNew[i] = target/candidates[i];
        }
        //数组位数
        int num = 0;
        //计数器
        int count = 0;
        numberCombination(candidates,target,candidatesNew,result,num,count,resultList);
        return resultList;
    }
    /**
     *
     * @param candidates
     * @param target
     * @param result
     * @param num
     * @param count
     * @param resultList
     *
     */
    private static void numberCombination(int[] candidates, int target,int[]candidatesNew, int[] result,int num,int count, List<List<Integer>> resultList) {
        if(count == 150){
            return;
        }
        if(num == candidates.length){
            return;
        }
            for (int j = 0 ; j <= candidatesNew[num];j++){
                result[num] = j;
                if(compareTarget(result,candidates,target)){
                    count++;
                    transferToResultListAndClear(result,candidates,resultList);
                }else{
                    numberCombination(candidates,target,candidatesNew,result,num+1,count,resultList);
                }
            }
        clearResult(result);
    }
    /**
     * 清楚result中的数据
     * @param result
     */
    private static void clearResult(int[] result) {
        for(int i = 0 ; i < result.length ; i++){
           result[i] = 0;
        }
    }
    /**
     * 将result和candidates中的对应的数字的乘积组成的结果集转换成list格式并返回，同时清空result以备下次使用
     * @param result
     * @param candidates
     * @param resultList
     */

    private static void transferToResultListAndClear(int[] result,int[]candidates, List<List<Integer>> resultList) {
        List<Integer>list = new ArrayList<>();
        int a = 0;
        for(int i = 0 ; i < result.length ; i++){
            for(int j = 0 ; j < result[i] ; j++){
                list.add(candidates[i]);
            }
            result[i] = 0;
        }
        resultList.add(list);
    }
    /**
     * 跟taget进行比较，如果result中的数字和candidates中的对应的数字的乘积的和等于target，返回true，否则返回false
     * @param result
     * @param candidates
     * @param target
     * @return
     */
    private static boolean compareTarget(int[] result, int[] candidates, int target) {
        //保留计算结果
        int a = 0;
        for(int i = 0 ; i < result.length ; i++){
            a = a + result[i] * candidates[i];
            if(a == target){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //{{2，2，3}，{7}}
//        int[]candidates = {2,3,6,7};
//        int target = 7;
        //{{2,2,2,2},{2,3,3},{3,5}}
        int[]candidates = {2,3,5};
        int target = 8;
        CombinationSumV1 combinationSumV1 = new CombinationSumV1();
        List<List<Integer>>resultList = combinationSumV1.combinationSum(candidates,target);
        for(List<Integer>list:resultList){
            for(int i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}