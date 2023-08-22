package aigo.jump;

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
    /**
     * 原数组的复制
     */
    private int[]array = null;
    /**
     * 标识位数组
     */
    private byte[]flag = null;
    /**
     * 数组长度
     */
    private int len = 0;

    @Override
    public boolean canJump(int[] nums) {
        this.array = nums;
        this.flag = new byte[nums.length];
        this.len = nums.length - 1;
        return findWay(0);
    }

    /**
     * 找到一条成功跳出去的路：
     * 1、站在当前位置，从当前位置对应数组中的数字的最大值开始向1递减遍历
     * 2、标记数组跟原始数组一样长
     * 3、每次遍历一个位置：如果可以跳出数组长度，直接返回true；如果不能跳出数组长度，这个位置记录为false，
     * 注：每次跳的位置是当前位置index + 当前位置对应的数组的数字，即：nums[index]
     *
     * @param index
     */
    private boolean findWay(int index) {
        for (int i = array[index]; i >= 0; i--) {
            int temp = index + i;
            if (temp < len) {
                if (flag[temp] == 1) {
                    return false;
                } else {
                    if (findWay(temp)) {
                        return true;
                    } else {
                        flag[temp] = 1;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpV1 jumpV1 = new JumpV1();
        //false
//        int[]nums = new int[10000];
//        nums[0] = 9997;
//        for(int i = 9997 ; i >= 0 ; i--){
//            nums[9998-i] = i;
//        }
//        boolean flag = jumpV1.canJump(nums);
//        System.out.println(flag);
        //true   false    true   true    true  true
        int[][] nums = {{2, 3, 1, 1, 4}, {3, 2, 1, 0, 4}, {2, 0}, {2, 5, 0, 0}, {1, 1, 1, 0}, {3, 0, 8, 2, 0, 0, 1}};
        for (int i = 0; i < nums.length; i++) {
            boolean flag = jumpV1.canJump(nums[i]);
            System.out.println(flag);
        }
    }
}
