package aigo.Summary.ranges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description https://leetcode.cn/problems/summary-ranges
 * 给定一个无重复元素的有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * @Author Administrator
 * @Date 2023/7/3 19:51
 * @Version 1.0.0
 */
public class SummaryRangesV1 extends SummaryRangesSuper{
    @Override
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0){
            return Collections.emptyList();
        }
        int firstIndex = 0;
        int secondIndex = 1;
        List<String>resultList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while(secondIndex< nums.length){
            if((nums[secondIndex] - nums[firstIndex]) != (secondIndex - firstIndex)){
                if(secondIndex - 1 - firstIndex == 0){
                    builder.append(nums[firstIndex]);
                    resultList.add(builder.toString());
                }else{
                    builder.append(nums[firstIndex]);
                    builder.append("->");
                    builder.append(nums[secondIndex - 1]);
                    resultList.add(builder.toString());
                }
                builder.setLength(0);
                firstIndex = secondIndex;
            }
            secondIndex++;
        }
        if(firstIndex == nums.length - 1){
            resultList.add(String.valueOf(nums[firstIndex]));
        }else{
            builder.append(nums[firstIndex]);
            builder.append("->");
            builder.append(nums[nums.length - 1]);
            resultList.add(builder.toString());
        }
        return resultList;
    }

    public static void main(String[] args) {
        SummaryRangesV1 summaryRangesV1 =new SummaryRangesV1();
        //["0->2","4->5","7"]
//        int[]nums = {0,1,2,4,5,7};
        //["0","2->4","6","8->9"]
        int[]nums = {0,2,3,4,6,8,9};
        List<String>resultList = summaryRangesV1.summaryRanges(nums);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }
}
