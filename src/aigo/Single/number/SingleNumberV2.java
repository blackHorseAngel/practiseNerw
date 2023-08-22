package aigo.Single.number;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:14
 * @Version 1.0.0
 */
public class SingleNumberV2 extends SingleNumberSuper{
    /**
     *@Description 空间换时间，创建一个map用来接收每个数字的出现次数
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 21:59
     *@Return int
     */
    public int findSingleNumber(int[]nums){
        //如果数组为空，直接返回0
        if(nums.length == 0){
            return 0;
        }
        //如果数组长度是1，直接返回数组中的这个元素
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
//        int[]nums = {1,2,2};
        int[]nums = {4,1,2,1,2};
        SingleNumberV1 singleNumberV1 = new SingleNumberV1();
//        int num1 = singleNumberV1.findSingleNumber(nums);
//        System.out.println("不重复的那个数是：" + num1);
        int num2 = singleNumberV1.findSingleNumber(nums);
        System.out.println("不重复的那个数是：" + num2);
    }
}

