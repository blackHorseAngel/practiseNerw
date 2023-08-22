package aigo.jump;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/22 22:30
 * @Version 1.0.0
 */
public class JumpV5 extends JumpSuper {
    public int maxIndex = 0;

    @Override
    public boolean canJump(int[] nums) {
       /* maxIndex = nums.length - 1;
        //下标
        int index = 0;
        //最远范围
        int far = 0;
        while(far < maxIndex) {
            int temp = index + nums[index];
            if(temp > far){
                far = temp;
            }
            if(index == far){
                return false;
            }
            index++;
        }
        return true;*/
        int maxIndex = nums.length - 1;
        int index = 0;
        int temp = 0;
        int far = 0;
        far = Math.min(maxIndex, nums[0]);
        while (index <= far) {
            temp = index + nums[index];
            if (temp >= maxIndex) {
                return true;
            }
            far = Math.max(far, temp);
            index++;
        }
        return false;
    }
}
