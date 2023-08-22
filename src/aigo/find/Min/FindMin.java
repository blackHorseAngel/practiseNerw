package aigo.find.Min;

/**
 *@Desprition 局部最小值:一个给定的无序数组中,相邻的两个元素一定不相等,求局部最小,O(n)
 *@Author zhangshenming
 *@Date 2021/10/5 22:21
 *@Version 1.0
 */
public class FindMin extends FindMinSuper {
    /**
     *@Description
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 22:23
     *@Return int
     */
    public int findMin(int[]nums){
        if(nums.length == 0){
            return 0;
        }
        for(int i = 1;i < nums.length-2;i++){
            if((nums[i-1] > nums[i]) && (nums[i] < nums[i+1])){
                return nums[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[]nums = {1,3,2,9,4,1,-4,-2,-1,0};
        int min = findMin.findMin(nums);
        System.out.println("该数组中的局部最小值是：" + min);
    }
}
