package aigo.integer.Add;

import java.util.*;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/26 17:49
 * @Version 1.0.0
 */
public class IntegerAdd3V3 extends ThreeSumSuper {
    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //对数组进行排序,判断排序后的第一个数字是否大于0，以及最后一个数字是否小于0，如果是，那么nums不可能找到3个数字合为0的组合，直接返回空列表
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return Collections.emptyList();
        }
        //将整理好的数字整理成有序的数字和次数两个单数组的形式
        List<int[]> numAndTimeList = countNumTimesArray(nums);
        //创建结果数组并赋初始值全部为整数最大值，为了避免后面求和为0的问题
//        int[] resultTime = generateResultArray(numAndTimeList.get(0).length);
        int[]resultTime = new int[numAndTimeList.get(0).length];
        //创建结果list
        List<List<Integer>> resultList = new ArrayList<>();
        //计数器
        int count = 0;
        //轮循数字对象数组，找出三个数字为0的结果并放入结果list中
        findNumbers(numAndTimeList.get(0), numAndTimeList.get(1), count, resultList, resultTime);
        return resultList;
    }

    /**
     * 将排好序的原始数组转化为数字和次数两个数组并返回
     *
     * @param nums
     * @return
     */
    private List<int[]> countNumTimesArray(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        List<Integer> timeList = new ArrayList<>();
        int count = 1;
        int cur = nums[0];
        int index = 1;
        while (index < nums.length) {
            if (nums[index] == cur) {
                count++;
            } else {
                numList.add(cur);
                timeList.add(count);
                cur = nums[index];
                count = 1;
            }
            index++;
        }
        numList.add(cur);
        timeList.add(count);
        int[] num = new int[numList.size()];
        int[] time = new int[timeList.size()];
        for (int i = 0; i < numList.size(); i++) {
            num[i] = numList.get(i);
            time[i] = timeList.get(i);
        }
        List<int[]>numAndTimeList = new ArrayList<>();
        numAndTimeList.add(num);
        numAndTimeList.add(time);
        return numAndTimeList;
    }

    /**
     * 对数字数组进行遍历，如果该数字没有使用过，那么在结果次数数组上对应该数字的位置+1，如果该数字使用过，需要先判断该数字对应的次数数组中的次数是不是超了，
     * 如果没有超过，还是在结果次数数组上对应该数字的位置+1。
     * 每次对做完上述操作的结果次数数组和数字数组做求积再求和操作，先判断次数是否结果次数数组中的数字之和是否等于3，如果不等于3，不需要再欧求积求和操作，
     * 如果等于3，但是求积求和之后不等于0，这个组合不符合要求，不能放入结果集中，若求积求和之后等于0，将这组数字的组合放入结果集中
     *
     * @param num
     * @param time
     * @param count
     * @param resultList
     * @param resultTime
     */
    private void findNumbers(int[] num, int[] time, int count, List<List<Integer>> resultList, int[] resultTime) {
        if (count == num.length) {
            return;
        }
        for (int i = 0; i <= time[count]; i++) {
            resultTime[count] = i;
            int sum = 0;
            for (int j = 0; j < num.length; j++) {
                if (resultTime[j] != 0) {
                    sum += resultTime[j];
                }
            }
            if (sum == 3) {
                if (calculation(resultTime, num)) {
                    addResultToList(resultTime, num, resultList);
                }
                return;
            }
            findNumbers(num, time, count + 1, resultList, resultTime);
        }

    }

    /**
     * 计算拿到的数字和次数的组合是否等于0
     *
     * @param resultTime
     * @param num
     * @return
     */
    private boolean calculation(int[] resultTime, int[] num) {
        int sum = -1;
        for (int i = 0; i < resultTime.length; i++) {
            if (resultTime[i] != 0) {
                sum += num[i] * resultTime[i];
            }
        }
        if (sum == -1) {
            return true;
        }
        return false;
    }

    /**
     * 将上面判断完等于0的三个数字加入到结果集中
     *
     * @param resultTime
     * @param num
     * @param resultList
     * @return
     */
    private void addResultToList(int[] resultTime, int[] num, List<List<Integer>> resultList) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (resultTime[i] != 0) {
                for (int j = 0; j < resultTime[i]; j++) {
                    list.add(num[i]);
                }
            }
        }
        resultList.add(list);
    }

    /**
     * 初始化结果数组，将结果数组中的每个数都初始化为整数的最大值，为了避免后面求和为0的麻烦
     *
     * @return
     */
    private int[] generateResultArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {
        IntegerAdd3V3 integerAdd3V3 = new IntegerAdd3V3();
        //{{-1,-1,2},{-1,0,1}}
//        int[] array = {-1, 0, 1, 2, -1, -4};
        //{}
//        int[] array = {0,1,1};
        //{-1,0,1}
//        int[]array = {-1,0,1};
        //
        int[]array = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        List<List<Integer>> list = integerAdd3V3.threeSum(array);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list2 = list.get(i);
            for (int j = 0; j < list2.size(); j++) {
                System.out.println("数组" + i + "中的元素是：" + list2.get(j));
            }
        }
    }
}
