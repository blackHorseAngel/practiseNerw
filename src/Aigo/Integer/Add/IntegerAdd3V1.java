package Aigo.Integer.Add;

import java.util.*;

/**
 * @Desprition https://leetcode-cn.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 答案中不可以包含重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * @Author zhangshenming
 * @Date 2021/9/2 13:54
 * @Version 1.0
 */
public class IntegerAdd3V1 extends ThreeSumSuper {
    /**
     * 暴力破解，三循环，再去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int a = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                a = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (a + nums[k] == 0) {
                        List<Integer> list2 = new ArrayList<Integer>();
                        list2.add(nums[i]);
                        list2.add(nums[j]);
                        list2.add(nums[k]);
                        for (List<Integer> list1 : list) {
                            flag = list1.containsAll(list2);
                            if (flag) {
                                break;
                            }
                        }
                        if (!flag) {
                            list.add(list2);
                        }
                    }
                }
            }
        }
        return list;
    }
    /**
     * 对原始数组进行划分，找出重复项并记录重复次数，转化成数字对象（属性：1、各不相同的数字，2、每个数字的次数），然后对数字对象轮训，
     * 退出条件是找到符合+num[0]+num[1]+num[2]=0的3个数，或者某个数字的次数用尽了
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        //对数组进行排序并判断排序后的第一个元素是否大于0，如果是，那么证明这组有序的nums不可能找到3个数字合为0的组合，直接返回空列表
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return Collections.emptyList();
        }
        //将整理好的数字整理成有序的数字对象数组的形式
        Digit[] digits = handleNumsToArray(nums);
        //将条件数组按照是否有重复整理成map形式
//       Map<Integer,Integer> countMap;
//       countMap = handleNumsToMap(nums);
        //创建结果数组并赋初始值全部为整数最大值，为了避免后面求和为0的问题
        int[] result = generateResultArray();
        //创建结果list
        List<List<Integer>> resultList = new ArrayList<>();
        //轮循数字对象数组，找出三个数字为0的结果并放入结果list中
        calculation(digits, resultList, result, 0);
        return resultList;
    }


    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum5(int[] nums) {
        //对数组进行排序并判断排序后的第一个元素是否大于0，如果是，那么证明这组有序的nums不可能找到3个数字合为0的组合，直接返回空列表
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return Collections.emptyList();
        }
        //将整理好的数字整理成有序的数字和次数两个单数组的形式
        int[][] array = new int[2][];
        array = handleNumsToArrayNew(nums);
        int[] num = array[0];
        int[] time = array[1];
        //创建结果数组并赋初始值全部为整数最大值，为了避免后面求和为0的问题
        int[] resultTime = new int[num.length];
        //创建结果list
        List<List<Integer>> resultList = new ArrayList<>();
        //轮循数字对象数组，找出三个数字为0的结果并放入结果list中
        calculationForNumAndTime(num, time, resultTime, resultList, 0, 0);
        return resultList;
    }
    /**
     * 将排好序的原始数组转化为数字和次数两个数组并返回
     * @param nums
     * @return
     */
    private int[][] handleNumsToArrayNew(int[] nums) {
        int[][] array = new int[2][];
        List<Integer> numList = new ArrayList<>();
        List<Integer> timeList = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1]) {
                    count++;
                } else {
                    numList.add(nums[i]);
                    timeList.add(count);
                    count = 1;
                }
            } else {
                numList.add(nums[nums.length - 1]);
                timeList.add(1);
            }

        }
        int[] num = new int[numList.size()];
        int[] time = new int[timeList.size()];
        for (int i = 0; i < numList.size(); i++) {
            num[i] = numList.get(i);
            time[i] = timeList.get(i);
        }
        array[0] = num;
        array[1] = time;
        return array;
    }

    private void calculationForNumAndTime(int[] num, int[] time, int[] resultTime, List<List<Integer>> resultList, int count, int i) {
        if (count == 3) {
            sumAndAddResultToList(resultTime, num, resultList);
            for (int j = resultTime.length - 1; j >= 0; j--) {
                if (resultTime[j] != 0) {
                    if (resultTime[j] + 1 > time[i] || time[i] > 3) {
                        i++;
                    }
                    resultTime[j]--;
                    break;
                }
            }
            return;
        }
        while (i < time[i]) {
            if (resultTime[i] + 1 <= time[i]) {
                resultTime[i]++;
            } else {
                i++;
                continue;
            }
            calculationForNumAndTime(num, time, resultTime, resultList, count + 1, i);
        }
    }
    /**
     * 判断计算的数字之和是否是0，如果是0，将得到的3个数字加到结果集中，如果不是0，将resultTime中的最后加进去的数字的次数减1并返回
     *
     * @param resultTime
     * @param num
     * @param resultList
     * @return
     */
    private void sumAndAddResultToList(int[] resultTime, int[] num, List<List<Integer>> resultList) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < resultTime.length; i++) {
            if (resultTime[i] != 0) {
                list.add(num[i]);
                sum += num[i] * resultTime[i];
            }
        }
        if (sum == 0) {
            resultList.add(list);
        }
    }
    /**
     * @param digits
     * @param resultList
     * @param order
     */
    private void calculation(Digit[] digits, List<List<Integer>> resultList, int[] result, int order) {
        if (result[0] + result[1] + result[2] == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(result[0]);
            list.add(result[1]);
            list.add(result[2]);
            resultList.add(list);
        } else {
            if (order == 3) {
                return;
            }
        }

        for (int count = 0; count < digits.length; count++) {
            int num = digits[count].getNum();
            int time = digits[count].getTime();
            if (time <= 0) {
                continue;
            }
            result[order] = num;
            time = time - 1;
            digits[count].setTime(time);
            calculation(digits, resultList, result, order + 1);
        }

    }

    /**
     * 将有序的nums整理成数字对象数组
     *
     * @param nums
     * @return
     */
    private Digit[] handleNumsToArray(int[] nums) {
        List<Digit> digitList = new ArrayList<>();
        Digit digit = null;
        //将有序的nums中的所有的数字，以对象的形式添加到digitList中
        int p = 0;
        int q = p + 1;
        int time = 1;
        while (q <= nums.length) {
            if (nums[p] == nums[q]) {
                time++;
            } else {
                digit = new Digit();
                digit.setNum(nums[p]);
                digit.setTime(++time);
                digitList.add(digit);
                p = q;
                if (time != 1) {
                    time = 1;
                }
            }
            q++;
        }
        Digit[] digits = new Digit[digitList.size()];
        for (int i = 0; i < digitList.size(); i++) {
            digits[i] = digitList.get(i);
        }
        return digits;
    }

    /**
     * 生成结果数组
     *
     * @return
     */
    private int[] generateResultArray() {
        int[] result = new int[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        return result;
    }

    /**
     * @param nums
     * @return
     */
    private Map<Integer, Integer> handleNumsToMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                int count = countMap.get(nums[i]);
                count++;
                countMap.put(nums[i], count);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        return countMap;
    }

    /**
     * 数字对象，属性：1、数字；2、每个数字的次数
     */
    static class Digit {
        //数字
        int num;
        //次数
        int time;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public Digit() {
        }

        public Digit(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        IntegerAdd3V1 integerAdd3V1 = new IntegerAdd3V1();
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = integerAdd3V1.threeSum(array);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list2 = list.get(i);
            for (int j = 0; j < list2.size(); j++) {
                System.out.println("数组" + i + "中的元素是：" + list2.get(j));
            }
        }
    }
}
