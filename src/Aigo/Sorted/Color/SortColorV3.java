package Aigo.Sorted.Color;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/9 16:40
 * @Version 1.0.0
 */
public class SortColorV3 extends SortColorsSuper{
    //开始状态
    public static final int BEGIN = -1;
    //从左往右遇到全是0
    public static final int ALL_ZERO = 0;
    //从左往右遇到全是1
    public static final int ALL_ONE = 1;
    //从左到右遇到的是0和1的组合
    public static final int ZERO_AND_ONE = 2;
    //从左到右遇到的是1和0的组合
    public static final int ONE_AND_ZERO = 3;
    @Override
    public void sortColors(int[] nums) {
        int state = BEGIN;
        //数组中不是0的位置的开始，默认是数组的第一个
        int positionForNotZero = -1;
        //数组中不是2的位置的开始，默认是数组的最后一个
        int positionForNotTwo = nums.length - 1;
//        for(int i = 0 ; i < nums.length ; i++){
        int index = 0;
        while(index < nums.length){
            int num = nums[index];
            switch (state){
                case BEGIN:
                    if(num == 0){
                        state = ALL_ZERO;
                        index++;
                    } else if (num == 1) {
                        state = ALL_ONE;
                        positionForNotZero = 0;
                        index++;
                    }else{
                      positionForNotTwo = handleTwo(positionForNotTwo,index,nums);
                    }
                    break;
                case ALL_ZERO:
                    if(num == 0){
                        state = ALL_ZERO;
                        index++;
                    } else if (num == 1) {
                        state = ZERO_AND_ONE;
                        positionForNotZero = index;
                        index++;
                    }else{
                        positionForNotTwo = handleTwo(positionForNotTwo,index,nums);
                    }
                    break;
                case ALL_ONE:
                    if(num == 0){
                       state = ONE_AND_ZERO;
                    }else if (num == 1){
                        index++;
                    }else {
                        positionForNotTwo = handleTwo(positionForNotTwo,index,nums);
                    }
                    break;
                case ZERO_AND_ONE:
                    if(num == 0){
                        state = ONE_AND_ZERO;
                    }else if(num == 1){
                        index++;
                    } else if (num == 2) {
                        positionForNotTwo = handleTwo(positionForNotTwo,index,nums);
                    }
                    break;
                case ONE_AND_ZERO:
                    handleZero(positionForNotZero,index,nums);
                    positionForNotZero++;
                    state = ZERO_AND_ONE;
                    break;
                default:
                    break;
            }

            //如果右边第一个不是2的位置大于i或左边第一个不是0的位置大于i结束
            if(positionForNotTwo < index || positionForNotZero > index){
                break;
            }
        }

    }

    /**
     *
     * @param positionForNotZero
     * @param index
     * @param nums
     * @return
     */

    private void handleZero(int positionForNotZero, int index, int[] nums) {
        if(positionForNotZero <= index){
            swap(nums,positionForNotZero,index);
        }
    }

    /**
     * 遇到2，交换数组从结尾往前第一个不是2的数
     * @param positionForNotTwo
     * @param index
     */
    private int handleTwo(int positionForNotTwo, int index,int[]nums) {
        while(nums[positionForNotTwo] == 2){
            positionForNotTwo--;
            if(positionForNotTwo < 0){
                break;
            }
        }
        if(positionForNotTwo > index){
            swap(nums,index,positionForNotTwo);
            positionForNotTwo--;
        }
        return positionForNotTwo;
    }

    private void swap(int[] nums, int index, int positionForNotTwo) {
        int temp = nums[index];
        nums[index] = nums[positionForNotTwo];
        nums[positionForNotTwo] = temp;
    }

    public static void main(String[] args) {
//        int[]nums = new int[]{1,2,2,2,2,0,0,0,1,1};
//        int[]nums = new int[]{2,0,1};
//        int[]nums = new int[]{1,1,1,1,1};
//        int[]nums = new int[]{2,2,2,2,2};
//        int[]nums = {0,2,2,2,0,2,1,1};
//        SortColorV3 sortColors = new SortColorV3();
//        sortColors.sortColors(nums);
//        for (int i:nums) {
//            System.out.println(i);
//        }
        int[][]nums = new int[12][];
        int[]nums1 = {2,0,2,1,1,0};
        int[]nums2 = {2,0,1};
        int[]nums3 = {0};
        int[]nums4 = {0,0};
        int[]nums5 = {2,0};
        int[]nums6 = {1,0,1};
        int[]nums7 = {1,2,1};
        int[]nums8 = {1,2,2,2,2,0,0,0,1,1};
        int[]nums9 = {0,2,2,2,0,2,1,1};
        int[]nums10 = {2,2,2,2,2,2,2};
        int[]nums11 = {2,0,1};
        int[]nums12 = {1,1,1,1,1,1};
        nums[0] = nums1;
        nums[1] = nums2;
        nums[2] = nums3;
        nums[3] = nums4;
        nums[4] = nums5;
        nums[5] = nums6;
        nums[6] = nums7;
        nums[7] = nums8;
        nums[8] = nums9;
        nums[9] = nums10;
        nums[10] = nums11;
        nums[11] = nums12;
        for(int i = 0 ; i < nums.length ; i++){
            SortColorV3 sortColorV3 = new SortColorV3();
            sortColorV3.sortColors(nums[i]);
            for(int a:nums[i]){
                System.out.print(a);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
