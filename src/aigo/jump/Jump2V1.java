package aigo.jump;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description https://leetcode.cn/problems/jump-game-ii/
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 输入: nums = [2,3,0,1,4]
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * @Author Administrator
 * @Date 2023/7/24 8:48
 * @Version 1.0.0
 */
public class Jump2V1 extends JumpSuper {
    @Override
    public int canJumpNew(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int maxIndex = nums.length - 1;
        Queue<Integer> queue = new ArrayDeque<>();
        int index = 0;
        int count = 0;
        int cur = 0;
        queue.offer(0);
        while (!queue.isEmpty()) {
            index = queue.poll();
            //处理index+nums[index]越界的问题
            if(index > nums.length - 1){
                continue;
            }

            if((cur < index) && (nums[index] >= 1)){
                cur = Math.max(cur,index);
                count++;
            }

            for (int i = nums[index]; i >= 1; i--) {
                int temp = index + i;
                if(temp == maxIndex){
                    count++;
                   return count;
                }else {
                    queue.offer(temp);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //3   0  3  3  2  1  2
        int[][] nums = {{9,8,2,2,0,2,2,0,4,1,5,7,9,6,0,6,5,0,5},{0},{3,4,3,1,0,7,0,3,0,2,0,3},{1, 2, 1, 1, 1},{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3},{1,2},{2, 3, 1, 1, 4}};
        for(int[]num:nums){
            System.out.println(new Jump2V1().canJumpNew(num));
        }
    }
}
