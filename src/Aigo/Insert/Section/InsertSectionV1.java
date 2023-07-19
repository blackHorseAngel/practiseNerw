package Aigo.Insert.Section;

import static Aigo.util.Print.printDoubleArray;

/**
 * @Description https://leetcode.cn/problems/insert-interval
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <=intervals[i][0] <=intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <=newInterval[0] <=newInterval[1] <= 105
 * @Author Administrator
 * @Date 2023/7/6 7:48
 * @Version 1.0.0
 */
public class InsertSectionV1 extends InsertSectionSuper{
    @Override
    public int[][] insert(int[][] intervals, int[] newInterval) {

        return null;
    }

    public static void main(String[] args) {
        InsertSectionV1 insertSectionV1 = new InsertSectionV1();
        //[[1,5],[6,9]]
//        int[][]intervals = {{1,3},{6,9}};
//        int[]newInterval = {2,5};
        //[[5,7]]
//        int[][]intervals = {};
//        int[]newInterval = {5,7};
        //[[1,5]]
//        int[][]intervals = {{1,5}};
//        int[]newInterval = {2,3};
        //[[1,7]]
        int[][]intervals = {{1,5}};
        int[]newInterval = {2,7};
        int[][]result = insertSectionV1.insert(intervals,newInterval);
        printDoubleArray(result);
    }
}
