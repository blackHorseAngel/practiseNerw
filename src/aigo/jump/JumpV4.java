package aigo.jump;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/22 16:43
 * @Version 1.0.0
 */
public class JumpV4 extends JumpSuper {
    private int maxIndex = 0;

    @Override
    public boolean canJump(int[] nums) {
        maxIndex = nums.length - 1;
        Queue<Integer> queue = new ArrayDeque<>(nums.length);
        queue.offer(0);
        byte[] flag = new byte[nums.length];
        flag[0] = 1;
        int index = 0;
        //广度优先遍历
        while (!queue.isEmpty()) {
            //取到当前节点的下标
            index = queue.poll();
            if (index == maxIndex) {
                return true;
            }
            int next = index + nums[index];
            //判断下一步的位置是否超过数组下标的最大值
            if (next >= maxIndex) {
                return true;
            }
            //当前下标对应的数组中的值，从最大值到1开始遍历
            for (int i = nums[index]; i >= 1; i--) {
                int temp = index + i;
                //判断下一步的位置是否打过标记,如果打过标记就跳过，如果没有打过标记，就打标记并把儿子节点加入队列
                if (flag[temp] != 1) {
                    flag[temp] = 1;
                    queue.offer(temp);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]array = new int[10000];
        array[0] = 9997;
        for(int i = 9997 ; i >= 0 ; i--){
            array[9998-i] = i;
        }
        System.out.println(new JumpV4().canJump(array));
    }
}
