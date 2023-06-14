package Aigo.Binary.Search;

/**
 *@Desprition https://leetcode-cn.com/problems/first-bad-version/
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5)-> true
 * 调用 isBadVersion(4)-> true
 * 所以，4 是第一个错误的版本。
 * 输入：n = 1, bad = 1
 * 输出：1
 * 1 <= bad <= n <= 231 - 1
 *@Author zhangshenming
 *@Date 2021/8/29 19:22
 *@Version 1.0
 */
public class BinarySearch3 {
    /**
     *@Description
     *@Author zhangshenming
     *@Param n
     *@Date 2021/8/29 19:28
     *@Return int
     */
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(isBadVersion(mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    /**
     *@Description
     *@Author zhangshenming
     *@Param mid
     *@Date 2021/8/29 19:29
     *@Return boolean
     */
    private static boolean isBadVersion(int mid) {
        return false;
    }

    public static void main(String[] args) {
//        int[]array = initArray(5);
//        Arrays.sort(array);
//        printArray(array);
        int[]array = {-2,0,3,5,9,12};
//        int badVersion = firstBadVersion(5);
    }
}
