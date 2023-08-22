package aigo.find.Min.Sum;

/**
 *@Desprition
 * 一个数组中，每一个数左边比当前数小的数累加起来叫做这个数字的小和。
 * 例如：[1,3,4,2,5],1左边比1小的数没有；3左边比3小的数是1；4左边比4小的数1,3；
 * 2左边比2小数是1；5左边比5小的数1,3,4,2。所以小和是1+1+3+1+1+3+4+2=16
 *@Author zhangshenming
 *@Date 2021/10/5 22:25
 *@Version 1.0
 */
public class FindMinSum extends FindMinSumSuper {
    /**
     *@Description 两重循环，第一重循环从第二个数开始，到数组的最后一个数结束，第二重循环从第一个数开始，到数组的倒数第二个数结束
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 22:27
     *@Return int
     */
    public int findMinSum(int[]nums){
        if(nums.length < 2){
            return 0;
        }
        //计数器，用来记录小和的个数
        int count = 0;
        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    count = count + nums[j];
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[]nums = {1,3,4,2,5};
        FindMinSum findMinSum = new FindMinSum();
        int sum = findMinSum.findMinSum(nums);
        System.out.println("该数组的最小和是："+ sum);
    }
}
