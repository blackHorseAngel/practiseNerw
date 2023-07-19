package Aigo.Combination.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
 * @Author Administrator
 * @Date 2023/4/18 0:24
 * @Version 1.0.0
 */
public class CombinationSumV1 extends CombinationSumSuper {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            return Collections.emptyList();
        }
        //将从小到大排序的数组转成从大到小的顺序
        sortFromLargeToSmall(candidates);
        //结果数组的长度，取决于target除以排序后的candidates的最小值的商
        int[] result = new int[candidates.length];
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
        CombinationSumV1 combinationSumV1 = new CombinationSumV1();
        List<List<Integer>> resultList = combinationSumV1.combinationSum(candidates, target);
        for (List<Integer> list : resultList) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}