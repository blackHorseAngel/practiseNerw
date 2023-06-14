package Aigo.Find.Position;

/**
 *@Desprition 有序数组中，找到一个大于等于给定数字的最左/右侧的位置，若超出数组边界，返回-1
 *@Author zhangshenming
 *@Date 2021/10/5 22:06
 *@Version 1.0
 */
public class FindPosition extends FindPositionSuper {
    /**
     *@Description 二分法
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 22:09
     *@Return int
     */
    public int findPosition(int[]nums,int num){
        int left = 0;
        int right = nums.length-1;
        int middle = 0;
        while(left < right){
//            middle = left + ((right-left)>>1);
            middle = left + (right-left)/2;
            if(num > nums[middle]){
                left = middle + 1;
            }else if(num < nums[middle]){
                right = middle;
            }else{
                return middle-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FindPosition findPosition = new FindPosition();
        int[]nums = {1,3,4,5,6,7,8,9,10,12};
        int num = 8;
        int position = findPosition.findPosition(nums,num);
        System.out.println("找到的该数组中的比给定数大的左侧的位置是：" + position);
    }
}
