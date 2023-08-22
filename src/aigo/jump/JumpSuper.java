package aigo.jump;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/4 20:54
 * @Version 1.0.0
 */
public class JumpSuper {
    public boolean canJump(int[] nums) {
      return false;
    }
    public int canJumpNew(int[]nums){
        return 0;
    }
    public static void main(String[] args) {
        //false
        int[]array = new int[10000];
        array[0] = 9997;
        for(int i = 9997 ; i >= 0 ; i--){
            array[9998-i] = i;
        }
        //true   true   false    true    true   false    true   true    true  true  false
        int[][] nums = {{1}, {0}, {0, 2},{1,2,3}, {2, 3, 1, 1, 4}, {3, 2, 1, 0, 4}, {2, 0}, {2, 5, 0, 0}, {1, 1, 1, 0}, {3, 0, 8, 2, 0, 0, 1},array};
        //new JumpV3()  new JumpV4() new JumpV5()
       /* JumpSuper jumpers[] = {new JumpV5()};
        for (int i = 0; i < nums.length; i++) {
            for (JumpSuper jump : jumpers){
                long startTime1 = System.currentTimeMillis();
                boolean flag1 = jump.canJump(nums[i]);
                long endTime1 = System.currentTimeMillis();
                System.out.println(jump.getClass().getName() + ":" + flag1);
                System.out.println(jump.getClass().getName() + ":" + (endTime1 - startTime1));
            }
        }*/
        JumpSuper[]jumpSupers = {new Jump2V1()};
        for(int i = 0 ; i < nums.length ; i++){
            for(JumpSuper jumpSuper:jumpSupers){
                long startTime1 = System.currentTimeMillis();
                int result = jumpSuper.canJumpNew(nums[i]);
                long endTime1 = System.currentTimeMillis();
                System.out.println(jumpSuper.getClass().getName() + ":" + result);
                System.out.println(jumpSuper.getClass().getName() + ":" + (endTime1 - startTime1));
            }
        }
    }

}
