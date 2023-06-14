package Aigo.Sorted.Color;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/4 14:13
 * @Version 1.0.0
 */
public class SortColorsV2 extends SortColorsSuper{
    /**
     * 采用数组多指针的方式来完成夹逼，保证左边都是0，右边都是2，中间都是1
     * @param nums
     */
    @Override
    public void sortColors(int[] nums) {
        if(nums.length == 1){
            return;
        }
        //数组从左边开始第一个不是0的数字，先默认是-1，初始化之后有具体的位置
        int leftNotZero = -1;
        //数组从右边开始第一个不是2的数字，先默认是-1，初始化之后又具体的位置
        int rightNotTwo = -1;
        //找出右边第一个不是2的位置的方法
        rightNotTwo =  handleRightTwo(nums,rightNotTwo);
        //找出左边第一个不是0的位置的方法
        leftNotZero = handleLeftZero(nums,leftNotZero);
        //从左往右依次开始找,开始位置是leftNotZero，即第一个不是0的数，结束位置是rightNotTow，即第一个不是2的数
        sortNums(nums,leftNotZero,rightNotTwo);
    }

    /**
     * 对数字排序
     * @param nums
     * @param leftNotZero
     * @param rightNotTwo
     */
    private void sortNums(int[] nums,int leftNotZero,int rightNotTwo) {
        int index = leftNotZero ;
        while (index <= rightNotTwo){
                //从左往右如果找到2,左右两个数交换，右边的rightNotTwo左移1位
                if(nums[index] == 2){
                    swap(nums,index,rightNotTwo);
                    rightNotTwo = handleRightTwo(nums,rightNotTwo);
                    //处理完右边，处理左边，如果交换过来的数是0，那么判断当前0前面是0还是1，
                    //如果是0，那么leftNotZero往后移动;如果是1，把index对应的0和leftNotZero对应的1交换位置，然后leftNotZero+1
                    //最后index+1
                    if(nums[index] == 0){
                        if(index - 1 >= 0){
                            if(nums[index - 1] == 0){
                                leftNotZero = handleLeftZero(nums,leftNotZero);
                            }else{
                                swap(nums,leftNotZero,index);
                                leftNotZero++;
                            }
                        }
                    }
                    index++;
                    continue;
                }
                //从左往右如果找到1，如果当前1不是第一个元素，当前index的位置的前一个如果是0，那么leftNotZero正好是当前index的位置，index+1，
                // 当前index的位置的前一个如果是1，index+1
                //index所在位置是第一个元素，那么leftNotZero等于0，index+1
                if(nums[index] == 1){
                   index++;
                   continue;
                }
                //从左往右找，如果找到0
                if(nums[index] == 0){
                    //index不是第一个元素
                    if(index-1 >= 0){
                        //当前index的位置的前一个是0，这种情况不存在，已经被handleLeftZero处理了
                        if(nums[index-1] == 0){
                            index++;
                            //如果index的位置的前一个位置不是0，那么只能是1,把leftNotZero与index这两个位置的数字互换，然后leftNotZero+1，index+1
                        }else{
                            swap(nums,leftNotZero,index);
                            leftNotZero++;
                            index++;
                        }
                        //index是第一个元素，leftNotZero等于index，index+1
                    }else{
                        index++;
                    }
                }
            }
    }

    /**
     * 交换两个数，num是原始值，temp是中间值，num1是最终值
     * @param num
     * @param num1
     */
    private void swap(int[]nums,int num, int num1) {
         int temp = nums[num];
        nums[num] = nums[num1];
        nums[num1] = temp;
    }

    /**
     * 找出左边第一个不是0的位置
     * @param nums
     * @param leftNotZero
     * @return
     */
    private int handleLeftZero(int[] nums, int leftNotZero) {
        //说明是第一次进来，初始化leftNotZero
        if(leftNotZero == -1){
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i] != 0){
                    leftNotZero = i;
                    break;
                }
            }
            if(leftNotZero == -1 && nums[nums.length-1] == 0){
                leftNotZero = nums.length - 1;
            }
        }else{
            for(int i = leftNotZero ; i < nums.length ; i++){
                if(nums[i] != 0){
                    leftNotZero = i;
                    break;
                }
            }
        }
        return leftNotZero;
    }

    /**
     * 找出右边第一个不是2的位置
     * @param nums
     * @param rightNotTwo
     * @return
     */
    private int handleRightTwo(int[] nums, int rightNotTwo) {
        //说明是第一次进来，初始化rightNotTow
        if(rightNotTwo == -1){
            for(int i = nums.length - 1 ; i >= 0 ; i--){
                if(nums[i] != 2){
                    rightNotTwo = i;
                    break;
                }
            }
        }else{
            for (int i = rightNotTwo; i >= 0 ; i--) {
                if(nums[i] != 2){
                    rightNotTwo = i;
                    break;
                }
            }
        }
        return rightNotTwo;
    }

    public static void main(String[] args) {
        SortColorsV2 sortColors = new SortColorsV2();
//        int[]nums = new int[]{1,2,2,2,2,0,0,0,1,1};
//        int[]nums = new int[]{2,0,1};
//        int[]nums = new int[]{1,1,1,1,1};
//        int[]nums = new int[]{2,2,2,2,2};
        int[]nums = {0,2,2,2,0,2,1,1};
        sortColors.sortColors(nums);
        for (int i:nums) {
            System.out.println(i);
        }
//        int[][]nums = new int[12][];
//        int[]nums1 = {2,0,2,1,1,0};
//        int[]nums2 = {2,0,1};
//        int[]nums3 = {0};
//        int[]nums4 = {0,0};
//        int[]nums5 = {2,0};
//        int[]nums6 = {1,0,1};
//        int[]nums7 = {1,2,1};
//        int[]nums8 = {1,2,2,2,2,0,0,0,1,1};
//        int[]nums9 = {0,2,2,2,0,2,1,1};
//        int[]nums10 = {2,2,2,2,2,2,2};
//        int[]nums11 = {2,0,1};
//        int[]nums12 = {1,1,1,1,1,1};
//        nums[0] = nums1;
//        nums[1] = nums2;
//        nums[2] = nums3;
//        nums[3] = nums4;
//        nums[4] = nums5;
//        nums[5] = nums6;
//        nums[6] = nums7;
//        nums[7] = nums8;
//        nums[8] = nums9;
//        nums[9] = nums10;
//        nums[10] = nums11;
//        nums[11] = nums12;
//        for(int i = 0 ; i < nums.length ; i++){
//            SortColorsV2 sortColors = new SortColorsV2();
//            sortColors.sortColors(nums[i]);
//            for(int a:nums[i]){
//                System.out.print(a);
//                System.out.print("  ");
//            }
//            System.out.println();
//        }
    }
}
