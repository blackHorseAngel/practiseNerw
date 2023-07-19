package Aigo.Combination.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/26 13:20
 * @Version 1.0.0
 */
public class CombinationSumV2 extends CombinationSumSuper{
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        if(target < candidates[0]){
            return Collections.emptyList();
        }
        //将从小到大排序的数组转成从大到小的顺序
        sortFromLargeToSmall(candidates);
        int count = 0;
        for(int i = 0 ; i < candidates.length ; i++){
            if(candidates[i] <= target){
                count = i;
                break;
            }
        }
        int[]candicatesNew = new int[candidates.length -  count];
        for(int i = count ; i < candidates.length ; i++){
            candicatesNew[i - count] = candidates[i];
        }
        //结果数组的长度，取决于target除以排序后的candidates的最小值的商
        int[] result = new int[candidates.length-count];
        //将candidates中的数字变成这些数字分别去除target的商得到该数字自己想变成target需要的次数
        int[] candidatesNumberCounts = new int[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            candidatesNumberCounts[i] = target / candidates[i];
        }
        //数组位数
        int num = 0;
        numberCombination(candidates, target, candidatesNumberCounts, result, num, resultList);
        return resultList;
    }
    /**
     * 把已经从小到大排序的数组调整为从大到小
     *
     * @param candidates
     */
    private void sortFromLargeToSmall(int[] candidates) {
        int before = 0;
        int after = candidates.length - 1;
        int temp = 0;
        while (before < after) {
            temp = candidates[before];
            candidates[before] = candidates[after];
            candidates[after] = temp;
            before++;
            after--;
        }
    }
    /**
     * @param candidates
     * @param target
     * @param num
     * @param resultList
     */
    private void numberCombination(int[] candidates, int target, int[] candidatesNumberCounts, int[] result, int num, List<List<Integer>> resultList) {
        if (num == candidates.length || resultList.size() == 150) {
            return;
        }
//        numberCombination(candidates, target, candidatesNumberCounts, result, num + 1, resultList);
        for (int j = 0; j <= candidatesNumberCounts[num]; j++) {
            result[num] = j;
            //如果是0，代表等于target；如果1，代表大于target，如果是2，代表小于target
            int comparator = compareTarget(result, candidates, target);
            if (comparator == 0) {
                transferToResultList(result, candidates, resultList);
                return;
            } else if (comparator == 1) {
                return;
            }
            numberCombination(candidates, target, candidatesNumberCounts, result, num + 1, resultList);
            clearResult(result,num);
        }
    }
    /**
     * @param result
     */
    private void clearResult(int[] result,int num) {
        for (int i = num + 1 ; i < result.length; i++) {
            result[i] = 0;
        }
    }
    /**
     * 跟taget进行比较，如果result中的数字和candidates中的对应的数字的乘积的和等于target，返回true，否则返回false
     * 如果是0，代表等于target；如果1，代表大于target，如果是2，代表小于target
     *
     * @param result
     * @param candidates
     * @param target
     * @return
     */
    private int compareTarget(int[] result, int[] candidates, int target) {
        //保留计算结果
        int a = 0;
//        int pos = 0;
//        for (int j = 0; j < result.length; j++) {
//            if (result[j] != 0) {
//                pos = j;
//                break;
//            }
//        }
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] != 0) {
                a += result[i] * candidates[i];
                if (a > target) {
                    return 1;
                }
            }
        }
        if (a == target) {
            return 0;
        } else if (a > target) {
            return 1;
        } else {
            return 2;
        }
    }
    /**
     * 将result和candidates中的对应的数字的乘积组成的结果集转换成list格式并返回，同时清空result以备下次使用
     *
     * @param result
     * @param candidates
     * @param resultList
     */

    private void transferToResultList(int[] result, int[] candidates, List<List<Integer>> resultList) {
        List<Integer> list = new ArrayList<>();
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] != 0) {
                for (int j = 0; j < result[i]; j++) {
                    list.add(candidates[i]);
                }
            }
        }
        resultList.add(list);
    }
    public static void main(String[] args) {
        //{{2，2，3}，{7}}
//        int[] candidates = {2, 3, 6, 7};
//        int target = 7;
        //{{2,2,2,2},{2,3,3},{3,5}}
//        int[] candidates = {2, 3, 5};
//        int target = 8;
        //[39, 37, 36, 34, 31, 30, 29, 28, 27, 24, 23, 22, 17, 16, 15, 14, 13, 12, 10, 8, 5, 4, 2]
        //[ 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  3, 3, 6, 7, 15]
        //{{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,4},{2,2,2,2,2,2,2,2,2,2,2,4,4},{2,2,2,2,2,2,2,2,2,4,4,4},
        // {2,2,2,2,2,2,2,4,4,4,4},{2,2,2,2,2,4,4,4,4,4},{2,2,2,4,4,4,4,4,4},{2,4,4,4,4,4,4,4},{}}
        int[] candidates = {2, 22, 4, 17, 28, 13, 39, 27, 24, 37, 12, 30, 5, 23, 29, 8, 16, 34, 15, 36, 14, 10, 31};
        int target = 30;
        CombinationSumV2 combinationSumV2 = new CombinationSumV2();
        List<List<Integer>> resultList = combinationSumV2.combinationSum(candidates, target);
        for (List<Integer> list : resultList) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
