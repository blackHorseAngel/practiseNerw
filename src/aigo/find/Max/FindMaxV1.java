package aigo.find.Max;

/**
 *@Desprition 求一个数组中的最大值
 *@Author zhangshenming
 *@Date 2021/10/5 17:40
 *@Version 1.0
 */
public class FindMaxV1 extends FindMaxSuper {
    /**
     *@Description 使用递归的方式
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 17:41
     *@Return int
     */
    public int findMax(int[]nums,int left,int right){
        if(left == right){
            return nums[left];
        }
        //找出中间数，使用位移操作。开始位置加上一半的数组长度，这样操作没有溢出的危险。
        int middle = left + ((right - left)>>1);
        //找出中间数，使用除法操作，比位移操作慢。开始位置加上一半的数组长度，这样操作没有溢出的危险
//        int middle = left+(right - left)/2;
        //找出中间数，使用位移操作，但是如果数字过大，加法容易造成溢出
//        int middle = (left + right)>>1;
        //找出中间数，使用除法操作，速度比位移慢，但是如果数字过大，加法容易造成溢出
//        int middle = (left + right)/2;
        int leftMax = findMax(nums,left,middle);
        int rightMax = findMax(nums,middle+1,right);
        return Math.max(leftMax,rightMax);
    }
    /**
     *@Description 使用迭代的方式
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 20:24
     *@Return int
     */
    public int findMax(int[]nums){
        int temp = 0;
        for(int i = 0 ; i <= nums.length - 2 ; i++){
            if(nums[i] > nums[i + 1]){
                temp = nums[i];
            }else{
                temp = nums[i + 1];
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        FindMaxV1 findMaxV1 = new FindMaxV1();
        int[]nums = {1,2,5,4,3,6};
//        int maxValue = findMax(nums,0,nums.length-1);
        int maxValue = findMaxV1.findMax(nums);
        System.out.println("该数组中的最大值是："+maxValue);
    }
}
