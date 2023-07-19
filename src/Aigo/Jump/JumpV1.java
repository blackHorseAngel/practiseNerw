package Aigo.Jump;

/**
 * @Description https://leetcode.cn/problems/jump-game
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * @Author Administrator
 * @Date 2023/7/4 20:55
 * @Version 1.0.0
 */
public class JumpV1 extends JumpSuper {
    //    public static boolean flag = false
//    private int nums[];

    @Override
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        boolean[] flag = new boolean[nums.length];
        boolean result = findWay(nums, 0, flag);

        return result;
    }

    /**
     * @param nums
     */
    private boolean findWay(int[] nums, int index, boolean[] flag) {
        if (index + nums[index] >= nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        for (int i = nums[index]; i >= 1; i--) {
            if (index + i <= nums.length - 1) {
                if (flag[index]) {
                    continue;
                } else {
                    flag[i + index] = true;
                }
            }
            if (findWay(nums, index + i, flag)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpV1 jumpV1 = new JumpV1();
        //true
//        int[]nums = {2,3,1,1,4};
        //false
//        int[]nums = {3,2,1,0,4};
        //true
//        int[] nums = {2, 0};
        //true
//        int[]nums = {2,5,0,0};
        //false
//        int[]nums = new int[10000];
//        nums[0] = 9997;
//        for(int i = 9997 ; i >= 0 ; i--){
//            nums[9998-i] = i;
//        }
        boolean flag = jumpV1.canJump(nums);
        System.out.println(flag);
    }
}
