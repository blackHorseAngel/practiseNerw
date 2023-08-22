package aigo.integer.Add;

import java.util.*;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/26 17:48
 * @Version 1.0.0
 */
public class IntegerAdd3V2 extends ThreeSumSuper{
    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> sumList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> numList = null;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    numList = new ArrayList<>();
                    temp = nums[i] + nums[j];
                    if (temp + nums[k] == 0) {
                        numList.add(nums[i]);
                        numList.add(nums[j]);
                        numList.add(nums[k]);
                        Collections.sort(numList);
                        set.add(numList);
                    }
                }
            }
        }
        if (set.size() != 0) {
            for (List<Integer> list : set) {
                sumList.add(list);
            }
        }
        return sumList;
    }
    public static void main(String[] args) {
        IntegerAdd3V2 integerAdd3V2 = new IntegerAdd3V2();
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = integerAdd3V2.threeSum(array);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list2 = list.get(i);
            for (int j = 0; j < list2.size(); j++) {
                System.out.println("数组" + i + "中的元素是：" + list2.get(j));
            }
        }
    }
}
