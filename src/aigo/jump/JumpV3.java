package aigo.jump;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/20 17:04
 * @Version 1.0.0
 */
public class JumpV3 extends JumpSuper {
    private int len = 0;

    @Override
    public boolean canJump(int[] nums) {
        len = nums.length - 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int index = 0;
        //广度有限遍历
        while (!queue.isEmpty()) {
            //取到当前节点的下标
            index = queue.poll();
            //当下标等于数组长度的时候退出循环
            if (index == len) {
                return true;
            }
            //判断下一步的位置是否超过数组下标的最大值
            if (index + nums[index] > len) {
                return true;
            }
            //当前下标对应的数组中的值，从最大值到1开始遍历
            for (int i = 1; i <= nums[index]; i++) {
                int temp = index + i;
                queue.offer(temp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpV3 jumpV3 = new JumpV3();
        //false
//        int[]nums = new int[10000];
//        nums[0] = 9997;
//        for(int i = 9997 ; i >= 0 ; i--){
//            nums[9998-i] = i;
//        }
//        boolean flag = jumpV3.canJump(nums);
//        System.out.println(flag);
        //true   true   false    true   false    true   true    true  true
        int[][] nums = {{1}, {0}, {0, 2}, {2, 3, 1, 1, 4}, {3, 2, 1, 0, 4}, {2, 0}, {2, 5, 0, 0}, {1, 1, 1, 0}, {3, 0, 8, 2, 0, 0, 1}};
        for (int i = 0; i < nums.length; i++) {
            boolean flag = jumpV3.canJump(nums[i]);
            System.out.println(flag);
        }
    }
}
