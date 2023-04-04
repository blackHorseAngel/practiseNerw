package Aigo;

/**
 * @Description https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 判题标准:
 * 系统会用下面的代码来测试你的题解:
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * int k = removeDuplicates(nums); // 调用
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按 升序 排列
 *
 * @Author Administrator
 * @Date 2023/3/29 14:35
 * @Version 1.0.0
 */
public class RemoveDuplicates {
    //数组双指针
    public static int removeDuplicates(int[] nums) {
        int index1 = 0;
        int index2 = 1;
        int length = nums.length;
        while(index2 < length){
            if(nums[index1] == nums[index2]){
                index2++;
            }else{
                index1++;
                nums[index1] = nums[index2];
            }

        }
        return index1+1;
    }
    //
    public static int removeDuplicates2(int[]nums){
        int temp = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++){
            while(temp == nums[i] && temp != nums[nums.length-1]){
              //TODO 从i+1开始到nums结束往前移动i
              moveOne(i,nums);
           }
           temp = nums[i];
        }
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] == nums[nums.length-1]){
                break;
            }
            count++;
        }
        return count+1 ;
    }


    private static void moveOne(int i, int[] nums) {
        for(int k = i + 1 ; k < nums.length ; k++){
            nums[k-1] = nums[k];
        }
    }

    public static void main(String[] args) {
       //2
//        int[] nums = {1,1,2};
        //5
        int[]nums = {0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates2(nums);
        System.out.println(count);
    }
}
