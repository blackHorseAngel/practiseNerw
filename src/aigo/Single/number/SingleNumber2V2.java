package aigo.Single.number;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:16
 * @Version 1.0.0
 */
public class SingleNumber2V2 extends SingleNumberSuper{
    /**
     *@Description
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 21:51
     *@Return int
     */
    public int findSingleNumber(int[]nums){
        //如果数组为空，直接返回0，没有出现一次的元素
        if(nums.length == 0){
            return 0;
        }
        //如果数组长度为1，直接返回这个元素
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int temp = 0;
        for (int i:map.keySet()) {
            temp = map.get(i);
            if(temp == 1){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
//        int[]nums = {7,7,7,8,8,8,1};
        int[]nums = {7,14,15,5,9,1};
//        int num = findSingleNumber2(nums);
        SingleNumber2V1 singleNumber2V1 = new SingleNumber2V1();
        int num = singleNumber2V1.findSingleNumber(nums);
        System.out.println("该数组中只出现后一次的数是：" + num);
    }
}
