package aigo.jump;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/20 16:38
 * @Version 1.0.0
 */
public class JumpV2 extends JumpSuper{
    /**
     * 原数组的复制
     */
    private int[]array;
    /**
     * 标识位数组
     */
    private byte[]flag;
    /**
     * 数组长度
     */
    private int len;
    @Override
    public boolean canJump(int[] nums) {
        this.array = nums;
        this.flag = new byte[nums.length];
        this.len = nums.length - 1;
        if (array.length-1 == 0) {
            return true;
        } else {
            if (nums[0] == 0) {
                return false;
            }
        }
        return findWay(0);
    }

    /**
     * @param index
     * @return
     */
    private boolean findWay(int index) {
        if (flag[index] == 1) {
            return false;
        }
        for (int i = array[index]; i >= 1; i--) {
            int temp = index + i;
            if (temp >= array.length-1) {
                return true;
            }
            if (findWay(temp)) {
                return true;
            }
        }
        flag[index] = 1;
        return false;
    }

    public static void main(String[] args) {
        JumpV2 jumpV2 = new JumpV2();
        //false
        int[]array = new int[10000];
        array[0] = 9997;
        for(int i = 9997 ; i >= 0 ; i--){
            array[9998-i] = i;
        }
        //true   false    true   true    true  true
        int[][] nums = {{2, 3, 1, 1, 4}, {3, 2, 1, 0, 4}, {2, 0}, {2, 5, 0, 0}, {1, 1, 1, 0}, {3, 0, 8, 2, 0, 0, 1},array};
        for (int i = 0; i < nums.length; i++) {
            boolean flag = jumpV2.canJump(nums[i]);
            System.out.println(flag);
        }
    }
}
